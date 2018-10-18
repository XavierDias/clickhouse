package com.xavierdias.clickhouse.repository;

import com.xavierdias.clickhouse.model.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

    List<Anuncio> findAllAnuncio();
}
