package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService service;

    @GetMapping(value = "/car")
    public String printCar(@RequestParam(value = "count", required = false) String count,
                           ModelMap model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ford","Focus", 2001));
        cars.add(new Car("Opel","Insigna", 2019));
        cars.add(new Car("BMW","X6", 2020));
        cars.add(new Car("Subaru","Impreza", 2021));
        cars.add(new Car("McLaren","F1", 1998));
		model.addAttribute("carsSubList", service.getSublistOfCars(cars, count));
        return "cars";
    }
}
