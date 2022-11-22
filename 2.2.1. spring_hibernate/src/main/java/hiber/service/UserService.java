package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService <T> {
    void add(T t);
    List<T> getUsers();

    List<T> getUsersWithSomeCar(String model, int serie);
}
