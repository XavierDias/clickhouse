package com.xavierdias.clickhouse.service;

import com.xavierdias.clickhouse.model.Usuario;
import com.xavierdias.clickhouse.repository.UsuarioJdbcRepository;
import com.xavierdias.clickhouse.security.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@Service
public class UsuarioService {
    @Autowired
    private WebSecurityConfig securityConfig;

    @Autowired
    private UsuarioJdbcRepository repositorio;

    public void signup(Usuario usuario) {
        String password = securityConfig.passwordEncoder().encode(usuario.getSenha());
        usuario.setSenha(password);
        repositorio.insert(usuario);
    }

    public Usuario getUsuarioByEmail(String email) {
        Usuario usuario = repositorio.findByEmail(email);

        return usuario;
    }

    public boolean editUsuario(long id, Usuario usuario) {
        Optional<Usuario> temp = Optional.of(repositorio.findById(id));

        if(!temp.isPresent()){
            return false;
        }

        Usuario oldUsuario = temp.get();

        if (!oldUsuario.getSenha().equals(usuario.getSenha())) {
            String password = securityConfig.passwordEncoder().encode(usuario.getSenha());
            usuario.setSenha(password);
        }

        repositorio.update(usuario);

        return true;
    }
}
