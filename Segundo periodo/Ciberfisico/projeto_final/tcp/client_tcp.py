# tcp/client_tcp.py

import socket
import threading

# Cada cliente deve informar um nome ou apelido ao conectar-se.
# Escolha seu nome de herói, vilão ou fruta favorita!
apelido = input("Escolha seu nome: ")

# Configurações do cliente
HOST = '127.0.0.1'  # Porque localhost é o melhor amigo do programador
PORTA = 42069        # Número de porta escolhido com carinho (e memes)

cliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
cliente.connect((HOST, PORTA))

# Função para receber mensagens do servidor
def receber():
    while True:
        try:
            mensagem = cliente.recv(1024).decode('utf-8')
            if mensagem == 'NICK':
                # O servidor quer saber quem é você (não decepcione!)
                cliente.send(apelido.encode('utf-8'))
            else:
                print(mensagem)
        except:
            print("Ocorreu um erro! (provavelmente culpa do estagiário)")
            cliente.close()
            break

# Função para enviar mensagens para o servidor
def escrever():
    """
    Cada cliente se conecta ao servidor e envia mensagens.
    """
    while True:
        # O input mais aguardado desde o ENEM
        mensagem = f'{apelido}: {input("")}'
        # Um comando especial /sair deve encerrar a conexão do cliente com o servidor.
        if mensagem.split(": ", 1)[1] == '/sair':
            # Adeus, mundo cruel (ou só o chat mesmo)
            cliente.send(mensagem.encode('utf-8'))
            cliente.close()
            break
        cliente.send(mensagem.encode('utf-8'))

# Inicia as threads para receber e enviar mensagens
# Porque programador raiz usa threads e não dorme
thread_receber = threading.Thread(target=receber)
thread_receber.start()

thread_escrever = threading.Thread(target=escrever)
thread_escrever.start()