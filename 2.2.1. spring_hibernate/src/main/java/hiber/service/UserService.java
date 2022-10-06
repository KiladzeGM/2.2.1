package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {

    public User setUser(User user, String firstName, String lastName, String email, int series, String model);
    void add(User user);
    List<User> listUsers();
    User returnUser(int series, String model);
}
