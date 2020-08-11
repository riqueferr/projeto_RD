package br.com.pi.projeto_RD.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Teste {

    @GetMapping("/")
    public String obterBoasVindas() {
        return "Bem vindo ao spring boot";
    }

}
