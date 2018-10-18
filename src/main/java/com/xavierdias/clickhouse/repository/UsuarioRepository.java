package com.xavierdias.clickhouse.repository;

import com.xavierdias.clickhouse.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
