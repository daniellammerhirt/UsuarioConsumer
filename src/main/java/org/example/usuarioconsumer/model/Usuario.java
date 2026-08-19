package org.example.usuarioconsumer.model;

public class Usuario {
    private Integer id;
    private String cpf;
    private String senha;

    public Usuario(){}

    public Usuario(Integer id, String cpf, String senha){
        this.setId(id);
        this.setCpf(cpf);
        this.setSenha(senha);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
