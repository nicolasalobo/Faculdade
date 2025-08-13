#include <stdio.h>
#include <time.h>

int main() {
    // Número de caracteres a serem impressos
    const int num_chars = 5000000;
    
    printf("Iniciando impressão de %d caracteres 'X'...\n", num_chars);
    
    // Marca o tempo de início
    clock_t start_time = clock();
    
    // Imprime os caracteres "X"
    for (int i = 0; i < num_chars; i++) {
        printf("X");
    }
    
    // Marca o tempo de fim
    clock_t end_time = clock();
    
    // Calcula o tempo decorrido em segundos
    double elapsed_time = ((double)(end_time - start_time)) / CLOCKS_PER_SEC;
    
    printf("\n\nTempo decorrido: %.4f segundos\n", elapsed_time);
    printf("Caracteres por segundo: %.0f\n", num_chars / elapsed_time);
    
    return 0;
}
