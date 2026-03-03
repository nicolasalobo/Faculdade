public class DemoOrdenacaoPersonalizada {
    public static void main(String[] args) {
        BibliotecaJogos biblioteca = new BibliotecaJogos(11);
        
        // Inserir alguns jogos para demonstração
        biblioteca.inserir(new Jogo("The Last of Us", "Ação", 2013));
        biblioteca.inserir(new Jogo("Portal 2", "Puzzle", 2011));
        biblioteca.inserir(new Jogo("God of War", "Ação", 2018));
        biblioteca.inserir(new Jogo("Tetris", "Puzzle", 1984));
        biblioteca.inserir(new Jogo("Final Fantasy VII", "RPG", 1997));
        biblioteca.inserir(new Jogo("Minecraft", "Sandbox", 2011));

        // 1. Ordenação por Ano -> Título -> Gênero (crescente)
        System.out.println("\n=== Ordenação: ANO -> TÍTULO -> GÊNERO (crescente) ===");
        Jogo[] ord1 = biblioteca.exportarEOrdenarPersonalizado("quick", "ano", "titulo", "genero", false);
        biblioteca.exibirArray(ord1, "ano", "titulo", "genero");

        // 2. Ordenação por Gênero -> Ano -> Título (crescente)
        System.out.println("\n=== Ordenação: GÊNERO -> ANO -> TÍTULO (crescente) ===");
        Jogo[] ord2 = biblioteca.exportarEOrdenarPersonalizado("quick", "genero", "ano", "titulo", false);
        biblioteca.exibirArray(ord2, "genero", "ano", "titulo");

        // 3. Ordenação por Título -> Gênero -> Ano (decrescente)
        System.out.println("\n=== Ordenação: TÍTULO -> GÊNERO -> ANO (decrescente) ===");
        Jogo[] ord3 = biblioteca.exportarEOrdenarPersonalizado("quick", "titulo", "genero", "ano", true);
        biblioteca.exibirArray(ord3, "titulo", "genero", "ano");
    }
}