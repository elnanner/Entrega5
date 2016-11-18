package clasesDAO;

import clases.User;

public interface UserDAO extends GenericDAO<User> {
	public Boolean credentialsLogin(String userName,String pass);
	public User login(String userName,String pass);
}
