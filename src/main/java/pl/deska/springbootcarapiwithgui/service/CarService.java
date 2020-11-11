package pl.deska.springbootcarapiwithgui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.deska.springbootcarapiwithgui.model.Car;
import pl.deska.springbootcarapiwithgui.model.Color;
import pl.deska.springbootcarapiwithgui.repo.CarRepository;


import java.util.List;
import java.util.Optional;


@Service
public class CarService {

    private CarRepository carRepo;

    @Autowired
    public CarService(CarRepository carRepo) {
        this.carRepo = carRepo;
    }

    public Car save(Car car){
       return carRepo.save(car);
    }

    public List<Car> findAll(){
      return  carRepo.findAll();
    }

    public List<Car> findAllByProductionYear(int from, int to){
        return carRepo.findCarsByProductionYearIsBetween(from, to);

    }

    public Optional<Car> findById(Long id){
        return carRepo.findById(id);
    }


    public void deleteById(Long id){
        carRepo.deleteById(id);
    }

    private boolean isNotInRange(int from, int to, int productionYear) {
        return productionYear <= from & productionYear >= to;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
        carRepo.save(new Car("Audi", "A7", 2020, Color.BLACK));
        carRepo.save(new Car("Mercedes", "AMG GT", 2019, Color.WHITE));
        carRepo.save(new Car("Lamborghini", "Urus", 2021, Color.YELLOW));
        carRepo.save(new Car("Lexus", "ES350", 2018, Color.RED));
        carRepo.save(new Car("Mercedes", "S Class", 2021, Color.BLACK));
        carRepo.save(new Car("Toyota", "RAV4", 2018, Color.WHITE));
        carRepo.save(new Car("BMW", "850i", 2019, Color.TURQUOISE));

    }


}
