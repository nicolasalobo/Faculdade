import time

def main():
    # Número de caracteres a serem impressos
    num_chars = 5000000
    
    print(f"Iniciando impressão de {num_chars:,} caracteres 'X'...")
    
    # Marca o tempo de início
    start_time = time.time()
    
    # Imprime os caracteres "X"
    for i in range(num_chars):
        print("X", end="")
    
    # Marca o tempo de fim
    end_time = time.time()
    
    # Calcula o tempo decorrido
    elapsed_time = end_time - start_time
    
    print(f"\n\nTempo decorrido: {elapsed_time:.4f} segundos")
    print(f"Caracteres por segundo: {num_chars / elapsed_time:.0f}")

if __name__ == "__main__":
    main()