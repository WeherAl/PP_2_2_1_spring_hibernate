package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    private SessionFactory sessionFactory;

    @Autowired
    CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car t) {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List getCars() {
        TypedQuery query = sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }

}
