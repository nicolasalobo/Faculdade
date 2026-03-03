/*
 TestTabelaHash.java
 Testes básicos para a classe TabelaHash.
 - Inserção de elementos
 - Rejeição de duplicatas por título (case-insensitive)
 - Busca e remoção
 - exportarParaVetor e tamanho

 Explicações estão nos comentários em cada passo.
*/

public class TestTabelaHash {
    public static void main(String[] args) {
        System.out.println("== TestTabelaHash ==");
        try {
            testInserirBuscarRemover();
            System.out.println("TestTabelaHash: PASS\n");
        } catch (AssertionError e) {
            System.out.println("TestTabelaHash: FAIL -> " + e.getMessage());
            throw e;
        }
    }

    // Testa inserção, buscar, remover e exportar
    private static void testInserirBuscarRemover() {
        // Cria tabela com capacidade pequena para forçar colisões
        TabelaHash t = new TabelaHash(3);

        Jogo a = new Jogo("GameA", "GenA", 2001);
        Jogo b = new Jogo("gamea", "GenB", 2002); // mesmo título, diferente case
        Jogo c = new Jogo("GameC", "GenC", 2003);

        // Inserir primeiros deve retornar true
        Assert.assertTrue("Inserir A", t.inserir(a));

        // Inserir B (mesmo título case-insensitive) deve falhar
        Assert.assertTrue("Inserir duplicado (deve retornar false)", !t.inserir(b));

        // Inserir C deve retornar true
        Assert.assertTrue("Inserir C", t.inserir(c));

        // Buscar A por título (case-insensitive) deve retornar o objeto A
        Jogo found = t.buscar("GAMEA");
        Assert.assertTrue("Buscar A por título", found != null && found.getTitulo().equalsIgnoreCase("GameA"));

        // Remover A deve retornar true e decrementar tamanho
        int before = t.tamanho();
        Assert.assertTrue("Remover A", t.remover("gamea"));
        Assert.assertTrue("Tamanho diminuiu", t.tamanho() == before - 1);

        // Exportar deve conter apenas C (após remoção)
        Jogo[] arr = t.exportarParaVetor();
        boolean hasC = false;
        for (Jogo j : arr) if (j != null && j.getTitulo().equalsIgnoreCase("GameC")) hasC = true;
        Assert.assertTrue("Exportar contém C", hasC);
    }
}
