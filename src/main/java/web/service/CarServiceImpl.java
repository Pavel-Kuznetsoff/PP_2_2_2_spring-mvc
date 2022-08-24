package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> cars = new ArrayList<>(Arrays.asList(
            new Car("Ford", "Focus", 2001),
            new Car("Opel", "Insigna", 2019),
            new Car("BMW", "X6", 2020),
            new Car("Subaru", "Impreza", 2021),
            new Car("McLaren", "F1", 1998)
    ));

    @Override
    public List<Car> getSublistOfCars(int count) {
        if (count < 0) count = cars.size();
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
