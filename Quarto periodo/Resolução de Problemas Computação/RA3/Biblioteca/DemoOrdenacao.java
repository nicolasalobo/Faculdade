public class DemoOrdenacao {
    public static void main(String[] args) {
        // Criar biblioteca e inserir jogos variados
        BibliotecaJogos biblioteca = new BibliotecaJogos(11);
        
        // Inserir jogos com anos, gêneros e títulos variados
        biblioteca.inserir(new Jogo("The Last of Us", "Ação", 2013));
        biblioteca.inserir(new Jogo("Minecraft", "Sandbox", 2011));
        biblioteca.inserir(new Jogo("Final Fantasy VII", "RPG", 1997));
        biblioteca.inserir(new Jogo("Super Mario Bros", "Plataforma", 1985));
        biblioteca.inserir(new Jogo("The Witcher 3", "RPG", 2015));
        biblioteca.inserir(new Jogo("Tetris", "Puzzle", 1984));
        biblioteca.inserir(new Jogo("Portal", "Puzzle", 2007));

        // Demonstrar ordenação por ano
        System.out.println("\n=== Ordenação por ANO ===");
        Jogo[] porAno = biblioteca.exportarEOrdenar("quick", "ano");
        biblioteca.exibirArray(porAno);

        // Demonstrar ordenação por gênero
        System.out.println("\n=== Ordenação por GÊNERO ===");
        Jogo[] porGenero = biblioteca.exportarEOrdenar("quick", "genero");
        biblioteca.exibirArray(porGenero);

        // Demonstrar ordenação por título
        System.out.println("\n=== Ordenação por TÍTULO ===");
        Jogo[] porTitulo = biblioteca.exportarEOrdenar("quick", "titulo");
        biblioteca.exibirArray(porTitulo);
    }
}