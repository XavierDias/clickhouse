package com.xavierdias.clickhouse.service;

import com.xavierdias.clickhouse.model.Usuario;
import com.xavierdias.clickhouse.repository.UsuarioRepository;
import com.xavierdias.clickhouse.security.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private WebSecurityConfig securityConfig;

    @Autowired
    private UsuarioRepository repositorio;

    public void signup(Usuario usuario) {
        String password = securityConfig.passwordEncoder().encode(usuario.getSenha());

        usuario.setSenha(password);
        repositorio.save(usuario);
    }

    public Usuario getUsuarioByEmail(String email) {
        Usuario usuario = repositorio.findByEmail(email);
        usuario.setSenha("");

        return usuario;
    }

    public boolean editUsuario(long id, Usuario usuario) {
        Optional<Usuario> temp = Optional.of(repositorio.findById(id));

        if(!temp.isPresent()){
            return false;
        }

        Usuario oldUsuario = temp.get();

        usuario.setSenha(oldUsuario.getSenha());

        repositorio.save(usuario);

        return true;
    }
}
