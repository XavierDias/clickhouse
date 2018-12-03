package com.xavierdias.clickhouse.repository;

import com.xavierdias.clickhouse.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Override
    @Query(value = "SELECT * FROM usuario", nativeQuery = true)
    List<Usuario> findAll();

    @Query(value = "select * from usuario where idusuario=:usuario_id", nativeQuery = true)
    Usuario findById(@Param("usuario_id") long id);

    @Query(value = "select * from usuario where email=:usuario_email", nativeQuery = true)
    Usuario findByEmail(@Param("usuario_email") String email);
}
