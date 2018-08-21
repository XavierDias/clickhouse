package com.xavierdias.clickhouse.controller;

import com.xavierdias.clickhouse.bean.Usuario;
import com.xavierdias.clickhouse.repository.UsuarioJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@EnableAutoConfiguration
@RequestMapping("/usuario")
public class UsuarioController {

    public List<String> data = new ArrayList<>();

    @Autowired
    private UsuarioJdbcRepository repositorio;

    @GetMapping("")
    public List<Usuario> buscaTodosUsuarios(){
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public Usuario buscaUsuario(@PathVariable long id){
        Usuario usuario = repositorio.findById(id);

        return usuario;
    }

    @PostMapping
    public ResponseEntity<Object> add(@Valid @RequestBody Usuario usuario) {
        repositorio.insert(usuario);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public void delete(@RequestBody String name) {
        data.remove(name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alter(@Valid @RequestBody Usuario usuario, @PathVariable long id) {
        Optional<Usuario> temp = Optional.of(repositorio.findById(id));

        if(!temp.isPresent()){
            return ResponseEntity.notFound().build();
        }

        repositorio.update(usuario);

        return ResponseEntity.noContent().build();
    }
}
