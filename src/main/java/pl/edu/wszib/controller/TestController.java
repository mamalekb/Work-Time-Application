package pl.edu.wszib.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class TestController {

    public static class NotFoundException extends RuntimeException{


        @ExceptionHandler(javassist.NotFoundException.class)
        public String notFound() {
            return "404";
        }
    }

}
