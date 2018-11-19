package com.xavierdias.clickhouse;

import com.xavierdias.clickhouse.model.Anuncio;
import com.xavierdias.clickhouse.model.Usuario;
import com.xavierdias.clickhouse.model.UsuarioAnuncio;
import com.xavierdias.clickhouse.repository.UsuarioAnuncioRepository;
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
public class UsuarioAnuncioRepositoryTest {

    Usuario usuario;
    Anuncio anuncio;


    @Autowired
    private UsuarioAnuncioRepository usuarioAnuncioRepository;

    @Autowired
    private TestEntityManager manager;

    @Before
    public void before(){

        usuario = new Usuario();
        usuario.setNome("Marco Antonio");
        usuario.setEmail("marcoantonio@gmail.com");
        usuario.setTelefone("67992925555");
        usuario.setSenha("88888888");
        manager.persist(usuario);
        manager.flush();

        anuncio = new Anuncio();
        anuncio.setTipoanuncio("aluguel");
        anuncio.setTipoimovel("Residencial");
        anuncio.setCidade("Campo Grande");
        anuncio.setEstado("MS");
        anuncio.setRua("Rua Teste");
        anuncio.setBairro("Jardim dos Testes");
        anuncio.setAreatotal(60000);
        anuncio.setAreaconstruida(16000);
        anuncio.setDescricao("Imóvel de teste excelente, com ótima segurança de teste");
        anuncio.setValor(2300);
        anuncio.setFk_idusuario(3);
        manager.persist(anuncio);
        manager.flush();
    }

    @Test
    public void testeParaEncontrarUsuarioEAnuncioPorId() {
        UsuarioAnuncio retornado = usuarioAnuncioRepository.findByUsuarioAnuncioId(3, 4);
        assertEquals(usuario.getIdusuario(), retornado.getFk_idusuario());
    }
}
