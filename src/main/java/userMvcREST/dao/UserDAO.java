package userMvcREST.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import userMvcREST.model.User;

/**
 * @author Aldrovando
 * Version 2.0
 * Included getN(user_name)
 */
@Component
public class UserDAO {
	
	// Dummy database. Initialize with some dummy values.
		private static List<User> users;
		{
			users = new ArrayList<User>();
			//Integer id;String user_name;String email;
			//String password; String function;String cust_lic;
			//Integer lic_val; String cust_name;
			users.add(new User(101, "John Doe", "djohn@gmail.com", "teste101", "admin","2018-00000X", 30, "Test.com"));
			users.add(new User(201, "Russ Smith", "sruss@gmail.com","teste201", "user", "2018-00000X", 60, "Test.com"));
			users.add(new User(301, "Kate Williams", "kwilliams@gmail.com", "teste301", "fiscal", "2018-00000X",90, "Test.com"));
		}
		
		/**
		 * Returns list of users from dummy database.
		 * 
		 * @return list of users
		 */
		public List<User> list() {
			return users;
		}	

		/**
		 * Return user object for given id from dummy database. If customer is
		 * not found for id, returns null.
		 * 
		 * @param id
		 *            user id
		 * @return user object for given id
		 */
		public User get(Integer id) {

			for (User u : users) {
				if (u.getId().equals(id)) {
					return u;
				}
			}
			return null;
		}
		
		/**
		 * Return user object for given user_name from dummy database. If customer is
		 * not found for user_name, returns null.
		 * 
		 * @param user_name
		 *            user name
		 * @return user object for given user_name
		 */
		public User getN(String user_name) {

			for (User u : users) {
				if (u.getUser_name().equals(user_name)) {
					return u;
				}
			}
			return null;
		}
		
		/**
		 * Create new user in dummy database. Updates the id and insert new
		 * user in list.
		 * 
		 * @param user
		 *            User object
		 * @return user object with updated id
		 */
		public User create(User user) {
			user.setId(Thread.activeCount());
			users.add(user);
			return user;
		}
		
		/**
		 * Delete the user object from dummy database. If user not found for
		 * given id, returns null.
		 * 
		 * @param id
		 *            the user id
		 * @return id of deleted user object
		 */
		public Integer delete(Integer id) {

			for (User u : users) {
				if (u.getId().equals(id)) {
					users.remove(u);
					return id;
				}
			}

			return null;
		}
		
		/**
		 * Update the user object for given id in dummy database. If user
		 * not exists, returns null
		 * 
		 * @param id
		 * @param user
		 * @return user object with id
		 */
		public User update(Integer id, User user) {

			for (User u : users) {
				if (u.getId().equals(id)) {
					user.setId(u.getId());
					users.remove(u);
					users.add(user);
					return user;
				}
			}

			return null;
		}
		
		
}
