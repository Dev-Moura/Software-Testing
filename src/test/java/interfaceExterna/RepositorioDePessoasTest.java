package interfaceExterna;

import com.softwareTesting.java.testeDeIntegracao.interfaceExterna.Pessoa;
import com.softwareTesting.java.testeDeIntegracao.interfaceExterna.RepositorioDePessoas;
import com.softwareTesting.java.testeDeIntegracao.interfaceExterna.RepositorioDePessoasJdbc;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RepositorioDePessoasTest {

    private Connection conexao;
    private RepositorioDePessoas repositorio;

    @BeforeAll
    // O que vai fazer antes de rodar todos os testes
    void prepararConexao() throws SQLException {
        conexao = DriverManager.getConnection(
                "jbdc:postgresql://localhost:5432/postgres",
                "postgres",
                "postgres"
        );

        repositorio = new RepositorioDePessoasJdbc(conexao);
        criarTabelaSeNaoExistir();
    }

    @BeforeEach
    // Antes de CADA teste vai remover os dados da tabela
    void limparTabela() {
        repositorio.removerTodas();
    }

    @Test
    // definitivamente o teste
    void deveSalvarEPersistirPessoas() {

        Pessoa pessoa = new Pessoa("Michael Moura", "michael.moura@email.com");
        repositorio.salvar(pessoa);

        assertTrue(pessoa.getId() > 0);

        Pessoa recuperada = repositorio.buscarPorId(pessoa.getId());
        assertNotNull(recuperada);
        assertEquals("Michael Moura", recuperada.getNome());
    }

    @Test
    void deveListarTodasAsPessoas() {

        repositorio.salvar(new Pessoa( "Ana", "ana@email.com"));
        repositorio.salvar(new Pessoa("Bruno", "Bruno@email.com"));

        List<Pessoa> Pessoas = repositorio.listarTodas();
        assertEquals(2, Pessoas.size());
    }

    private void criarTabelaSeNaoExistir() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS pessoas (
                id SERIAL PRIMARY KEY,
                nome TEXT NOT NULL,
                email TEXT NOT NULL UNIQUE
             )""";
        try (Statement stmt = conexao.createStatement()){
            stmt.execute(sql);
        }
    }

    @AfterAll
    // Depois de todos os testes
    void fecharConexao() throws SQLException {
        if (conexao != null && !conexao.isClosed()) {
            conexao.close();
        }
    }

}
