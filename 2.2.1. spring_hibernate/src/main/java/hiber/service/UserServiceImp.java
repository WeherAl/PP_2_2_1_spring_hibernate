package hiber.service;

import hiber.dao.UserDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class UserServiceImp<T> implements UserService<T> {

    private UserDaoImp userDao;

    @Autowired
    private UserServiceImp(UserDaoImp userDaoImp){
        this.userDao = userDaoImp;
    }

    @Transactional
    @Override
    public void add(T user) {
        userDao.add(user);
    }

    @Override
    public List<T> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public List<T> getUsersWithSomeCar(String model, int serie) {
        return userDao.listUsersWithSomeCar(model,serie);
    }


}
