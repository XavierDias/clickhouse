package com.xavierdias.clickhouse.repository;

import com.xavierdias.clickhouse.model.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

    @Query(value = "SELECT * FROM anuncio", nativeQuery = true)
    List<Anuncio> findAllAnuncio();

    @Query(value = "SELECT * FROM anuncio WHERE idanuncio=?", nativeQuery = true)
    Anuncio findAnuncioById(long id);

    @Query(value = "SELECT * FROM anuncio WHERE fk_idusuario=?", nativeQuery = true)
    List<Anuncio> findByUsuarioId(long idusuario);

    @Query(value = "DELETE * FROM anuncio WHERE idanuncio=?", nativeQuery = true)


}
