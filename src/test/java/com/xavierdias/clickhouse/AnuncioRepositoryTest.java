package com.xavierdias.clickhouse;

import com.xavierdias.clickhouse.model.Anuncio;
import com.xavierdias.clickhouse.repository.AnuncioRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
public class AnuncioRepositoryTest {
    Anuncio anuncio, outroanuncio;

    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private TestEntityManager manager;

    @Before
    public void before(){
        anuncio = new Anuncio();
        anuncio.setTipoanuncio("aluguel");
        anuncio.setTipoimovel("Residencial");
        anuncio.setCidade("Campo Grande");
        anuncio.setEstado("MS");
        anuncio.setRua("Rua Helio de Castro Maia");
        anuncio.setBairro("Jardim Paulista");
        anuncio.setAreatotal(60000);
        anuncio.setAreaconstruida(16000);
        anuncio.setDescricao("Imóvel excelente, com ótima segurança");
        anuncio.setValor(2300);
        anuncio.setFk_idusuario(1);
        manager.persist(anuncio);
        manager.flush();

        outroanuncio = new Anuncio();
        outroanuncio.setTipoanuncio("venda");
        outroanuncio.setTipoimovel("Residencial");
        outroanuncio.setCidade("Campo Grande");
        outroanuncio.setEstado("MS");
        outroanuncio.setRua("Rua Quintino Bocaiúva");
        outroanuncio.setBairro("Jardim TV Morena");
        outroanuncio.setAreatotal(30000);
        outroanuncio.setAreaconstruida(25000);
        outroanuncio.setDescricao("Casa em perfeito estado, com um ótimo acabamento");
        outroanuncio.setValor(750000);
        outroanuncio.setFk_idusuario(1);
        manager.persist(outroanuncio);
        manager.flush();
    }

    @Test
    public void testeParaEncontrarTodosAnuncios() {
        List<Anuncio> retornado = anuncioRepository.findAll();
        Assert.assertTrue(retornado.size() == 5);
        assertNotEquals(retornado.size(), 6);
    }

    @Test
    public void testeParaEncontrarQuantidadeDeAnunciosPorIdDoUsuario() {
        List<Anuncio> retornado = anuncioRepository.findByUsuarioId(1);
        Assert.assertTrue(retornado.size() == 2);
        assertNotEquals(retornado.size(), 3);
    }

    @Test
    public void testeParaEncontrarAnuncioPeloTipoVenda() {
        List<Anuncio> retornado = anuncioRepository.findVendaByUsuarioId(1);
        Assert.assertTrue(retornado.size() == 1);
        assertNotEquals(retornado.size(), 2);
    }

    @Test
    public void testeParaEncontrarAnuncioPeloTipoAluguel() {
        List<Anuncio>retornado = anuncioRepository.findAluguelByUsuarioId(1);
        Assert.assertTrue(retornado.size() == 1);
        assertNotEquals(retornado.size(), 2);
    }

    @Test
    public void testeParaEncontrarAnunciPorId(){
        Anuncio retornado = anuncioRepository.findById(anuncio.getIdanuncio());
        assertEquals(anuncio.getIdanuncio(), retornado.getIdanuncio());
        assertNotEquals(retornado.getIdanuncio(), 5);
    }
}
