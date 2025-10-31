package br.com.nicolaslobo.JUnit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTeste {

    @Test
    void testeCalculadoraSoma(){
        Calculadora c1 = new Calculadora();
        int esperado = 10;
        int atual = c1.soma(1, 9);
        assertEquals(esperado,atual,"1+9 tem que ser 10");
    }

    @Test
    void testeCalculadoraSubtracao(){
        Calculadora c1 = new Calculadora();
        int esperado = 10;
        int atual = c1.subtracao(20,10);
        assertEquals(esperado,atual,"vai toma no cu 20-10 é 10 fodase os dois");
    }
}
