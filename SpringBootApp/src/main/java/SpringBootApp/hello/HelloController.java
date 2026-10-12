package SpringBootApp.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation. RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class HelloController {

    private ArrayList<String> myList;
    private HashMap<Integer, String> myHashMap;
    private int counter;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
            defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "elem") String s) {
        if (myList == null){
            myList = new ArrayList<>();
        }
        myList.add(s);

        return String.format("Элемент %s, добавлен в ArrayList", s);
    }

    @GetMapping("/show-array")
    public String showArrayList() {
        if (myList == null){
            return "ArrayList пуст";
        }
        return String.format("Текущий ArrayList: %s", String.join(",", myList));
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "elem") String s) {
        if (myHashMap == null){
            myHashMap = new HashMap<>();
            counter = 0;
        }
        counter++;
        myHashMap.put(counter, s);
        return String.format("Элемент %s, добавлен в HashMap", s);
    }

    @GetMapping("/show-map")
    public String showHashMap() {
        if (myHashMap == null){
            return "HashMap пуст";
        }

        return String.format("Текущий HashMap: %s", myHashMap.toString());
    }

    @GetMapping("/show-all-length")
    public String showAllLength() {
        String status = "";
        if (myList == null){
            status = status + "ArrayList пуст; ";
        } else {
            status = status + "Размер ArrayList: " + myList.size() + "; ";
        }

        if (myHashMap == null){
            status = status + "HashMap пуст;";
        } else {
            status = status + "Размер HashMap: " + myHashMap.size() + "; ";
        }

        return String.format("Информация о размерах ArrayList и HashMap: %s", status);
    }
}