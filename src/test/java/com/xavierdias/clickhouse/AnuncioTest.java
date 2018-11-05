package com.xavierdias.clickhouse;

import com.xavierdias.clickhouse.model.Anuncio;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AnuncioTest {
    Anuncio anuncio;

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
    }

    @Test
    public void testeParaBuscarTipoDeAnuncio() {
        assertEquals(anuncio.getTipoanuncio(),"Aluguel");
        assertNotEquals(anuncio.getTipoanuncio(), "Venda");
    }

    @Test
    public void testeParaBuscarTipoDeImovel() {
        assertEquals(anuncio.getTipoimovel(),"Residencial");
        assertNotEquals(anuncio.getTipoimovel(), "Rural");
    }

    @Test
    public void testeParaBuscarCidade() {
        assertEquals(anuncio.getCidade(), "Campo Grande");
        assertNotEquals(anuncio.getCidade(), "Dourados");
    }

    @Test
    public void testeParaBuscarEstado() {
        assertEquals(anuncio.getEstado(), "MS");
        assertNotEquals(anuncio.getEstado(), "RS");
    }

    @Test
    public void testeParaBuscarRua() {
        assertEquals(anuncio.getRua(), "Rua Helio de Castro Maia");
        assertNotEquals(anuncio.getRua(), "Rua da Paz");
    }

    @Test
    public void testeParaBuscarBairro() {
        assertEquals(anuncio.getBairro(), "Jardim Paulista");
        assertNotEquals(anuncio.getBairro(), "Jardim TV Morena");
    }

    @Test
    public void testeParaBuscarAreaTotal() {
        assertEquals(anuncio.getAreatotal(), 60000, 0);
        assertNotEquals(anuncio.getAreatotal(), 70000);
    }

    @Test
    public void testeParaBuscarAreaConstruida() {
        assertEquals(anuncio.getAreaconstruida(), 16000, 0);
        assertNotEquals(anuncio.getAreaconstruida(), 20000);
    }

    @Test
    public void testeParaBuscarDescricao() {
        assertEquals(anuncio.getDescricao(), "Imóvel excelente, com ótima segurança");
        assertNotEquals(anuncio.getDescricao(), "Imóvel show de bola!");
    }

    @Test
    public void testeParaBuscarValor() {
        assertEquals(anuncio.getValor(), 2300, 0);
        assertNotEquals(anuncio.getValor(), 3000);
    }
}
