package Mockito.calculadora;

import com.softwareTesting.java.mockito.calculaFinanceiro.CalculadoraFinanceira;
import com.softwareTesting.java.mockito.calculaFinanceiro.ConversorDeMoeda;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculadoraFinanceiraTest {

    @Mock
    private ConversorDeMoeda conversorFalso;

    @InjectMocks
    private CalculadoraFinanceira calculadora;

    @Test
    public void deveSomarVaorEmReaisComValorConvertidoDeDolar() {
        // Arrange: simula a conversão
        when(conversorFalso.dolarParaReal(10.0)).thenReturn(50.00);

        // Act: executa o metodo real
        double result = calculadora.somarEmReais(100.0, 10.0);

        // Assert: Verifica o resultado
        assertEquals(150.0, result);

        // Verficação: garante que o metodo do mock foi chamado com o valor correto
        verify(conversorFalso).dolarParaReal(10.0);
    }

}