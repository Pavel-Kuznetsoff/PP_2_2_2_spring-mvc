package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarController {

    private CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping(value = "/car")
    public String carList(@RequestParam(value = "count", defaultValue = "-1") int count,
                          ModelMap model) {
        model.addAttribute("carsSubList", service.getSublistOfCars(count));
        return "cars";
    }
}
