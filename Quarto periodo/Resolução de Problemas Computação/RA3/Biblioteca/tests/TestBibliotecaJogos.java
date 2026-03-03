/*
 TestBibliotecaJogos.java
 Testes para a classe BibliotecaJogos que atua como fachada para TabelaHash + ordenação.
 - Inserir jogos via BibliotecaJogos
 - Buscar e remover
 - exportarEOrdenar usando campos diferentes

 Cada passo tem comentários explicativos.
*/

public class TestBibliotecaJogos {
    public static void main(String[] args) {
        System.out.println("== TestBibliotecaJogos ==");
        try {
            testFacadeBehavior();
            System.out.println("TestBibliotecaJogos: PASS\n");
        } catch (AssertionError e) {
            System.out.println("TestBibliotecaJogos: FAIL -> " + e.getMessage());
            throw e;
        }
    }

    private static void testFacadeBehavior() {
        BibliotecaJogos b = new BibliotecaJogos(5);
        Jogo x = new Jogo("X", "G1", 2000);
        Jogo y = new Jogo("Y", "G2", 1999);
        Jogo z = new Jogo("Z", "G1", 2010);

        // Inserir
        Assert.assertTrue("Inserir X", b.inserir(x));
        Assert.assertTrue("Inserir Y", b.inserir(y));
        Assert.assertTrue("Inserir Z", b.inserir(z));

        // Buscar
        Jogo found = b.buscar("y");
        Assert.assertTrue("Buscar y case-insensitive", found != null && found.getTitulo().equalsIgnoreCase("Y"));

        // Ordenar por ano
        Jogo[] byAno = b.exportarEOrdenar("quick", "ano");
        // Esperamos que o primeiro seja Y (1999)
        Assert.assertTrue("Ordenar por ano: primeiro é Y", byAno.length > 0 && byAno[0].getTitulo().equalsIgnoreCase("Y"));

        // Remover
        Assert.assertTrue("Remover X", b.remover("x"));
        Assert.assertTrue("Buscar X agora retorna null", b.buscar("x") == null);
    }
}
