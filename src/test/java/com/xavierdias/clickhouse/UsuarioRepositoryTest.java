package com.xavierdias.clickhouse;

import com.xavierdias.clickhouse.model.Usuario;
import com.xavierdias.clickhouse.repository.UsuarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
public class UsuarioRepositoryTest {
    Usuario usuario;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TestEntityManager manager;

    @Before
    public void before(){
        usuario = new Usuario();
        usuario.setNome("Joao");
        usuario.setEmail("joao@gmail.com");
        usuario.setTelefone("67993458976");
        usuario.setSenha("12345678");
        manager.persist(usuario);
        manager.flush();
    }
    @Test
    public void testeParaEncontrarUsuarioPorEmail() {
        Usuario retornado = usuarioRepository.findByEmail(usuario.getEmail());
        assertEquals(usuario.getEmail(), retornado);
    }
}
