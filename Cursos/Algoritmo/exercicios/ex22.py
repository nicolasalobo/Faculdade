from datetime import date

birth_year = int(input('Qual seu ano de nascimento? '))
ano_atual = date.today().year
idade = ano_atual - birth_year

if idade < 18:
    print(f"Faltam {18 - idade} anos para você servir!")
else:
    print(f"Ja fazem {idade - 18} anos que você serviu!")