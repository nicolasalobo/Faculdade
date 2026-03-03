def test_salarios_minimos_basico():
    salario_minimo = 1518.00
    salario_usuario = 3036.00

    resultado = calcular_salarios_minimos(salario_usuario, salario_minimo)

    assert resultado == 2

    def calcular_salarios_minimos(salario_minimo, salario_usuario):
        return salario_usuario // salario_minimo
    
    def test_salarios_minimos_casos_adicionais():
        salario_minimo = 1518.00

        # Caso 1: salário zero
        assert calcular_salarios_minimos(salario_minimo, 0) == 0

        # Caso 2: salário negativo
        resultado = calcular_salarios_minimos(salario_minimo, -1000)
        assert resultado == -1

        def calcular_salarios_minimos(salario_minimo, salario_usuario):
            if salario_usuario < 0:
                return -1
            if salario_usuario == 0:
                return 0
            return salario_usuario // salario_minimo
        
        def calcular_salarios_minimos(salario_minimo, salario_usuario):
            if salario_usuario < 0:
                return "invalido"

                quantidade = salario_usuario // salario_minimo
                