package com.message.helloword;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class hellowordcontroller {

    private List<String> items = new ArrayList<String>();
    public hellowordcontroller(){
        items.add("Colombia");
        items.add("Brasil");
        items.add("Argentina");
        items.add("Peru");
        items.add("Chile");
        items.add("Venezuela");
        items.add("Bolivia");
    }

    @PostMapping
    public String addItem(@RequestBody String newItem){
        items.add(newItem);
        return "Item insertado con éxito";
    }

    @GetMapping
    public Map<String, Object> getAllItems(){
        Map<String, Object> response = new HashMap<>();
        response.put("Items", items);
        response.put("count", items.size());
        return response;
    }

    @GetMapping("/{index}")
    public String getItem(@PathVariable int index){
        if(index >=0 && index < items.size()){
            return items.get(index);
        }else {
            return "Item no encontrado";
        }
    }

    @PutMapping("/{index}")
    public String modifyItem(@PathVariable int index, @RequestBody String newItem){
        if(index >=0 && index < items.size()){
            items.set(index, newItem);
            return "Item actalizado con éxito";
        }else {
            return "Item no encontrado";
        }
    }

    @DeleteMapping("/{index}")
    public String deleteItem(@PathVariable int index){
        if(index >=0 && index < items.size()){
            items.remove(index);
            return "Item eliminado con éxito";

        }else {
            return "Item no encontrado";
        }
    }
}

