package com.example.rastreamento.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

        @GetMapping()
        public String get(){

            return "API de Clientes de uma plataforma de Rastreamento";
        }
    }


