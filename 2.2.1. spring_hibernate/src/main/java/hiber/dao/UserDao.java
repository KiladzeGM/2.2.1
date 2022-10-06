package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   User setUser(User user, String firstName, String lastName, String email, int series, String model);
   void add(User user);
   List<User> listUsers();

   User returnUser(int series, String model);
}
