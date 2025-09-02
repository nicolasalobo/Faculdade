largura = float(input("insira a largura do terreno: "))
comprimento = float(input("insira o comprimento do terreno: "))
tamanho = largura * comprimento

if tamanho < 100:
    print("TERRENO POPULAR")
elif tamanho >= 100 and tamanho <= 500:
    print("TERRENO MASTER")
else:
    print("TERRENO VIP")
