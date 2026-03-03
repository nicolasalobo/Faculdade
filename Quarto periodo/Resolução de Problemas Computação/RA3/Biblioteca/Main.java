import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BibliotecaJogos biblioteca = new BibliotecaJogos(11);

		boolean rodando = true;
		while (rodando) {
			System.out.println("\n=== Biblioteca de Jogos ===");
			System.out.println("1. Inserir jogo");
			System.out.println("2. Remover jogo");
			System.out.println("3. Buscar jogo");
			System.out.println("4. Listar/Ordenar jogos");
			System.out.println("0. Sair");
			System.out.print("Escolha: ");
			String op = sc.nextLine().trim();

			switch (op) {
				case "1":
					System.out.print("Título: ");
					String titulo = sc.nextLine();
					System.out.print("Gênero: ");
					String genero = sc.nextLine();
					System.out.print("Ano: ");
					int ano = 0;
					try {
						String anoStr = sc.nextLine().trim();
						if (!anoStr.isEmpty()) ano = Integer.parseInt(anoStr);
					} catch (NumberFormatException e) {
						System.out.println("Ano inválido. Usando 0.");
					}
					boolean ok = biblioteca.inserir(new Jogo(titulo, genero, ano));
					System.out.println(ok ? "Inserido com sucesso." : "Jogo já existe (título duplicado).");
					break;
				case "2":
					System.out.print("Título a remover: ");
					String rem = sc.nextLine();
					boolean r = biblioteca.remover(rem);
					System.out.println(r ? "Removido." : "Não encontrado.");
					break;
				case "3":
					System.out.print("Título a buscar: ");
					String b = sc.nextLine();
					Jogo found = biblioteca.buscar(b);
					System.out.println(found != null ? found : "Não encontrado.");
					break;
				case "4":
					// Primeiro critério de ordenação
					System.out.println("\nEscolha a ordem de prioridade para ordenação:");
					System.out.print("Primeiro critério (1-ano, 2-genero, 3-titulo): ");
					String escolha1 = sc.nextLine().trim();
					String campo1;
					switch(escolha1) {
						case "1": campo1 = "ano"; break;
						case "2": campo1 = "genero"; break;
						case "3": campo1 = "titulo"; break;
						default: campo1 = "titulo";
					}

					// Segundo critério (excluindo o primeiro)
					System.out.print("Segundo critério (1-ano, 2-genero, 3-titulo) [exceto " + campo1 + "]: ");
					String escolha2 = sc.nextLine().trim();
					String campo2;
					do {
						switch(escolha2) {
							case "1": campo2 = "ano"; break;
							case "2": campo2 = "genero"; break;
							case "3": campo2 = "titulo"; break;
							default: campo2 = ""; break;
						}
					} while (campo2.equals(campo1));

					// O terceiro será o que sobrou
					String campo3 = "titulo";
					if (!campo1.equals("titulo") && !campo2.equals("titulo")) campo3 = "titulo";
					else if (!campo1.equals("genero") && !campo2.equals("genero")) campo3 = "genero";
					else if (!campo1.equals("ano") && !campo2.equals("ano")) campo3 = "ano";

					System.out.print("Ordem (C-crescente, D-decrescente) [C]: ");
					String ordem = sc.nextLine().trim().toUpperCase();
					boolean decrescente = ordem.equals("D");

					// Usar quicksort como algoritmo padrão
					Jogo[] ordenado = biblioteca.exportarEOrdenarPersonalizado("quick", campo1, campo2, campo3, decrescente);
					if (ordenado == null || ordenado.length == 0) {
						System.out.println("Nenhum jogo cadastrado para exibir.");
					} else {
						System.out.println("\nOrdenado por: " + campo1 + " -> " + campo2 + " -> " + campo3 + 
							" (" + (decrescente ? "Decrescente" : "Crescente") + ")");
						biblioteca.exibirArray(ordenado, campo1, campo2, campo3);
						System.out.println("Colisões na tabela: " + biblioteca.colisoes());
					}
					break;
				case "0":
					rodando = false;
					break;
				default:
					System.out.println("Opção inválida.");
			}
		}

		sc.close();
	}
}
