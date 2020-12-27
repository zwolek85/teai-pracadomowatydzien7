package pl.zwolek.listofcarsthymeleafdb.services;


import pl.zwolek.listofcarsthymeleafdb.dto.DateRange;
import pl.zwolek.listofcarsthymeleafdb.models.Car;

import java.util.Date;
import java.util.List;

public interface CarService {

    List<Car> getCars();

    List<Car>  getCarsByProductionDateRange(DateRange dateRange);

    void addCar(Car car);

}
