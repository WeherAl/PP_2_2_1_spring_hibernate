package hiber.service;

import hiber.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CarServiceImp<T> implements CarService<T> {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(T user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<T> listUsers() {
        return userDao.listUsers();
    }

}
