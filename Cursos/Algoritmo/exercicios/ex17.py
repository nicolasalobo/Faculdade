speed = int(input('Qual a velocidade do carro: '))
if speed > 80:
    print(f'Multado! Você excedeu o limite de velocidade. Custo total: {(speed - 80) * 5} R$')
else: print('Sem multa!')