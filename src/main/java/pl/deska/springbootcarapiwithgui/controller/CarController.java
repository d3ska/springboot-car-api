package pl.deska.springbootcarapiwithgui.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.deska.springbootcarapiwithgui.model.Car;
import pl.deska.springbootcarapiwithgui.model.Range;
import pl.deska.springbootcarapiwithgui.service.CarService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class CarController {

    private CarService carService;
    private String message = "";

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping
    public String homePage(Model model) {
        List<Car> carsList = carService.findAll();
        model.addAttribute("carsList", carsList);
        return "home";
    }


    @GetMapping("/add")
    public String showNewCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "add-car";
    }

    @PostMapping("/addCar")
    public String addCar(@ModelAttribute Car car) {
        carService.save(car);
        return "redirect:/";
    }


    @GetMapping("/search")
    public String searchCarsForm(Model model) {
        model.addAttribute("range", new Range());
        model.addAttribute("car", new Car());
        return "search-cars";
    }


    @PostMapping("/searchCars")
    public String searchBetweenYears(@ModelAttribute Range range, Model model) {
        List<Car> carsList = carService.findAllByProductionYear(range.getFrom(), range.getTo());
        if (!carsList.isEmpty()) {
            model.addAttribute("carsList", carsList);
        } else {
            message = "There are no cars between " + range.getFrom() + " and " + range.getTo();
            model.addAttribute("message", message);
            model.addAttribute("car", new Car());
            return "search-cars";
        }
        return "home";
    }

    @PostMapping("/searchById")
    public String searchById(@ModelAttribute Car car, Model model) {
        Optional<Car> optionalCar = carService.findById(car.getId());
        if (optionalCar.isPresent()) {
            model.addAttribute("carsList", Collections.singleton(optionalCar.get()));
        } else {
            message = "There is no car with ID " + car.getId();
            model.addAttribute("message", message);
            model.addAttribute("range", new Range());
            return "search-cars";
        }
        return "home";
    }


    @GetMapping("/update/{id}")
    public String showUpdateCarForm(@PathVariable Long id, Model model) {
        Car car = carService.findById(id).get();
        model.addAttribute("car", car);
        return "update-car";
        }


    @PostMapping("/updateCar")
    public String updateCar(@ModelAttribute Car updatedCar) {
        carService.save(updatedCar);
        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String showDeleteCarForm(@PathVariable Long id) {
        carService.deleteById(id);
        return "redirect:/";
    }


}
