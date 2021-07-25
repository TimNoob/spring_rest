package com.demo.demo.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest")
public class ControllerRestPage {
    private ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();

    // Инициализируем данные
    {
        data.add(new HashMap<String, String>() {
            {
                put("id", "1");
                put("data", "Hello World");
            }
        });

        data.add(new HashMap<String, String>() {
            {
                put("id", "2");
                put("data", "Hello ZB");
            }
        });

        data.add(new HashMap<String, String>() {
            {
                put("id", "3");
                put("data", "Three message");
            }
        });

    }

    @GetMapping
    public ArrayList<HashMap<String, String>> GetRequestHandler() {
        return data;
    }

    @GetMapping(params = { "id" }, produces = MediaType.APPLICATION_JSON_VALUE)

    public Map<String, String> GetRequestHandler(@RequestParam String id) {

        String tmpValue;

        // Поиск сообщения по заданному идентификатору
        for (HashMap<String, String> hashMap : data) {
            tmpValue = hashMap.get("id");

            if (tmpValue == null)
                continue;

            if (tmpValue.equals(id)) {
                return hashMap;
            }
        }

        // Сообещние не найдено выдаем пустой результат
        return null;
    }
}
