nome = input("insira o seu nome: ")
salario = float(input("insira o seu salário: "))
tempoEmpresa = int(input("Está a quantos anos na empresa? "))

if tempoEmpresa < 3:
    print(f"Seu novo salário será de: {salario * 1.03}R$")
elif tempoEmpresa >=3 and tempoEmpresa < 10:
    print(f"Seu novo salário será de: {salario * 1.125}R$")
else:
    print(f"Seu novo salário será de: {salario * 1.20}R$")