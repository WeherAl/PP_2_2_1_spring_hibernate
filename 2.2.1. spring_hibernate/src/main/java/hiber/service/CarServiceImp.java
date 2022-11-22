package hiber.service;

import hiber.dao.CarDaoImp;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImp<T> implements CarService {

    private CarDaoImp carDaoImp;

    @Autowired
    CarServiceImp(CarDaoImp carDaoImp) {
        this.carDaoImp = carDaoImp;
    }

    @Transactional
    @Override
    public void add(Car car) {
        carDaoImp.add(car);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> listUsers() {
        return carDaoImp.getCars();
    }

}
