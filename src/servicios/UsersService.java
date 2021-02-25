package servicios;

import java.util.List;

import modelo.User;

public interface UsersService {

	public void registerUser(User user);
	public User getUserByNameAndPassword(String name, String password);
	public List<User> getAllUsers();
	public void deleteUser(long userId);
	public User getUserById(long userId);
	public void saveUserChanges(User user);

}
