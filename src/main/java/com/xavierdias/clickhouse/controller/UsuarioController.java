package com.xavierdias.clickhouse.controller;

import com.xavierdias.clickhouse.model.Usuario;
import com.xavierdias.clickhouse.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@EnableAutoConfiguration
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/user")
    public Usuario user(Principal user) {
        Usuario usuario = this.usuarioService.getUsuarioByEmail(user.getName());

        return usuario;
    }

    @GetMapping("/usuario")
    public Usuario buscaUsuario(Principal user){
        Usuario usuario = this.usuarioService.getUsuarioByEmail(user.getName());

        return usuario;
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> add(@Valid @RequestBody Usuario usuario) {
        this.usuarioService.signup(usuario);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/usuario/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id){
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/usuario/edit/{id}")
    public ResponseEntity<Object> alter(@Valid @RequestBody Usuario usuario, @PathVariable long id) {
        if(!this.usuarioService.editUsuario(id, usuario)){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }
}
