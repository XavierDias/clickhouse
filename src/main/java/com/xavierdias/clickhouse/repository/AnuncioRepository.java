package com.xavierdias.clickhouse.repository;

import com.xavierdias.clickhouse.model.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

    @Override
    @Query(value = "SELECT * FROM anuncio", nativeQuery = true)
    List<Anuncio> findAll();

    @Query(value = "SELECT * FROM anuncio WHERE fk_idusuario=:usuario_id", nativeQuery = true)
    List<Anuncio> findByUsuarioId(@Param("usuario_id") long idusuario);

    @Query(value = "SELECT * FROM anuncio WHERE tipoanuncio = 'venda' AND fk_idusuario=:usuario_id", nativeQuery = true)
    List<Anuncio> findVendaByUsuarioId(@Param("usuario_id") long idusuario);

    @Query(value = "SELECT * FROM anuncio WHERE tipoanuncio = 'aluguel' AND fk_idusuario=:usuario_id", nativeQuery = true)
    List<Anuncio> findAluguelByUsuarioId(@Param("usuario_id") long idusuario);

    @Query(value = "SELECT * FROM anuncio WHERE idanuncio=:anuncio_id", nativeQuery = true)
    Anuncio findById(@Param("anuncio_id") long idanuncio);
}
