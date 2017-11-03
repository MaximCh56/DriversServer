package controllers;

import model.Driver;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


@RestController
public class IndexController {
    private Map <String,Driver> driverMap;

    public IndexController() {
        driverMap=new ConcurrentHashMap<>();
        Driver driver=new Driver("Maxim","Petrov","Ivanovich","B","1993-10-11",true);
        Driver driver2=new Driver("Igor","Ivanov","Ivanovich","A","1993-10-11",true);
        Driver driver3=new Driver("Irina","Ivanova","Ivanovna","A","1993-10-11",false);
        saveDriverInMap(driver);
        saveDriverInMap(driver2);
        saveDriverInMap(driver3);
    }

//    @PostMapping(value = "/save")
//    public String saveDriver(@RequestBody Driver driver) {
//        saveDriverInMap(driver);
//        return "{\"success\":true}";
//    }

    @GetMapping(value = "/category")
    public String getCategory() {
        return "{\"category\":[\"A\",\"B\",\"C\"]}";
    }

    @PostMapping(value = "/edit")
    public String editDriver(@RequestBody Driver driver) {
        editDriverInMap(driver);
        return "{\"success\":true}";
    }

    @PostMapping(value = "/search")
    public List<Driver> searchDrivers(@RequestParam String search) {
        return searchDriverInMap(search);
    }

//    @PostMapping(value = "/delete")
//    public String deleteDriver(@RequestParam String uuid) {
//        driverMap.remove(uuid);
//        return "{\"success\":true}";
//    }

    private void saveDriverInMap(Driver driver){
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        driverMap.put(randomUUIDString,driver);
        driver.setUuid(randomUUIDString);
    }

    private void editDriverInMap(Driver driver){
        driverMap.put(driver.getUuid(),driver);
    }

    private List<Driver> searchDriverInMap(String search){
        List<Driver> selectedDrivers=new ArrayList<>();

        for (Driver d : driverMap.values()) {
            String fio=d.getName()+" "+d.getPatronymic()+" "+d.getSurname();
            if(fio.toUpperCase().contains(search.toUpperCase())){
                selectedDrivers.add(d);
            }
        }
        return selectedDrivers;
    }
}
