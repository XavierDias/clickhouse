package com.xavierdias.clickhouse.controller;

import com.xavierdias.clickhouse.model.Anuncio;
import com.xavierdias.clickhouse.service.AnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/anuncio")
public class AnuncioController {

    public List<String> data = new ArrayList<>();

    @Autowired
    private AnuncioService anuncioService;

    @GetMapping("")
    public List<Anuncio> buscaTodosAnuncios(){

        return anuncioService.findAllAnuncios();
    }

    @GetMapping("/usuario")
    public List<Anuncio> buscaTodosAnunciosUsuario(Principal user){
        return anuncioService.findAllAnunciosByUser(user);
    }

    @GetMapping("/usuario/venda")
    public List<Anuncio> buscaTodosAnunciosVendaUsuario(Principal user){
        return anuncioService.findAllAnunciosVendaByUser(user);
    }

    @GetMapping("/usuario/aluguel")
    public List<Anuncio> buscaTodosAnunciosAluguelUsuario(Principal user){
        return anuncioService.findAllAnunciosAluguelByUser(user);
    }

    @GetMapping("/{id}")
    public Anuncio buscaAnuncio(@PathVariable long id){
        return anuncioService.findAnuncioById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@Valid @RequestBody Anuncio anuncio, Principal user) {
        anuncioService.addAnuncio(anuncio, user);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Object> delete(@PathVariable long id) {
        if (!anuncioService.deleteAnuncio(id)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> alter(@Valid @RequestBody Anuncio anuncio, @PathVariable long id) {
        if(!anuncioService.editAnuncio(anuncio, id)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }
}
