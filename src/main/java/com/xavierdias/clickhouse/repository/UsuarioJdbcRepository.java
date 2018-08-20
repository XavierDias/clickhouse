package com.xavierdias.clickhouse.repository;

import com.xavierdias.clickhouse.bean.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsuarioJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class UsuarioRowMapper implements RowMapper<Usuario>{
        @Override
        public Usuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Usuario usuario = new Usuario();
            usuario.setIdusuario(resultSet.getLong("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setTelefone(resultSet.getString("telefone"));
            usuario.setSenha(resultSet.getString("senha"));
            return usuario;
        }

    }

    public List<Usuario> findAll(){
        return jdbcTemplate.query("select * from usuario", new UsuarioRowMapper());
    }

    public Usuario findById(long idusuario){
        return  jdbcTemplate.queryForObject("select * from usuario where idusuario=?", new Object[]{idusuario},
                new BeanPropertyRowMapper<Usuario>(Usuario.class));
    }

    public int deleteById(long idusuario){
        return jdbcTemplate.update("delete from usuario where idusuario=?", new Object[] {idusuario});
    }

    public int insert(Usuario usuario){
        return jdbcTemplate.update("insert into usuario (nome, email, telefone, senha)" + "values(?, ?, ?, ?)",
               new Object[] {usuario.getNome(), usuario.getEmail(), usuario.getTelefone(), usuario.getSenha()});
    }

    public int update(Usuario usuario){
        return  jdbcTemplate.update("update usuario " + " set nome = ?, email = ?, telefone = ?, senha = ? " + " where idusuaro = ?",
                new Object[] {usuario.getNome(), usuario.getEmail(), usuario.getTelefone(), usuario.getSenha()});
    }
}
