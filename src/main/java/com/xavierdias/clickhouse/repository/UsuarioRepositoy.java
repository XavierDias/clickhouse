package com.xavierdias.clickhouse.repository;

import com.xavierdias.clickhouse.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepositoy extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    
}
