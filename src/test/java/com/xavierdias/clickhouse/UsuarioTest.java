package com.xavierdias.clickhouse;

import com.xavierdias.clickhouse.model.Usuario;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UsuarioTest {
    Usuario usuario;

    @Before
    public void before(){
        usuario = new Usuario();
        usuario.setNome("Joao");
        usuario.setEmail("joao@gmail.com");
        usuario.setTelefone("67993458976");
        usuario.setSenha("12345678");
    }

    @Test
    public void testeParaBuscarNome(){
        assertEquals(usuario.getNome(), "Joao");
        assertNotEquals(usuario.getNome(),"Pedro");
    }

    @Test
    public void testeParaBuscarEmail(){
        assertEquals(usuario.getEmail(), "joao@gmail.com");
        assertNotEquals(usuario.getEmail(), "pedro@gmail.com");
    }

    @Test
    public void testeParaBuscarTelefone() {
        assertEquals(usuario.getTelefone(), "67993458976");
        assertNotEquals(usuario.getTelefone(), "67992458975");
    }

    @Test
    public void testeParaBuscarSenha() {
        assertEquals(usuario.getSenha(), "12345678");
        assertNotEquals(usuario.getSenha(), "87654321");
    }
}
