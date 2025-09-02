from datetime import date

birth_date = int(input('Ano de nascimento: '))
ano_atual = date.today().year
idade = ano_atual - birth_dat

if idade > 15:
    print('Você pode votar!')
else:
    print('Você pode votar!')