package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService <T> {
    void addUser(T t);
    List<T> getUsers();

    List<T> getUsersWithSomeCar(String model, int serie);
}
