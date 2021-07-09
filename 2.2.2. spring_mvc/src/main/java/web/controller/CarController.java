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
import java.util.ResourceBundle;

@Controller
//@RequestMapping("/cars")
public class CarController {

    public List <Car> getListCars(){
        List<Car> cars = new ArrayList<> ();
        cars.add (new Car("Lamborghini Aventador",2019,"orange"));
        cars.add (new Car ("ZAZ-965",1965,"Black"));
        cars.add (new Car("Boomerang",2020,"Green"));
        cars.add (new Car ("Nissan Tiida",2019,"White"));
        cars.add (new Car("Boomerang",2020,"Red"));
        cars.add (new Car ("Nissan Tiida",2018,"Black"));
        return cars;
    }
    public PagedListHolder<Car> getPageListHolder(List <Car> cars,Integer count){
        PagedListHolder<Car> pagedListHolder = new PagedListHolder<Car>(cars);
        if(count==null||count<=0||count>=5){
            pagedListHolder.setPageSize(cars.size ());
        }else {
            pagedListHolder.setPageSize (count);
        }
        pagedListHolder.setPage(0);
        return pagedListHolder;
    }

    @GetMapping("/cars")
    public String getTableCars(Locale locale, ModelMap model, @RequestParam(name ="count",required=false) Integer count){
        ResourceBundle resourceBundle = ResourceBundle.getBundle ("src/main/resources/headers",locale);

       // String s = locale.getLanguage ();


            model.addAttribute("header_cars", resourceBundle.getString ("header_cars"));
            model.addAttribute("head_table1",resourceBundle.getString ("head_table1"));
            model.addAttribute("head_table2", resourceBundle.getString ("head_table2"));
            model.addAttribute("head_table3", resourceBundle.getString ("head_table3"));




        //подсписок текущей страницы

        model.addAttribute ("list_cars",getPageListHolder (getListCars (),count).getPageList ());

        return "cars";
    }

}
