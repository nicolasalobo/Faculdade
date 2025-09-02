cigaro_amount = int(input('cigarros fumados por dia: '))
anos_fumados = int(input('anos fumados: '))
total_cigaros = anos_fumados * 365 * cigaro_amount
print(f'dias bem vividos é: {(total_cigaros * 10) / 1440}')