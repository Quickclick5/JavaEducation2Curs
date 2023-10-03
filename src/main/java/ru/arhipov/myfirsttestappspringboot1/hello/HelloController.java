package ru.arhipov.myfirsttestappspringboot1.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class HelloController {
    ArrayList<String> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();
    int iterator = 0;
    boolean firstCall = true;
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
        return String.format("Hello, %s!", name);
    }
    @GetMapping("/update-array")
    public void updateArrayList(@RequestParam(value = "s", defaultValue = "")String s){
        if (firstCall) {
            firstCall = false;
        } else {
            arrayList.add(s);
        }
    }
    @GetMapping("/show-array")
    public StringBuilder showArrayList() {
        StringBuilder result = new StringBuilder();
        for (String sf : arrayList) {
            result.append(sf).append('\n');
        }
        return result;
    }
    @GetMapping("/update-map")
    public void updateHashMap(@RequestParam(value = "update", defaultValue = "")String s){
        if (firstCall) {
            firstCall = false;
        } else {
            hashMap.put(String.valueOf(iterator), s);
            iterator+=1;
        }
    }
    @GetMapping("/show-map")
    public StringBuilder showHashMap() {
        StringBuilder result = new StringBuilder();
        for (String s : hashMap.keySet()) {
            result.append(hashMap.get(s)).append('\n');
        }
        return result;
    }
    @GetMapping("/show-all-lenght")
    public int showAllLenght() {
        return arrayList.size() + hashMap.size();
    }
}