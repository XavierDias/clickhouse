package com.xavierdias.clickhouse.repository;

import com.xavierdias.clickhouse.bean.Anuncio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AnuncioJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class AnuncioRowMapper implements RowMapper<Anuncio>{
        @Override
        public Anuncio mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Anuncio anuncio = new Anuncio();
            anuncio.setIdanuncio(resultSet.getLong("id"));
            anuncio.setTipoanuncio(resultSet.getString("tipo"));
            anuncio.setCidade(resultSet.getString("cidade"));
            anuncio.setEstado(resultSet.getString("estado"));
            anuncio.setRua(resultSet.getString("rua"));
            anuncio.setBairro(resultSet.getString("bairro"));
            anuncio.setAreatotal(resultSet.getDouble("areatotal"));
            anuncio.setAreaconstruida(resultSet.getDouble("areaconstruida"));
            anuncio.setDescricao(resultSet.getString("descricao"));
            anuncio.setValor(resultSet.getDouble("valor"));
            anuncio.setFk_idusuario(resultSet.getLong("fk_idusuario"));
            return anuncio;
        }

    }

    public List<Anuncio> findAll(){
        return jdbcTemplate.query("select * from anuncio", new AnuncioRowMapper());
    }

    public Anuncio findById(long idanuncio){
        return  jdbcTemplate.queryForObject("select * from anuncio where idanuncio=?", new Object[]{idanuncio},
                new BeanPropertyRowMapper<Anuncio>(Anuncio.class));
    }

    public int deleteById(long idanuncio){
        return jdbcTemplate.update("delete from anuncio where idanuncio=?", new Object[] {idanuncio});
    }

    public int insert(Anuncio anuncio){
        return jdbcTemplate.update("insert into anuncio (tipoanuncio, cidade, estado, rua, bairro, areatotal, areaconstruida, descricao, valor)" 
                        + "values(?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new Object[] {anuncio.getTipoanuncio(), anuncio.getCidade(), anuncio.getEstado(), anuncio.getRua(), anuncio.getBairro(), anuncio.getAreatotal(), anuncio.getAreaconstruida(), anuncio.getDescricao(), anuncio.getValor()});
    }

    public int update(Anuncio anuncio){
        return  jdbcTemplate.update("update anuncio " + " set tipoanuncio = ?, cidade = ?, estado = ?, rua = ?, bairro = ?, areatotal = ?, areaconstruida = ?, descricao = ?, valor = ?, " + 
                        " where idanuncio = ?",
                new Object[] {anuncio.getTipoanuncio(), anuncio.getCidade(), anuncio.getEstado(), anuncio.getRua(), anuncio.getBairro(), anuncio.getAreatotal(), anuncio.getAreaconstruida(), anuncio.getDescricao(), anuncio.getValor()});
    }
}