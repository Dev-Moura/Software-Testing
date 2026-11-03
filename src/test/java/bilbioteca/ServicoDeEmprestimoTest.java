package bilbioteca;

import com.softwareTesting.java.testeDeIntegracao.biblioteca.Livro;
import com.softwareTesting.java.testeDeIntegracao.biblioteca.RepositorioDeLivros;
import com.softwareTesting.java.testeDeIntegracao.biblioteca.ServicoDeEmprestimo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServicoDeEmprestimoTest {

    @Test
    void deveEmprestarLivroExistente() {

        // Arrange
        RepositorioDeLivros repositorio = new RepositorioDeLivros();
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", "21655");
        repositorio.adicionar(livro);

        ServicoDeEmprestimo servico = new ServicoDeEmprestimo(repositorio);

        // Act
        boolean emprestado = servico.emprestarLivros("21655");

        // Assert
        assertTrue(emprestado);
    }

    @Test
    void naoDeveEmprestarLivroInexistente() {

        // Arrange
        RepositorioDeLivros repositorio = new RepositorioDeLivros();
        ServicoDeEmprestimo servico = new ServicoDeEmprestimo(repositorio);

        // Act
        boolean emprestado = servico.emprestarLivros("999");

        // Assert
        assertFalse(emprestado);
    }
}
