public class DemoOrdenacaoCompleta {
    public static void main(String[] args) {
        BibliotecaJogos biblioteca = new BibliotecaJogos(11);
        
        // Inserir jogos com casos interessantes para mostrar os critérios de desempate
        biblioteca.inserir(new Jogo("Final Fantasy VII", "RPG", 1997));     // Mesmo gênero que FF IX
        biblioteca.inserir(new Jogo("Final Fantasy IX", "RPG", 2000));      // Mesmo gênero que FF VII
        biblioteca.inserir(new Jogo("Portal", "Puzzle", 2007));             // Mesmo gênero que Tetris
        biblioteca.inserir(new Jogo("Tetris", "Puzzle", 1984));            // Mesmo gênero que Portal
        biblioteca.inserir(new Jogo("God of War", "Ação", 2005));          // Mesmo ano que RE4
        biblioteca.inserir(new Jogo("Resident Evil 4", "Ação", 2005));     // Mesmo ano que GoW

        // Demonstrar as três ordenações principais com seus critérios de desempate
        System.out.println("\n=== Ordenação por ANO (secundário: título, gênero) ===");
        System.out.println("Observe: God of War e RE4 (2005) são ordenados por título");
        Jogo[] porAno = biblioteca.exportarEOrdenar("quick", "ano");
        biblioteca.exibirArray(porAno);

        System.out.println("\n=== Ordenação por GÊNERO (secundário: título, ano) ===");
        System.out.println("Observe: RPGs e Puzzles são ordenados por título");
        Jogo[] porGenero = biblioteca.exportarEOrdenar("quick", "genero");
        biblioteca.exibirArray(porGenero);

        System.out.println("\n=== Ordenação por TÍTULO (secundário: gênero, ano) ===");
        System.out.println("Observe: ordem alfabética estrita");
        Jogo[] porTitulo = biblioteca.exportarEOrdenar("quick", "titulo");
        biblioteca.exibirArray(porTitulo);
    }
}