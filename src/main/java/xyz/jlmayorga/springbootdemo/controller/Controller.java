package xyz.jlmayorga.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("hello")
public class Controller {
    @Value("${CHART_VERSION:0}")
    String chartVersion;
    @Value("${CONTAINER_IMAGE:0}")
    String containerImage;

    @GetMapping(value = "/", produces = "application/json")
    public Map<String, String> sayHello() {
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("message", "Hello, Codefresh!");
        returnMap.put("chartVersion", chartVersion);
        returnMap.put("containerImage", containerImage);
        return returnMap;
    }


}
