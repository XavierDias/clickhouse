package com.xavierdias.clickhouse.service;

import com.xavierdias.clickhouse.model.Anuncio;
import com.xavierdias.clickhouse.model.Usuario;
import com.xavierdias.clickhouse.repository.AnuncioJdbcRepository;
import com.xavierdias.clickhouse.repository.UsuarioJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioJdbcRepository repositorio;

    @Autowired
    private UsuarioJdbcRepository usuarioRepository;

    public List<Anuncio> findAllAnuncios() {
        return repositorio.findAll();
    }

    public List<Anuncio> findAllAnunciosByUser(Principal user) {
        Usuario usuario = usuarioRepository.findByEmail(user.getName());

        return repositorio.findByUsuarioId(usuario.getIdusuario());
    }

    public List<Anuncio> findAllAnunciosVendaByUser(Principal user) {
        Usuario usuario = usuarioRepository.findByEmail(user.getName());

        return repositorio.findVendaByUsuarioId(usuario.getIdusuario());
    }

    public List<Anuncio> findAllAnunciosAluguelByUser(Principal user) {
        Usuario usuario = usuarioRepository.findByEmail(user.getName());

        return repositorio.findAluguelByUsuarioId(usuario.getIdusuario());
    }

    public Anuncio findAnuncioById(long id) {
        Anuncio anuncio = repositorio.findById(id);

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
