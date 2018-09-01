package com.xavierdias.clickhouse.controller;

import com.xavierdias.clickhouse.bean.Usuario;
import com.xavierdias.clickhouse.repository.UsuarioJdbcRepository;
import com.xavierdias.clickhouse.security.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@EnableAutoConfiguration
public class UsuarioController {
    @Autowired
    private WebSecurityConfig securityConfig;

    public List<String> data = new ArrayList<>();

    @Autowired
    private UsuarioJdbcRepository repositorio;

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @GetMapping("/usuario/{id}")
    public Usuario buscaUsuario(@PathVariable long id){
        Usuario usuario = repositorio.findById(id);

        return usuario;
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> add(@Valid @RequestBody Usuario usuario) {
        String password = securityConfig.passwordEncoder().encode(usuario.getSenha());

        usuario.setSenha(password);
        repositorio.insert(usuario);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/usuario/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id){
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/usuario/edit/{id}")
    public ResponseEntity<Object> alter(@Valid @RequestBody Usuario usuario, @PathVariable long id) {
        Optional<Usuario> temp = Optional.of(repositorio.findById(id));

        if(!temp.isPresent()){
            return ResponseEntity.notFound().build();
        }

        repositorio.update(usuario);

        return ResponseEntity.noContent().build();
    }
}
