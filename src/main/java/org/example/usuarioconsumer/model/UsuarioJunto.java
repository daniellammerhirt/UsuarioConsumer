package org.example.usuarioconsumer.model;

public class UsuarioJunto {

    private Usuario usuario;

    private UsuarioInfo usuarioInfo;

    public UsuarioJunto(){}

    public UsuarioJunto(Usuario usuario, UsuarioInfo usuarioInfo){
        this.usuario = usuario;
        this.usuarioInfo = usuarioInfo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioInfo getUsuarioInfo() {
        return usuarioInfo;
    }

    public void setUsuarioInfo(UsuarioInfo usuarioInfo) {
        this.usuarioInfo = usuarioInfo;
    }
}
