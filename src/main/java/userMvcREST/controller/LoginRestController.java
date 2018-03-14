package userMvcREST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import userMvcREST.dao.UserDAO;
import userMvcREST.model.User;

@RestController
@RequestMapping(value="/login")
public class LoginRestController {

	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/verify/{user_name}")
	public ResponseEntity getUserName(@PathVariable("user_name") String user_name) {

		User user = userDAO.getN(user_name);
		if (user == null) {
			return new ResponseEntity("No User found for name " + user_name, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(user, HttpStatus.OK);
	}
}
