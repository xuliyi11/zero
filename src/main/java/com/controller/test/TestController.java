package com.controller.test;

import com.aop.annotation.TestAnnotation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
public class TestController {

    @RequestMapping("/test")
    @TestAnnotation(methodParam = "/{test}")
    public String test(@RequestAttribute("test") String test){

        return "123";

    }

    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1,2);
    }

}
