import java.util.*;

public class BibliotecaJogos {
    private final TabelaHash tabela;

    public BibliotecaJogos(int capacidade) {
        tabela = new TabelaHash(capacidade);
    }

    public boolean inserir(Jogo j) {
        if (j == null || j.getTitulo() == null) return false;
        return tabela.inserir(j);
    }

    public boolean remover(String titulo) {
        if (titulo == null) return false;
        return tabela.remover(titulo);
    }

    public Jogo buscar(String titulo) {
        if (titulo == null) return null;
        return tabela.buscar(titulo);
    }

    public int tamanho() {
        return tabela.tamanho();
    }

    public int colisoes() {
        return tabela.colisoes();
    }

    // Método que permite ordenação personalizada com 3 critérios e direção
    public Jogo[] exportarEOrdenarPersonalizado(String algoritmo, String campo1, String campo2, String campo3, boolean decrescente) {
        Jogo[] arr = tabela.exportarParaVetor();
        if (arr == null || arr.length == 0) return arr;

        // Criar comparadores base para cada campo
        Comparator<Jogo> porTitulo = Comparator.comparing(Jogo::getTitulo, String.CASE_INSENSITIVE_ORDER);
        Comparator<Jogo> porGenero = Comparator.comparing(Jogo::getGenero, String.CASE_INSENSITIVE_ORDER);
        Comparator<Jogo> porAno = Comparator.comparingInt(Jogo::getAno);

        // Seleciona o comparador para cada campo
        Comparator<Jogo> comp1 = switch(campo1) {
            case "titulo" -> porTitulo;
            case "genero" -> porGenero;
            case "ano" -> porAno;
            default -> porTitulo;
        };

        Comparator<Jogo> comp2 = switch(campo2) {
            case "titulo" -> porTitulo;
            case "genero" -> porGenero;
            case "ano" -> porAno;
            default -> porGenero;
        };

        Comparator<Jogo> comp3 = switch(campo3) {
            case "titulo" -> porTitulo;
            case "genero" -> porGenero;
            case "ano" -> porAno;
            default -> porAno;
        };

        // Combina os comparadores na ordem escolhida
        Comparator<Jogo> cmp = comp1.thenComparing(comp2).thenComparing(comp3);
        
        // Se for decrescente, inverte a ordenação
        if (decrescente) {
            cmp = cmp.reversed();
        }

        // Aplica o algoritmo de ordenação escolhido
        if (algoritmo == null) algoritmo = "quick";
        switch (algoritmo.toLowerCase()) {
            case "bubble":
                Ordenacao.bubbleSort(arr, cmp);
                break;
            case "insertion":
                Ordenacao.insertionSort(arr, cmp);
                break;
            case "quick":
            default:
                Ordenacao.quickSort(arr, cmp);
                break;
        }
        return arr;
    }

    // Método original mantido para compatibilidade
    public Jogo[] exportarEOrdenar(String algoritmo, String campo) {
        // Chama o novo método com ordem padrão
        return exportarEOrdenarPersonalizado(algoritmo, campo, 
            campo.equals("titulo") ? "genero" : "titulo",
            campo.equals("ano") ? "genero" : "ano",
            false);
    }

    public void exibirArray(Jogo[] arr, String campo1, String campo2, String campo3) {
        if (arr == null || arr.length == 0) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }
        // Mostra o cabeçalho na ordem escolhida
        String header = String.format("%s | %s | %s", 
            capitalizar(campo1), 
            capitalizar(campo2), 
            capitalizar(campo3));
        System.out.println(header);
        System.out.println("------------------------");
        
        // Mostra cada jogo na ordem das colunas escolhida
        for (Jogo j : arr) {
            String linha = String.format("%s | %s | %s",
                getValorCampo(j, campo1),
                getValorCampo(j, campo2),
                getValorCampo(j, campo3));
            System.out.println(linha);
        }
    }

    // Método auxiliar para capitalizar a primeira letra
    private String capitalizar(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    // Método auxiliar para obter o valor do campo específico
    private String getValorCampo(Jogo j, String campo) {
        return switch(campo.toLowerCase()) {
            case "titulo" -> j.getTitulo();
            case "genero" -> j.getGenero();
            case "ano" -> String.valueOf(j.getAno());
            default -> "";
        };
    }

    // Sobrecarga do método original para manter compatibilidade
    public void exibirArray(Jogo[] arr) {
        exibirArray(arr, "titulo", "genero", "ano");
    }
}