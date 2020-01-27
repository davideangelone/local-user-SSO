package it.iad.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2UiConfiguration implements WebMvcConfigurer {
	
	
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Axepta SSO Local Application User Provider API")
            .description("Allow to application handle local application databases")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("")
            .version("1.0.0")
            .contact(new Contact("","", "daniele.fiungo@iad2.it"))
            .build();
    }
	

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                	.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                    .build()
                .apiInfo(apiInfo());
    }
    

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) 
    {
        //enabling swagger-ui part for visual documentation
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}