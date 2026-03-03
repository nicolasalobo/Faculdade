/*
 TestJogo.java
 Testes básicos para a classe Jogo.
 Cada método de teste tem comentários que você pode usar para explicar para a professora o que está sendo verificado.

 Como executar (sem JUnit):
 1) javac -d out ..\*.java tests\TestJogo.java
 2) java -cp out tests.TestJogo
*/
import static java.lang.System.out;

public class TestJogo {
    public static void main(String[] args) {
        out.println("== TestJogo ==");
        try {
            testGettersSettersToString();
            testEqualsHashCode();
            out.println("TestJogo: PASS\n");
        } catch (AssertionError e) {
            out.println("TestJogo: FAIL -> " + e.getMessage());
            throw e;
        }
    }

    // Verifica se getters, setters e toString funcionam corretamente.
    // Explicação para a professora: criamos um objeto, lemos seus valores via getters,
    // alteramos via setters e garantimos que o toString contém os valores esperados.
    private static void testGettersSettersToString() {
    Assert.assertTrue("Construtor e getters",
        new Jogo("Zelda", "Adventure", 1986).getTitulo().equals("Zelda") &&
        new Jogo("Zelda", "Adventure", 1986).getGenero().equals("Adventure") &&
        new Jogo("Zelda", "Adventure", 1986).getAno() == 1986);

        Jogo j = new Jogo("Old", "OldGenre", 1900);
        j.setTitulo("NewTitle");
        j.setGenero("NewGenre");
        j.setAno(2000);
    Assert.assertTrue("Setters and getters after change",
        j.getTitulo().equals("NewTitle") && j.getGenero().equals("NewGenre") && j.getAno() == 2000);

        // toString should contain the fields in the expected format
        String s = j.toString();
    Assert.assertTrue("toString contains values", s.contains("NewTitle") && s.contains("NewGenre") && s.contains("2000"));
    }

    // Verifica equals() e hashCode() (case-insensitive por título).
    // Explicação para a professora: dois jogos com o mesmo título (diferente case) devem ser considerados iguais.
    private static void testEqualsHashCode() {
        Jogo a = new Jogo("Mario", "Platformer", 1985);
        Jogo b = new Jogo("mario", "Platformer", 1985);
    Assert.assertTrue("equals should be case-insensitive for title", a.equals(b));
    Assert.assertTrue("hashCode consistent with equals", a.hashCode() == b.hashCode());

        Jogo c = new Jogo(null, "X", 0);
        Jogo d = new Jogo(null, "Y", 1);
        Assert.assertTrue("null titles compare equal", c.equals(d));
        Assert.assertTrue("null title hashCode==0", c.hashCode() == 0);
    }
}
