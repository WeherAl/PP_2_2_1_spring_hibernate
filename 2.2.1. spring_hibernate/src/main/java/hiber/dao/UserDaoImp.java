package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp<T> implements UserDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(T user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> listUsers() {
        TypedQuery<T> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public List<T> listUsersWithSomeCar(String model, int serie) {

        String HQL="from User user WHERE user.car.model=:modelName AND user.car.series=:series";

        TypedQuery<T> query = sessionFactory.getCurrentSession().createQuery
                (HQL);

        query.setParameter("modelName", model);
        query.setParameter("series", serie);


        return query.getResultList();


    }

}
