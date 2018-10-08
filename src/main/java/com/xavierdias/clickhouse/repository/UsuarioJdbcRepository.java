package com.xavierdias.clickhouse.repository;

import com.xavierdias.clickhouse.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Service
public class UsuarioJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class UsuarioRowMapper implements RowMapper<Usuario>{
        @Override
        public Usuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Usuario usuario = new Usuario();
            usuario.setIdusuario(resultSet.getLong("idusuario"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setTelefone(resultSet.getString("telefone"));
            usuario.setSenha(resultSet.getString("senha"));
            return usuario;
        }
    }

    public Usuario findById(long idusuario){
        return jdbcTemplate.queryForObject("select * from usuario where idusuario=?", new Object[]{idusuario},
                new BeanPropertyRowMapper<Usuario>(Usuario.class));
    }

    public Usuario findByEmail(String email){
        return jdbcTemplate.queryForObject("select * from usuario where email=?", new Object[]{email},
                new BeanPropertyRowMapper<Usuario>(Usuario.class));
    }

    public int deleteById(long idusuario){
        return jdbcTemplate.update("delete from usuario where idusuario=?", new Object[] {idusuario});
    }

    public int insert(Usuario usuario){
        return this.jdbcTemplate.update("insert into usuario (nome, email, telefone, senha)" + " values(?, ?, ?, ?)",
               new Object[] {usuario.getNome(), usuario.getEmail(), usuario.getTelefone(), usuario.getSenha()});
    }

    public int update(Usuario usuario){
        return jdbcTemplate.update("update usuario " + " set nome = ?, email = ?, telefone = ?, senha = ? " + " where idusuario = ?",
                new Object[] {usuario.getNome(), usuario.getEmail(), usuario.getTelefone(), usuario.getSenha(), usuario.getIdusuario()});
    }
}
