package com.xavierdias.clickhouse.service;

import com.xavierdias.clickhouse.model.Anuncio;
import com.xavierdias.clickhouse.model.Usuario;
import com.xavierdias.clickhouse.repository.AnuncioJdbcRepository;
import com.xavierdias.clickhouse.repository.AnuncioRepository;
import com.xavierdias.clickhouse.repository.UsuarioJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    //@Autowired
    //private AnuncioJdbcRepository repositorio;

    @Autowired
    private UsuarioJdbcRepository usuarioRepository;

    public List<Anuncio> findAllAnuncio() {
        return anuncioRepository.findAll();
    }

    public List<Anuncio> findAllAnunciosByUser(Principal user) {
        Usuario usuario = usuarioRepository.findByEmail(user.getName());

        return anuncioRepository.findByUsuarioId(usuario.getIdusuario());
    }

    public Anuncio findAnuncioById(long id) {
        Anuncio anuncio = anuncioRepository.findAnuncioById(id);

        return anuncio;
    }

    public void addAnuncio(Anuncio anuncio, Principal user) {
        Usuario usuario = usuarioRepository.findByEmail(user.getName());

        anuncio.setFk_idusuario(usuario.getIdusuario());
        repositorio.insert(anuncio);
    }

    public boolean editAnuncio(Anuncio anuncio, long id) {
        Optional<Anuncio> temp = Optional.of(repositorio.findById(id));

        if(!temp.isPresent()){
            return false;
        }

        repositorio.update(anuncio);

        return true;
    }

    public boolean deleteAnuncio(long id) {
        Optional<Anuncio> temp = Optional.of(repositorio.findById(id));

        if(!temp.isPresent()){
            return false;
        }

        repositorio.deleteById(id);

        return true;
    }
}
