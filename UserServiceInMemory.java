package userManagementProgram1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserServiceInMemory implements UserService {
    private List<User> users;

    public UserServiceInMemory() {
        this.users = new ArrayList<>();
    }

    public UserServiceInMemory(List<User> users) {
        this.users = users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public Iterator<User> getUsers() {
        return users.iterator();
    }

    @Override
    public boolean exists(String email) {
        if (findIndex(email) >= 0) {
            return true;
        } else {
            return false;
        }
    }
    private int findIndex(String email) {
        int findIndex = -1;
        int currentIndex = 0;
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                findIndex = currentIndex;
                break;
            }
            currentIndex++;
        }
        return findIndex;
    }


    @Override
    public boolean updateUser(User user) {
        boolean deleteFlag = deleteUser(user.getEmail());
        if (deleteFlag) {
            users.add(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteUser(String email) {
        int index = findIndex(email);
        if (index > -1) {
            users.remove(index);
            return true;
        } else {
            return false;
        }
    }
}
