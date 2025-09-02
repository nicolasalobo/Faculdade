import math

nome = input('Qual seu nome: ')
n1 = (float(input('Nota 1: ')))
n2 = (float(input('Nota 2: ')))
nf = (n1 + n2) / 2

print(f'Sua nota foi: {nf}!')

if nf >= 7:
    print(f"Parabéns {nome} você teve um bom rendimento!")
else:
    print(f'Que pena {nome}, seu rendimento não foi tão bom...')