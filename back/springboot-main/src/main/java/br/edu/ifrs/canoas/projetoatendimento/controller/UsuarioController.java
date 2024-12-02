package br.edu.ifrs.canoas.projetoatendimento.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import br.edu.ifrs.canoas.projetoatendimento.model.Usuario;


public class UsuarioController {
    @PostMapping("/usuario")
    public Usuario criarUsuario(Usuario usuario){
        usuario.create();
        return usuario;
    }
    
    @PutMapping("/usuario")
    public Usuario atualizarUsuario(Usuario usuario) {
        usuario.update();
        return usuario;
    }

    @DeleteMapping("/usuario")
    public void deletarUsuario(Usuario usuario) {
        usuario.delete();

    }

    @GetMapping("/usuario")
    public ArrayList<Usuario> listarUsuario() {
        return Usuario.getAllUsuarios();
    }

    @GetMapping("/usuario/{id}")
    public Usuario buscarUsuario(@PathVariable int id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.load();
        return usuario;
    }
}
