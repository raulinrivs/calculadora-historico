package br.edu.usj.ads.pw.calculadorahistorico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculadora {

    List<String> historico = new ArrayList<>();
    
    @PostMapping(value = "calcular")
    public ModelAndView postCalcular(@RequestParam String campo){
        double resultado = 0;
        if (campo.contains("+") == true){
            String[] valores = campo.split("\\+");
            resultado = Double.valueOf(valores[0]) + Double.valueOf(valores[1]);
        }else if  (campo.contains("-") == true){
            String valores[] = campo.split("-");
            resultado = Double.valueOf(valores[0]) - Double.valueOf(valores[1]);
        }else if  (campo.contains("*") == true){
            String valores[] = campo.split("\\*");
            resultado = Double.valueOf(valores[0]) * Double.valueOf(valores[1]);
        }else if  (campo.contains("/") == true){
            String valores[] = campo.split("/");
            resultado = Double.valueOf(valores[0]) / Double.valueOf(valores[1]);
        }     

        String expressao = campo + "=" + resultado;
        historico.add(expressao);

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("resultado", resultado);
        modelAndView.addObject("historico", historico);

        return modelAndView;
    }
}