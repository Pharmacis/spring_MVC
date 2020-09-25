package web.controller;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
//@RequestMapping("/cars")
public class CarController {

    @GetMapping("/cars")
    public String getTableCars(Locale locale, ModelMap model, @RequestParam(name ="count",required=false) Integer count){

        List<Car> cars = new ArrayList<> ();
        String s = locale.getLanguage ();

        if (s.equals("ru")) {
            model.addAttribute("header_cars", "МАШИНЫ");
            model.addAttribute("head_table1", "Марка");
            model.addAttribute("head_table2", "Год выпуска");
            model.addAttribute("head_table3", "Цвет");
            cars.add (new Car("Ламборгини Авентадор",2019,"оранжевый"));
            cars.add (new Car ("ЗАЗ-965",1965,"чёрный"));
            cars.add (new Car("Бумеранг",2020,"зелёный"));
            cars.add (new Car ("Ниссан Тиида",2019,"белый"));
            cars.add (new Car("Бумеранг",2020,"красный"));
            cars.add (new Car ("Ниссан Тиида",2018,"чёрный"));

        } else if (s.equals("en")) {
            model.addAttribute("header_cars", "CARS");
            model.addAttribute("head_table1", "Mark");
            model.addAttribute("head_table2", "Series");
            model.addAttribute("head_table3", "Color");
            cars.add (new Car("Lamborghini Aventador",2019,"orange"));
            cars.add (new Car ("ZAZ-965",1965,"Black"));
            cars.add (new Car("Boomerang",2020,"Green"));
            cars.add (new Car ("Nissan Tiida",2019,"White"));
            cars.add (new Car("Boomerang",2020,"Red"));
            cars.add (new Car ("Nissan Tiida",2018,"Black"));
        }
        PagedListHolder<Car> pagedListHolder = new PagedListHolder<Car>(cars);
        if(count==null||count<=0||count>=5){
            pagedListHolder.setPageSize(cars.size ());
        }else {
            pagedListHolder.setPageSize (count);
        }
        //количество страниц
       // model.addAttribute ("maxPages", pagedListHolder.getPageCount());
       // model.addAttribute("list_cars", cars);
        //установить номер текущей страницы
        pagedListHolder.setPage(0);
        //подсписок текущей страницы
        model.addAttribute ("list_cars", pagedListHolder.getPageList());

        return "cars";
    }

}
