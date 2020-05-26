package com.uabc.edu.app.practica1.controller;

import com.uabc.edu.app.practica1.model.OPERACIONES;
import com.uabc.edu.app.practica1.model.Operacion;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api")
public class CalculadoraController {


    @PostMapping("ops")
    public Operacion operaciones(@RequestBody
                                         Operacion operacion){

        switch (operacion.getOp()){
            case SUMA:
                operacion.setResultado(
                        operacion.getNumeroA()+
                                operacion.getNumeroB());
                break;
            case RESTA:
                operacion.setResultado(
                        operacion.getNumeroA()-
                                operacion.getNumeroB());
                break;
            case DIVISION:
                if(operacion.getNumeroA()!=0&&
                        operacion.getNumeroB()!=0){
                    operacion.setResultado(
                            operacion.getNumeroA()/
                                    operacion.getNumeroB());
                }else{
                    //Aqui despues veremos como enviar excepciones
                    operacion.setResultado(-1);
                }
                break;
            case MULTIPLICACION:
                operacion.setResultado(
                        operacion.getNumeroA()*
                                operacion.getNumeroB());
                break;
            case CUADRADO:
                operacion.setResultado(
                        operacion.getNumeroA()*
                                operacion.getNumeroA());
                break;
            case PORCENTAJE:
                operacion.setResultado((operacion.getNumeroA()*100)/operacion.getNumeroB());
                break;
        }

        return operacion;
    }
    @GetMapping("/")
    public String saludito(){

        return "<b>Holis!!!</b><br>" +
                "<div style=\"color:red\">" +
                " Bienvenido al purgatorio</div>";
    }

    @GetMapping("/suma")
    public double suma(@RequestParam(value = "numA") double a,
                       @RequestParam(value = "numB") double b){
        return a+b;
    }
    @GetMapping("/resta")
    public double resta(@RequestParam(value = "numA") double a,
                       @RequestParam(value = "numB") double b){
        return a-b;
    }//localhost:8080/suma?numA=20&numB=70
    @GetMapping("/division")
    public double division(@RequestParam(value = "numA") double a,
                        @RequestParam(value = "numB") double b){
        return a/b;
    }
    @GetMapping("/multiplicacion")
    public double multiplicacion(@RequestParam(value = "numA") double a,
                           @RequestParam(value = "numB") double b){
        return a*b;
    }
    @GetMapping("/cuadrado")
    public double cuadrado(@RequestParam(value = "numA") double a){
        return a*a;
    }
    @GetMapping("/porcentaje")
    public double porcentaje(@RequestParam (value = "numA") double a,
                             @RequestParam (value = "numB") double p){
        return a/100;

    }

}
