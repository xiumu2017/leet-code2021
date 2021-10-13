package com.example.code2021.structure.sep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N1436DestinationCity {
    public static void main(String[] args) {
//        [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
        List<List<String>> paths = new ArrayList<>();
        paths.add(List.of("London", "New York"));
        paths.add(List.of("New York", "Lima"));
        paths.add(List.of("Lima", "Sao Paulo"));
        N1436DestinationCity city = new N1436DestinationCity();
        System.out.println("city.destCity(paths) = " + city.destCity(paths));

    }

    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
            list.add(path.get(1));
        }
        for (String path : list) {
            if (map.get(path) == null) {
                return path;
            }
        }
        return null;
    }
}
