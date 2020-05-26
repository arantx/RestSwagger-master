package com.uabc.edu.app.practica1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
//@ResponseBody

public class CalculadoraAvzController {





    @GetMapping("/calcu")
    public String pagina(){

        return "Calculadora";
    }











}
