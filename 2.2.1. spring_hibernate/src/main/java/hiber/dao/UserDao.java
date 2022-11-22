package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao<T> {
   void add(T user);
   List<T> getUsers();

   List<T> listUsersWithSomeCar(String model, int serie);
}
