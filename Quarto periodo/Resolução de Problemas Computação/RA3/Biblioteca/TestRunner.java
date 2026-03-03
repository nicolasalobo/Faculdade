public class TestRunner {
    public static void main(String[] args) {
        BibliotecaJogos b = new BibliotecaJogos(5);
        b.inserir(new Jogo("Zelda", "Adventure", 1986));
        b.inserir(new Jogo("Mario", "Platformer", 1985));
        b.inserir(new Jogo("Doom", "Shooter", 1993));
        Jogo[] arr = b.exportarEOrdenar("quick", "titulo");
        b.exibirArray(arr);
    }
}
