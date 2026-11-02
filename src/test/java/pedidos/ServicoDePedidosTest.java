package pedidos;

import com.SoftwareTesting.java.pedidos.Pedidos;
import com.SoftwareTesting.java.pedidos.RepositorioDePedidos;
import com.SoftwareTesting.java.pedidos.ServicoDePedidos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class) // Habilita o uso de @Mock e @InjectMocks com JUnit 5
public class ServicoDePedidosTest {

    @Mock
    private RepositorioDePedidos repositorioFalso;

    @InjectMocks
    private ServicoDePedidos servico; // recebe automaticamente o mock no construtor

    @Test
    public void deveRetornarDEscricaoDoPedido() {
        // Dado um pedido simulado
        Pedidos pedidoFalso = new Pedidos(1, "Pedido de teste");
        when(repositorioFalso.buscarPorId(1)).thenReturn(pedidoFalso); // when é metodo do Mockito

        // Quando chamamos o metodo de serviço
        String resultado = servico.obterDecricaoDOPedido(1);

        // Então a descrição deve estar correta
        assertEquals("Pedido de teste", resultado);
    }

}
