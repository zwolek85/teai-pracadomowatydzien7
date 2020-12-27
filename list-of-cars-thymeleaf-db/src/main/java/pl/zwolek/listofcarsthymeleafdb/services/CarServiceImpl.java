package pl.zwolek.listofcarsthymeleafdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zwolek.listofcarsthymeleafdb.daos.CarDao;
import pl.zwolek.listofcarsthymeleafdb.dto.DateRange;
import pl.zwolek.listofcarsthymeleafdb.models.Car;

import java.util.*;

@Service
class CarServiceImpl implements CarService {
    private CarDao carDao;

    @Autowired
    CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getCars() {
        List<Car> cars = carDao.getCars();
        cars.sort(Comparator.comparing(Car::getId));
        return cars;
    }

    @Override
    public List<Car> getCarsByProductionDateRange(DateRange dateRange) {
        return carDao.getCarsByProductionDateRange(dateRange.getProductionDateFrom(), dateRange.getProductionDateTo());
    }


    @Override
    public void addCar(Car car) {
        carDao.addCar(car);
    }

}
