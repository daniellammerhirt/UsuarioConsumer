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
        model.addAttribute("usuarioInfo", usuarioInfoService.findAll());
        return "usuario/indo/list";
    }

    @GetMapping("/{id}/edit")
    public String editUsuarioInfo(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("usuarioInfo", usuarioInfoService.findById(id));
        return "usuario/info/form";
    }


    @GetMapping("{id}/delete")
    public String deleteUsuario(@PathVariable("id") Integer id) {
        usuarioInfoService.delete(id);
        return "redirect:/usuario/info";
    }
}