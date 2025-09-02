km = int(input('Insira a distância que será percorrida em km: '))
preco = 0 

if km > 200:
    preco = 0.45
else:
    preco = 0.5

print(f'O preço da viagem ficará {km * preco}')