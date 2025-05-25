package practice;

import java.util.List;

public class User {
    private Integer id;
    private String email;
    private String username;
    private List<Group> groups;

    public User(String email, String username, List<Group> groups) {
        this.email = email;
        this.username = username;
        this.groups = groups;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
