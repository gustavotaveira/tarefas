package br.com.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {

    @RequestMapping("/olamundo")
    public String execute() {
        System.out.println("Executando objeto controlador:" + this.toString());
        return "ok";
    }
}
