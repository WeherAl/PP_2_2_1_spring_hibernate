package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;
import java.util.List;

public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car t) {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List listUsers() {
        TypedQuery query = sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }

}
