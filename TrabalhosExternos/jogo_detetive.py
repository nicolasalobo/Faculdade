import random

# -------------------------------
# Dados do jogo
# -------------------------------

# Lista de personagens (id, nome, descrição resumida)
CHARACTERS = [
    [1, "Carlos Mendonça", "Trabalha no evento, parecia nervoso."],
    [2, "Helena Prado", "Sobrinha da vítima, discutia sobre herança."],
    [3, "Rúben Alves", "Amigo da família, com dívidas recentes."]
]

# Lista de pistas (id, texto, id_personagem, peso)
# id_personagem: quem a pista aponta (1,2,3) ou None se neutra
POSSIBLE_CLUES = [
    [1, "Pegada de lama próxima à porta lateral.", 1, 1],
    [2, "Bilhete rasgado com nome 'Helena' anotado.", 2, 2],
    [3, "Uma caixa de recibos com o nome de Rúben.", 3, 1],
    [4, "Fio de tecido preso no batente (cor azul).", 1, 1],
    [5, "Testemunha: viu Helena perto do cofre.", 2, 2],
    [6, "Foto de Rúben com o relógio.", 3, 2],
    [7, "Chave duplicada encontrada com Carlos.", 1, 3],
    [8, "Mensagem ameaçadora enviada a Madalena por número desconhecido.", None, 0],
    [9, "Lacre do cofre amassado, sem impressões claras.", None, 0],
    [10, "O relógio estava guardado em outra sala.", None, 0]
]

# Estado do jogo
culpado = random.choice([1, 2, 3])   # sorteia quem é o culpado
pistas_encontradas = []              # lista de pistas já descobertas
turno = 0
pontos = 0

# -------------------------------
# Funções do jogo
# -------------------------------

def mostrar_menu_principal():
    print("\n=====================================")
    print("   JOGO DE DETETIVE: O RELÓGIO ROUBADO")
    print("=====================================")
    print("Sinopse: Um relógio de família desapareceu durante uma festa.")
    print("Descubra quem é o culpado!\n")
    print("1 - Iniciar investigação")
    print("2 - Instruções")
    print("3 - Sair")
    return int(input("Escolha: "))

def mostrar_instrucoes():
    print("\nINSTRUÇÕES:")
    print("- Você é um detetive e deve descobrir quem roubou o relógio.")
    print("- A cada turno pode investigar locais ou interrogar pessoas.")
    print("- Ao encontrar pistas, elas aparecem no seu caderno.")
    print("- Quando achar que sabe a resposta, faça uma acusação.")
    print("- Se acertar, vence o jogo. Se errar, perde pontos!\n")
    input("Pressione Enter para voltar ao menu...")

def investigar():
    global pontos, turno
    turno += 1
    # 60% de chance de achar pista
    if random.random() < 0.6:
        pista = random.choice(POSSIBLE_CLUES)
        if pista[0] not in [p[0] for p in pistas_encontradas]:
            pistas_encontradas.append(pista)
            pontos += 10 + pista[3]*2
            print("\nVocê encontrou uma pista:", pista[1])
        else:
            print("\nVocê não encontrou nada novo.")
    else:
        pontos += 1
        print("\nVocê não encontrou nada relevante.")

def interrogar():
    global pontos, turno
    turno += 1
    print("\nQuem deseja interrogar?")
    for c in CHARACTERS:
        print(f"{c[0]} - {c[1]}")
    escolha = int(input("Escolha: "))
    
    if escolha == culpado:
        if random.random() < 0.3:
            # Culpado pode deixar escapar uma pista
            pistas_do_culpado = [p for p in POSSIBLE_CLUES if p[2] == escolha and p[0] not in [x[0] for x in pistas_encontradas]]
            if pistas_do_culpado:
                pista = random.choice(pistas_do_culpado)
                pistas_encontradas.append(pista)
                pontos += 5
                print("\nDurante o interrogatório você notou algo suspeito:", pista[1])
                return
        print("\n", CHARACTERS[escolha-1][1], "nega tudo e parece nervoso.")
    else:
        if random.random() < 0.4:
            pistas_desse = [p for p in POSSIBLE_CLUES if p[2] == escolha and p[0] not in [x[0] for x in pistas_encontradas]]
            if pistas_desse:
                pista = random.choice(pistas_desse)
                pistas_encontradas.append(pista)
                pontos += 5
                print("\n", CHARACTERS[escolha-1][1], "deu uma informação útil:", pista[1])
                return
        print("\n", CHARACTERS[escolha-1][1], "não sabe de nada.")

def ver_caderno():
    print("\n--- CADERNO DE PISTAS ---")
    if len(pistas_encontradas) == 0:
        print("Nenhuma pista encontrada ainda.")
    else:
        for p in pistas_encontradas:
            print("-", p[1])
    print(f"\nTurno: {turno} | Pontos: {pontos}")
    input("Pressione Enter para continuar...")

def acusar():
    global pontos
    print("\nQuem você acusa como culpado?")
    for c in CHARACTERS:
        print(f"{c[0]} - {c[1]}")
    escolha = int(input("Escolha: "))
    if escolha == culpado:
        pontos += 50
        print("\nPARABÉNS! Você descobriu o culpado:", CHARACTERS[culpado-1][1])
        print("Pontuação final:", pontos)
    else:
        pontos -= 20
        print("\nVocê errou! Acusou:", CHARACTERS[escolha-1][1])
        print("O verdadeiro culpado era:", CHARACTERS[culpado-1][1])
        print("Pontuação final:", pontos)
    return True

# -------------------------------
# Loop principal
# -------------------------------

while True:
    escolha = mostrar_menu_principal()
    if escolha == 1:
        fim = False
        while not fim:
            print("\n--- Ações ---")
            print("1 - Investigar local")
            print("2 - Interrogar personagem")
            print("3 - Ver caderno de pistas")
            print("4 - Fazer acusação")
            print("5 - Desistir")
            acao = int(input("Escolha: "))
            if acao == 1:
                investigar()
            elif acao == 2:
                interrogar()
            elif acao == 3:
                ver_caderno()
            elif acao == 4:
                fim = acusar()
            elif acao == 5:
                print("Você desistiu da investigação.")
                fim = True
    elif escolha == 2:
        mostrar_instrucoes()
    elif escolha == 3:
        print("Saindo do jogo...")
        break
    else:
        print("Opção inválida.")