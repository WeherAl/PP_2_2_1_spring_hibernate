package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp<T> implements UserService<T> {

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

    @Transactional
    @Override
    public List<T> usersWithSomeCar(String model, int serie) {
        return userDao.listUsersWithSomeCar(model,serie);
    }


}
