package com.xavierdias.clickhouse.controller;

import com.xavierdias.clickhouse.bean.Anuncio;
import com.xavierdias.clickhouse.repository.AnuncioJdbcRepository;
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
@RequestMapping("/anuncio")
public class AnuncioController {

    public List<String> data = new ArrayList<>();

    @Autowired
    private AnuncioJdbcRepository repositorio;

    @GetMapping("")
    public List<Anuncio> buscaTodosAnuncios(){
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public Anuncio buscaAnuncio(@PathVariable long id){
        Anuncio anuncio = repositorio.findById(id);

        return anuncio;
    }

    @PostMapping
    public ResponseEntity<Object> add(@Valid @RequestBody Anuncio anuncio) {
        repositorio.insert(anuncio);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public void delete(@RequestBody String name) {
        data.remove(name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alter(@Valid @RequestBody Anuncio anuncio, @PathVariable long id) {
        Optional<Anuncio> temp = Optional.of(repositorio.findById(id));

        if(!temp.isPresent()){
            return ResponseEntity.notFound().build();
        }

        repositorio.update(anuncio);

        return ResponseEntity.noContent().build();
    }
}
