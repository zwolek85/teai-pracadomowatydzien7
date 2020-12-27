package pl.zwolek.listofcarsthymeleafdb.inits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.zwolek.listofcarsthymeleafdb.daos.CarDao;
import pl.zwolek.listofcarsthymeleafdb.enums.Color;
import pl.zwolek.listofcarsthymeleafdb.models.Car;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static pl.zwolek.listofcarsthymeleafdb.enums.Color.*;

@Service
class InitCarList {

    private CarDao carDao;

    @Autowired
    InitCarList(CarDao carDao) {
        this.carDao = carDao;
    }

//    @EventListener(ApplicationReadyEvent.class)
//    void initCarList() throws ParseException {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        carDao.addCar(new Car("Audi", "A6", BLACK, simpleDateFormat.parse("12-06-2011")));
//        carDao.addCar(new Car("Toyota", "Auris", RED, simpleDateFormat.parse("01-01-2001")));
//        carDao.addCar(new Car("Opel", "Astra", GREEN, simpleDateFormat.parse("23-04-2017")));
//    }
}
