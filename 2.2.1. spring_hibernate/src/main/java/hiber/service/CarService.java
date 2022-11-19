package hiber.service;

import java.util.List;

public interface CarService<T> {
    void add(T t);

    List<T> listUsers();
}
