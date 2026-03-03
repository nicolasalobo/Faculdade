/*
 TestAll.java
 Executa todos os testes e imprime um resumo.
*/

public class TestAll {
    public static void main(String[] args) {
        System.out.println("=== Running all tests ===\n");
        int failed = 0;
        try { TestJogo.main(new String[0]); } catch (Throwable t) { failed++; t.printStackTrace(); }
        try { TestTabelaHash.main(new String[0]); } catch (Throwable t) { failed++; t.printStackTrace(); }
        try { TestOrdenacao.main(new String[0]); } catch (Throwable t) { failed++; t.printStackTrace(); }
        try { TestBibliotecaJogos.main(new String[0]); } catch (Throwable t) { failed++; t.printStackTrace(); }

        if (failed == 0) System.out.println("\nALL TESTS PASSED");
        else System.out.println("\nSOME TESTS FAILED: " + failed);
    }
}
