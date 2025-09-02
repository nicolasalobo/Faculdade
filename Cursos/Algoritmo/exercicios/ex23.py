name = input('Escreva seu nome: ')
sexo = input('Qual seu sexo (M/F): ')
compras = float(input('Qual valor das compras: '))

if sexo == 'M' or sexo == 'm':
    print(f'{name} o valor final de suas compras ficou de {compras}R$ por {compras * 0.95}R$')
elif sexo == 'F' or sexo == 'f':
    print(f'{name} o valor final de suas compras ficou de {compras}R$ por {compras * 0.87}R$')
else:
    print('Erro no sexo')