package com.xavierdias.clickhouse.service;

import com.xavierdias.clickhouse.model.Anuncio;
import com.xavierdias.clickhouse.model.Usuario;
import com.xavierdias.clickhouse.model.UsuarioAnuncio;
import com.xavierdias.clickhouse.report.CSVReport;
import com.xavierdias.clickhouse.repository.AnuncioRepository;
import com.xavierdias.clickhouse.repository.UsuarioAnuncioRepository;
import com.xavierdias.clickhouse.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository repositorio;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAnuncioRepository usuarioAnuncioRepository;

    final private CSVReport csvReport = new CSVReport("Listagem de Anuncios");

    public List<Anuncio> findAllAnuncios() {
        return repositorio.findAll();
    }

    public List<Anuncio> findAllAnunciosByUser(final Principal user) {
        Usuario usuario = usuarioRepository.findByEmail(user.getName());

        return repositorio.findByUsuarioId(usuario.getIdusuario());
    }

    public List findAllAnunciosVendaByUser(final Principal user) {
        Usuario usuario = usuarioRepository.findByEmail(user.getName());
        List itens = repositorio.findVendaByUsuarioId(usuario.getIdusuario());

        return itens;
    }

    public String exportAnunciosVendaToCsv(final Principal user, final List ordem) {
        Usuario usuario = usuarioRepository.findByEmail(user.getName());
        List itens = repositorio.findVendaByUsuarioId(usuario.getIdusuario());

        return csvReport.generateReport(itens, ordem);
    }

    public List<Anuncio> findAllAnunciosAluguelByUser(final Principal user) {
        Usuario usuario = usuarioRepository.findByEmail(user.getName());

        return repositorio.findAluguelByUsuarioId(usuario.getIdusuario());
    }

    public Anuncio findAnuncioById(final long id) {
        Anuncio anuncio = repositorio.findById(id);

        return anuncio;
    }

    public void addAnuncio(final Anuncio anuncio, final Principal user) {
        Usuario usuario = usuarioRepository.findByEmail(user.getName());

        anuncio.setFk_idusuario(usuario.getIdusuario());
        repositorio.save(anuncio);
    }

    public boolean editAnuncio(final Anuncio anuncio, final long id) {
        Optional<Anuncio> temp = Optional.of(repositorio.findById(id));

        if(!temp.isPresent()){
            return false;
        }

        repositorio.save(anuncio);

        return true;
    }

    public boolean deleteAnuncio(final long id) {
        Optional<Anuncio> temp = Optional.of(repositorio.findById(id));

        if(!temp.isPresent()){
            return false;
        }

        repositorio.deleteById(id);

        return true;
    }

    public boolean favAnuncio(final long id, final Principal user) {
        Usuario usuario = usuarioRepository.findByEmail(user.getName());

        usuarioAnuncioRepository.insertUsuarioAnuncio(
            id,
            usuario.getIdusuario()
        );

        return true;
    }

    public boolean unfavAnuncio(final long id, final Principal user) {
        Usuario usuario = usuarioRepository.findByEmail(user.getName());
        Optional<UsuarioAnuncio> temp = Optional.of(
            usuarioAnuncioRepository.findByUsuarioAnuncioId(
                id,
                usuario.getIdusuario()
            )
        );

        if(!temp.isPresent()){
            return false;
        }

        usuarioAnuncioRepository.deleteByUusarioAnuncioId(
            id,
            usuario.getIdusuario()
        );

        return true;
    }
}
