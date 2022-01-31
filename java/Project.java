
import java.util.List;

import javax.transaction.SystemException;

import com.user.dao.UserDao;
import com.user.domain.User;


public class Project {

	public static void main(String[] args) throws IllegalStateException, SystemException {
		
		UserDao userDao=new UserDao();
		
		//save user
		User user= new User("Kiran","kiran.jadhav747878@gmail.com");
		userDao.saveUser(user);
		
		//Update user
		user.setName("kivi");
		userDao.UpdateUser(user);
		
		//get all user
		List<User> users = userDao.getAllUsers();
		//users.forEach(user1 ->System.out.println(user1.getId()));
		
		//Delete User
		userDao.deleteuser(user.getId());
	}
}
