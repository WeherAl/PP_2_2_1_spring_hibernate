package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao<T> {
   void addUser(T user);
   List<T> getUsers();

   List<T> listUsersWithSomeCar(String model, int serie);
}
