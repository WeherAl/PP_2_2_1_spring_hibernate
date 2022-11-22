package hiber.service;

import hiber.dao.CarDaoImp;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class CarServiceImp<T> implements CarService {

    private CarDaoImp carDaoImp;

    @Autowired
    private CarServiceImp(CarDaoImp carDaoImp) {
        this.carDaoImp = carDaoImp;
    }

    @Transactional
    @Override
    public void addCar(Car car) {
        carDaoImp.addCar(car);
    }

    @Override
    public List<Car> getCars() {
        return carDaoImp.getCars();
    }

}
