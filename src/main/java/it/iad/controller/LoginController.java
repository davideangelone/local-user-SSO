package it.iad.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.iad.business.Users;
import it.iad.model.LoginCredential;
import it.iad.model.LoginResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LoginController {
	
    @ApiOperation(value = "Check credentials", nickname = "validateCredentials", notes = "", response = LoginResponse.class, tags={ "login-provider", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "User credential is valid", response = LoginResponse.class),
        @ApiResponse(code = 401, message = "User not found or credential not vaild") })
    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponse> validateCredentials(
    		@ApiParam(value = "")  @Valid @RequestBody LoginCredential body) {
    	
        try {
        	LoginResponse loginResponse = Users.validateCredentials(body);
            return new ResponseEntity<>(
            		loginResponse,
            		(null == loginResponse) ? HttpStatus.UNAUTHORIZED : HttpStatus.OK);
        } catch (Exception e) {
            log.error("Errore validazione credenziali utente", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }


}
