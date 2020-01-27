package it.iad.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.iad.business.Users;
import it.iad.model.UserInfo;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	
    @ApiOperation(value = "Get users Returns a list of users, filtered according to query parameters", nickname = "getAllUsers", notes = "", response = UserInfo.class, responseContainer = "List", tags={ "user-provider", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "success", response = UserInfo.class, responseContainer = "List") })
    @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserInfo>> getAllUsers(
    		@ApiParam(value = "number of records to skip", example = "0") @Valid @RequestParam(value = "skip", required = false) Integer skip,
    		@ApiParam(value = "max number of records to return", example="0") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
    	try {
            return new ResponseEntity<>(
            		Users.getUsers(),
            		HttpStatus.OK);
        } catch (Exception e) {
            log.error("Errore recupero utenti", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @ApiOperation(value = "Get user by username", nickname = "getUserByName", notes = "", response = UserInfo.class, tags={ "user-provider", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "success", response = UserInfo.class),
        @ApiResponse(code = 401, message = "not found") })
    @GetMapping(path = "/user/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInfo> getUserByName(
    		@ApiParam(value = "The username for the user",required=true) @PathVariable("username") String username) {
    	try {
        	UserInfo user = Users.getUserByName(username);
            return new ResponseEntity<>(
            		user,
            		(null == user) ? HttpStatus.UNAUTHORIZED : HttpStatus.OK);
        } catch (Exception e) {
            log.error("Errore recupero utente", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
