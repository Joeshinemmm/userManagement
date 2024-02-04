package userManagementProgram1;

import java.io.Serializable;

public class User implements Serializable {
    private String email;
    private String name;
    private int birthday;

    public User(String email, String name, int birthday) {
        this.email = email;
        this.name = name;
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birthYear=" + birthday +
                '}';
    }
}
