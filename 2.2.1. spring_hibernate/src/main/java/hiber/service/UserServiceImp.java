package hiber.service;

import hiber.dao.UserDao;
import hiber.dao.UserDaoImp;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp<T> implements UserService<T> {

    private UserDaoImp userDao;

    @Autowired
    UserServiceImp(UserDaoImp userDaoImp){
        this.userDao = userDaoImp;
    }

    @Transactional
    @Override
    public void add(T user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<T> getUsers() {
        return userDao.getUsers();
    }

    @Transactional
    @Override
    public List<T> usersWithSomeCar(String model, int serie) {
        return userDao.listUsersWithSomeCar(model,serie);
    }


}
