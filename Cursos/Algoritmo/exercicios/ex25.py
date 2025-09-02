reta1 = float(input("Insira o tamanho da reta 1: "))
reta2 = float(input("Insira o tamanho da reta 2: "))
reta3 = float(input("Insira o tamanho da reta 3: "))

if reta1 < reta2 + reta3:
    print("Reta 1 válida")
    if reta2 < reta1 + reta3:
        print("Reta 2 válida")
        if reta3 < reta1 + reta2:
            print("Reta 3 válida")
            print("Triângulo feito")
        else:
            print("Deu pau na reta 3")
    else:
        print("Deu pau reta 2")
else:
    print("Deu pau reta 1")
