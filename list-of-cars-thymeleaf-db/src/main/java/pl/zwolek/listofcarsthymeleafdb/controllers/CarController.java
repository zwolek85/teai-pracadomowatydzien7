package pl.zwolek.listofcarsthymeleafdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.zwolek.listofcarsthymeleafdb.dto.DateRange;
import pl.zwolek.listofcarsthymeleafdb.models.Car;
import pl.zwolek.listofcarsthymeleafdb.services.CarService;
import pl.zwolek.listofcarsthymeleafdb.utils.DateUtil;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCars(Model model) {
        List<Car> cars = carService.getCars();
        model.addAttribute("cars", cars);
        model.addAttribute("dateRange", new DateRange());

        return "cars";
    }

    @PostMapping("/cars")
    public String findCars(Model model, @Valid @ModelAttribute DateRange dateRange, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cars";
        }
        List<Car> cars = carService.getCarsByProductionDateRange(dateRange);
        model.addAttribute("cars", cars);
        model.addAttribute("dateRange", dateRange);
        return "cars";
    }

    @GetMapping("/add-car-view")
    public String addCarView(Model model) {
        model.addAttribute("newCar", new Car());
        return "addCar";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car) {
        carService.addCar(car);
        return "redirect:/cars";
    }

}
