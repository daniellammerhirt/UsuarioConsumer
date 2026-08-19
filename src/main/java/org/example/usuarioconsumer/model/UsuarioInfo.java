package org.example.usuarioconsumer.model;

import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsuarioInfo {
    private Integer usuarioId;
    private String nome;
    private String email;
    private LocalDate dataNascimento;

    public UsuarioInfo(){}

    public UsuarioInfo(Integer usuarioId, String nome, String email, String dataNascimento){
        this.setUsuarioId(usuarioId);
        this.setNome(nome);
        this.setEmail(email);
        this.setDataNascimento(LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @JsonIgnore
    public String getDataNascimentoString(){
        return dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @JsonIgnore
    public String getDataNascimentoIso(){
        return dataNascimento == null ? null : dataNascimento.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

   @JsonIgnore
    public void setDataNascimentoIso(String dataNascimento){
        this.dataNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ISO_LOCAL_DATE);
   }

}


