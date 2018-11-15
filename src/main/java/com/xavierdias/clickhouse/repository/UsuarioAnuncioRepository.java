package com.xavierdias.clickhouse.repository;

import com.xavierdias.clickhouse.model.UsuarioAnuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioAnuncioRepository extends JpaRepository<UsuarioAnuncio, Long> {
    @Query(value = "SELECT * FROM usuario_anuncio WHERE fk_idusuario=:usuario_id", nativeQuery = true)
    List<UsuarioAnuncio> findByUsuarioId(@Param("usuario_id") long idusuario);

    @Query(value = "SELECT * FROM usuario_anuncio WHERE fx_idanuncio=:anuncio_id", nativeQuery = true)
    UsuarioAnuncio findByAnuncioId(@Param("anuncio_id") long idanuncio);

    @Query(
        value = "SELECT * FROM usuario_anuncio WHERE fk_idanuncio=:anuncio_id AND fk_idusuario=:usuario_id",
        nativeQuery = true
    )
    UsuarioAnuncio findByUsuarioAnuncioId(@Param("anuncio_id") long idanuncio, @Param("usuario_id") long idusuario);

    @Query(
        value = "INSERT INTO usuario_anuncio (fk_idanuncio, fk_idusuario) VALUES(:anuncio_id, :usuario_id)",
        nativeQuery = true
    )
    UsuarioAnuncio insertUsuarioAnuncio(@Param("anuncio_id") long idanuncio, @Param("usuario_id") long idusuario);

    @Query(
        value = "DELETE FROM usuario_anuncio WHERE fk_idanuncio=:anuncio_id AND fk_idusuario=:usuario_id",
        nativeQuery = true
    )
    void deleteByUusarioAnuncioId(@Param("anuncio_id") long idanuncio, @Param("usuario_id") long idusuario);
}
