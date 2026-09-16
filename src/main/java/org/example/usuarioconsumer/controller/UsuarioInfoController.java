package org.example.usuarioconsumer.controller;


import org.example.usuarioconsumer.model.Usuario;
import org.example.usuarioconsumer.model.UsuarioInfo;
import org.example.usuarioconsumer.service.UsuarioInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario/info")
public class UsuarioInfoController {

    @Autowired
    private UsuarioInfoService usuarioInfoService;



    @GetMapping("")
    public String listUsuarioInfo(Model model) {
        model.addAttribute("listUsuarioInfo", usuarioInfoService.findAll());
        return "usuario/info/list";
    }
}