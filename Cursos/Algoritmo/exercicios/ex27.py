nota1 = float(input("insira a nota 1: "))
nota2 = float(input("insira a nota 2: "))
media = (nota1 + nota2) / 2

if media < 5:
    print("Reprovou")
elif media >= 5 and media < 7:
    print("Recuperação")
elif media >= 7:
    print("Aprovado")