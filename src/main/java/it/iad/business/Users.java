package it.iad.business;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.beanutils.BeanUtils;
import org.yaml.snakeyaml.Yaml;

import it.iad.model.LoginCredential;
import it.iad.model.LoginResponse;
import it.iad.model.UserActionRequired;
import it.iad.model.UserInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Users {
	
	private Users() {
	}
	
	private static Iterable<Object> getUsersInternal() {
		try {
			return new Yaml().loadAll(new FileInputStream(System.getenv("USERS_FILE")));
		} catch (FileNotFoundException e) {
			log.warn("File utenti non trovato!");
			return new ArrayList<>();
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public static List<UserInfo> getUsers() throws IllegalAccessException, InvocationTargetException {
		
		List<UserInfo> users = new ArrayList<>();
		for (Object obj : getUsersInternal()) {
			Map<String, Map<String, Map<String, Object>>> o = (Map<String, Map<String, Map<String, Object>>>) obj;
			for (Map.Entry<String,Map<String, Map<String, Object>>> m : o.entrySet()) {
				UserInfo u = new UserInfo();
				u.setUsername(m.getKey());
				BeanUtils.populate(u, m.getValue().get("details"));
				users.add(u);
			}
		}
		
		return users;
	}
	
	@SuppressWarnings("unchecked")
	public static UserInfo getUserByName(String name) throws IllegalAccessException, InvocationTargetException {
		
		UserInfo result = null;
		
		for (Object obj : getUsersInternal()) {
			Map<String, Map<String, Map<String, Object>>> o = (Map<String, Map<String, Map<String, Object>>>) obj;
			Map<String, Map<String, Object>> user = o.get(name);
			if (null != user) {
				result = new UserInfo();
				result.setUsername(name);
				BeanUtils.populate(result, user.get("details"));
			}
		}
		
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public static LoginResponse validateCredentials(LoginCredential credentials) {
		LoginResponse response = null;
		if (null != credentials) {

			for (Object obj : getUsersInternal()) {
				Map<String, Map<String, String>> o = (Map<String, Map<String, String>>) obj;
				Map<String, String> userProps = o.get(credentials.getUsername());
				if ( (null != userProps) && credentials.getPassword().equals(userProps.get("password"))) {
					response = new LoginResponse();
					response.setActive(true);
					
					UserActionRequired action = UserActionRequired.values()[new Random().nextInt(4)];
					response.setUserActionRequired(Arrays.asList(action));
				}
			}
		}
		
		return response;
	}
	
}
