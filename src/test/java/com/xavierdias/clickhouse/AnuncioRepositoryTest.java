package com.xavierdias.clickhouse;

import static org.junit.Assert.assertEquals;
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

@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
public class AnuncioRepositoryTest {
    Anuncio anuncio;

    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private TestEntityManager manager;

    @Before
    public void before(){
        anuncio = new Anuncio();
        anuncio.setTipoanuncio("Aluguel");
        anuncio.setTipoimovel("Residencial");
        anuncio.setCidade("Campo Grande");
        anuncio.setEstado("MS");
        anuncio.setRua("Rua Helio de Castro Maia");
        anuncio.setBairro("Jardim Paulista");
        anuncio.setAreatotal(60000);
        anuncio.setAreaconstruida(16000);
        anuncio.setDescricao("Imóvel excelente, com ótima segurança");
        anuncio.setValor(2300);
        manager.persist(anuncio);
        manager.flush();
    }

    @Test
    public void testeParaEncontrarTodosAnuncios() {
        List<Anuncio> retornado = anuncioRepository.findAllAnuncio();
        Assert.assertTrue(retornado.size() == 1);
    }
}
