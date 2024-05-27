package com.example.springcloudgateway.java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/java")
public class StreamController {

    @RequestMapping("/stream")
    public ResponseEntity<?> stream() {

        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);

        Map<String, List<?>> streamMap = new LinkedHashMap<String, List<?>>();

        // stream.map() example
        List<Double> mappedList = l.stream()
                .map(Integer::doubleValue)
                .collect(Collectors.toList());
        streamMap.put("1,2,3 after stream.map() -> ", mappedList);

        // stream.distinct() example
        l.add(1);
        List<Integer> distinctList = l.stream()
                .distinct()
                .collect(Collectors.toList());
        streamMap.put("1,1,2,3 after stream.distinct() -> ", distinctList);

        // stream.filter() example
        List<Integer> filterList = l.stream()
                .filter(e -> e == 3)
                .collect(Collectors.toList());
        streamMap.put("1,2,3 after stream.filter() -> ", filterList);

        // stream.limit() example
        List<Integer> limitList = l.stream()
                .limit(1)
                .collect(Collectors.toList());
        streamMap.put("1,2,3 after stream.limit() -> ", limitList);

        // stream.sorted() example
        l.add(7);
        l.add(2);
        l.add(5);
        l.add(-1);
        List<Integer> sortedList = l.stream()
                .sorted()
                .collect(Collectors.toList());
        streamMap.put("1,2,3,7,2,5,-1 after stream.sorted() -> ", sortedList);

        // stream.count() example
        long count = l.stream().count();
        List<Long> countList = new ArrayList<>();
        countList.add(count);
        streamMap.put("1,1,2,3,7,2,5,-1 after stream.count() -> ", countList);

        // stream.max() example
        Optional<Integer> count2 = l.stream().max(Integer::compare);
        List<Integer> maxList = new ArrayList<>();
        maxList.add(count2.get());
        streamMap.put("1,1,2,3,7,2,5,-1 after stream.max() -> ", maxList);

        // stream.min() example
        Optional<Integer> count3 = l.stream().min(Integer::compare);
        List<Integer> minList = new ArrayList<>();
        minList.add(count3.get());
        streamMap.put("1,1,2,3,7,2,5,-1 after stream.min() -> ", minList);

        // stream.reduce() example
        Integer i = l.stream().reduce(0, (e1, e2) -> e1 + e2);
        List<Integer> reduceList = new ArrayList<>();
        reduceList.add(i);
        streamMap.put("1,1,2,3,7,2,5,-1 after stream.reduce() -> ", reduceList);

        // stream.forEach() example
        l.stream()
                .forEach(e -> System.out.println(e));

        ResponseEntity<?> re = new ResponseEntity(streamMap, HttpStatus.OK);
        return re;
    }
}
