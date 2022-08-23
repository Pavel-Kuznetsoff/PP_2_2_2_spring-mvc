package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getSublistOfCars(List<Car> cars, String count) {
        int intCount;
        if (count == null) {
            intCount = cars.size();
        } else {
            intCount = Integer.parseInt(count);
            if (intCount > cars.size() || intCount < 0) {
                intCount = cars.size();
            }
        }
        return cars.subList(0, intCount);
    }
}
