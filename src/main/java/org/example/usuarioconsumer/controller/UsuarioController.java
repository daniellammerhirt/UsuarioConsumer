package org.example.usuarioconsumer.controller;


import org.example.usuarioconsumer.model.Usuario;
import org.example.usuarioconsumer.model.UsuarioInfo;
import org.example.usuarioconsumer.model.UsuarioJunto;
import org.example.usuarioconsumer.service.UsuarioInfoService;
import org.example.usuarioconsumer.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioInfoService usuarioInfoService;

    @GetMapping("/new")
    public String newUsuario(Model model){
        model.addAttribute("usuario", new UsuarioJunto(new Usuario(), new UsuarioInfo()));
        return "usuario/form";
    }

    @GetMapping("")
    public String listUsuario(Model model){
        model.addAttribute("listUsuario", usuarioService.findAll());
        return "usuario/list";
    }

    @GetMapping("/{id}/edit")
    public String editUsuario(@PathVariable("id") Integer id, Model model){
        model.addAttribute("usuario", new UsuarioJunto(usuarioService.findById(id), usuarioInfoService.findById(id)));
        return "usuario/form";
    }

    @PostMapping("/save")
    public String saveUsuario(@ModelAttribute("usuario") UsuarioJunto usuario){
        usuarioService.save(usuario);
        return "redirect:/usuario";
    }

    @GetMapping("{id}/delete")
    public String deleteUsuario(@PathVariable("id") Integer id){
        usuarioService.delete(id);
        usuarioInfoService.delete(id);
        return "redirect:/usuario";
    }


}
