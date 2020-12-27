package pl.zwolek.listofcarsthymeleafdb.daos;

import pl.zwolek.listofcarsthymeleafdb.models.Car;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface CarDao {

    void addCar(Car car);

    List<Car> getCars();

    List<Car> getCarsByProductionDateRange(Date from, Date to);


}
