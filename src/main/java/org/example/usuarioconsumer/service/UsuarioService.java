package org.example.usuarioconsumer.service;


import org.example.usuarioconsumer.model.Usuario;
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

    public Usuario save(Usuario usuario){
        Mono<Usuario> monoUsuario = this.webClient.method(HttpMethod.POST).
                uri(uri).
                body(BodyInserters.fromValue(usuario)).
                retrieve().
                bodyToMono(Usuario.class);
        return monoUsuario.block();
    }

    public Void delete(Integer id){
        Mono<Void> monoVoid = this.webClient.method(HttpMethod.DELETE).
                uri(uri + "/" + id).retrieve().bodyToMono(Void.class);
        return monoVoid.block();
    }
}
