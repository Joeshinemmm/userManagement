package userManagementProgram1;

import java.util.Iterator;

public interface UserService {
    public void addUser(User user); //1
    public Iterator<User> getUsers(); //2
    public boolean updateUser(User user); //3
    public boolean deleteUser(String email); //4

    public boolean exists(String email); //3,4

}
