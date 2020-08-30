package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping("/cars")
    public String getTableCars(@RequestParam("locale")String s, ModelMap model){

        List<Car> cars = new ArrayList<> ();

        if (s.equals("ru")) {
            model.addAttribute("header_cars", "МАШИНЫ");
            model.addAttribute("head_table1", "Марка");
            model.addAttribute("head_table2", "Год выпуска");
            model.addAttribute("head_table3", "Цвет");
            cars.add (new Car("Ламборгини Авентадор",2019,"оранжевый"));
            cars.add (new Car ("ЗАЗ-965",1965,"чёрный"));
            cars.add (new Car("Бумеранг",2020,"зелёный"));
        } else if (s.equals("en")) {
            model.addAttribute("header_cars", "CARS");
            model.addAttribute("head_table1", "Mark");
            model.addAttribute("head_table2", "Series");
            model.addAttribute("head_table3", "Color");
            cars.add (new Car("Lamborghini Aventador",2019,"orange"));
            cars.add (new Car ("ZAZ-965",1965,"Black"));
            cars.add (new Car("Boomerang",2020,"Green"));
        }
        model.addAttribute("list_cars", cars);
        return "cars";
    }

}
