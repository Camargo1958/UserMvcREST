package userMvcREST.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.json.JSONException;
import org.json.JSONObject;

import userMvcREST.dao.UserDAO;
import userMvcREST.model.User;

@RestController
@RequestMapping(value="/login")
public class LoginRestController {

	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/verify/{user_name}")
	public ResponseEntity getUserName(@PathVariable("user_name") String user_name) {

		System.out.println("Verify - user_name: "+user_name);
		User user = userDAO.getN(user_name);
		if (user == null) {
			return new ResponseEntity("No User found for name " + user_name, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(user, HttpStatus.OK);
	}
	
	//@PostMapping(value = "/loginp")
	@RequestMapping(value = "/loginp",method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity verifyUserP(@RequestBody String userdata) {
		System.out.println("Loginp - userdata: "+ userdata);
		JSONObject obj = new JSONObject(userdata);
		String rcv_name = "";
		String rcv_pwd = "";
		String user_name = "";
		String password = "";
		try {
			rcv_name = obj.getString("user_name");
			rcv_pwd = obj.getString("password");
			System.out.println("Loginp #1 - rcv_name: "+ rcv_name);
			System.out.println("Loginp #1 - rcvd password "+ rcv_pwd);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		User user = userDAO.getN(rcv_name);
		if (user == null) {
			return new ResponseEntity("No User found for name " + rcv_name, HttpStatus.NOT_FOUND);
		} else {
			user_name = user.getUser_name();
			System.out.println("Loginp #2 - user_name: "+user_name);
			password = user.getPassword();
			System.out.println("Loginp #2 - password: "+password);
		}
				
		if(!(password.equals(rcv_pwd))) {
			System.out.println("Loginp - Password do not match ");
			return new ResponseEntity("Password do not match " + rcv_name, HttpStatus.OK);
		}
		return new ResponseEntity(user, HttpStatus.OK);	
	}
}
