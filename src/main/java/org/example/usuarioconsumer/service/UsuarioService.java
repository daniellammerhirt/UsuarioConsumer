package org.example.usuarioconsumer.service;


import org.example.usuarioconsumer.model.Usuario;
import org.example.usuarioconsumer.model.UsuarioInfo;
import org.example.usuarioconsumer.model.UsuarioJunto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private WebClient webClient;

    @Autowired
    private UsuarioInfoService usuarioInfoService;

    private final String uri = "/usuario";

    public Usuario findById(Integer id){
        Mono<Usuario> monoUsuario = this.webClient.method(HttpMethod.GET).
                uri(uri).
                retrieve().
                bodyToMono(Usuario.class);
        return monoUsuario.block();
    }

    public List<Usuario> findAll(){
        Mono<List<Usuario>> monoListUsuario = this.webClient.method(HttpMethod.GET).
                uri(uri).
                retrieve().
                bodyToFlux(Usuario.class).collectList();
        return monoListUsuario.block();
    }

    public Usuario save(UsuarioJunto usuarioJunto){
        Mono<Usuario> monoUsuario = this.webClient.method(HttpMethod.POST).
                uri(uri).
                body(BodyInserters.fromValue(usuarioJunto.getUsuario())).
                retrieve().
                bodyToMono(Usuario.class);
        Usuario usuario = monoUsuario.block();
        usuarioJunto.getUsuarioInfo().setUsuarioId(usuario.getId());
        usuarioInfoService.save(usuarioJunto.getUsuarioInfo());
        return usuario;
    }

    public Void delete(Integer id){
        Mono<Void> monoVoid = this.webClient.method(HttpMethod.DELETE).
                uri(uri + "/" + id).retrieve().bodyToMono(Void.class);
        return monoVoid.block();
    }
}
