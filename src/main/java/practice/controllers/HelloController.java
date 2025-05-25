package practice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloMethod(@RequestParam(name = "name", defaultValue = "world") String name) {
        return String.format("Hello, %s" , name);
    }

}
