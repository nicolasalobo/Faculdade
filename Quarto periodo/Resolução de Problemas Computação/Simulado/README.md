# Quick Sort (pivô na primeira posição)

Implementação em Java do Quick Sort para 10 elementos, com as exigências:

- pivô é o primeiro elemento do subvetor em cada chamada;
- exibe o vetor completo a cada chamada recursiva (que realiza partição);
- exibe o pivô escolhido a cada chamada.

Vetor usado (anos de lançamento):

```text
[1993, 1845, 2008, 1514, 1291, 1507, 1822, 1553, 1974, 1402]
```

## Como executar (macOS, zsh)

```zsh
# dentro da pasta Simulado
javac QuickSortDemo.java
java QuickSortDemo
```

Saída esperada (exemplo ilustrativo): mostrará, para cada chamada recursiva, o intervalo do subvetor, o pivô escolhido e o vetor completo naquele momento, seguido do vetor ordenado ao final.
