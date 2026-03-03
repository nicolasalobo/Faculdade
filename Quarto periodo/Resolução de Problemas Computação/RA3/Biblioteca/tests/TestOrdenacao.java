/*
 TestOrdenacao.java
 Testes para os algoritmos de ordenação: bubble, insertion, quick.
 - Prepara um array de jogos em ordem aleatória
 - Ordena com cada algoritmo e valida o resultado esperado (por título)

 Explicação: comparamos o array ordenado por cada algoritmo com o mesmo critério
 (Comparator por título) para garantir que os algoritmos produzem ordem equivalente.
*/

public class TestOrdenacao {
    public static void main(String[] args) {
        System.out.println("== TestOrdenacao ==");
        try {
            testSortingAlgorithms();
            System.out.println("TestOrdenacao: PASS\n");
        } catch (AssertionError e) {
            System.out.println("TestOrdenacao: FAIL -> " + e.getMessage());
            throw e;
        }
    }

    private static void testSortingAlgorithms() {
        Jogo[] arr = new Jogo[] {
            new Jogo("Zelda", "A", 1986),
            new Jogo("Mario", "B", 1985),
            new Jogo("Doom", "C", 1993),
            new Jogo("Alpha", "D", 2000)
        };

        // Esperado: Alpha, Doom, Mario, Zelda (ordenado por título, case-insensitive)
        java.util.Comparator<Jogo> cmp = java.util.Comparator.comparing(Jogo::getTitulo, String.CASE_INSENSITIVE_ORDER);

        // Test bubble
        Jogo[] copy1 = arr.clone();
        Ordenacao.bubbleSort(copy1, cmp);
        Assert.assertTrue("bubble sorted", isSorted(copy1, cmp));

        // Test insertion
        Jogo[] copy2 = arr.clone();
        Ordenacao.insertionSort(copy2, cmp);
        Assert.assertTrue("insertion sorted", isSorted(copy2, cmp));

        // Test quick
        Jogo[] copy3 = arr.clone();
        Ordenacao.quickSort(copy3, cmp);
        Assert.assertTrue("quick sorted", isSorted(copy3, cmp));
    }

    // Helper: verifica se array está ordenado segundo o comparator
    private static boolean isSorted(Jogo[] arr, java.util.Comparator<Jogo> cmp) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (cmp.compare(arr[i], arr[i+1]) > 0) return false;
        }
        return true;
    }
}
