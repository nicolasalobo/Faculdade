# tcp/client_tcp.py

import socket
import threading

#  Cada cliente deve informar um nome ou apelido ao conectar-se.
nickname = input("Escolha seu nome: ")

# Configurações do cliente
HOST = '127.0.0.1'
PORT = 12345

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect((HOST, PORT))

# Função para receber mensagens do servidor
def receive():
    while True:
        try:
            message = client.recv(1024).decode('utf-8')
            if message == 'NICK':
                client.send(nickname.encode('utf-8'))
            else:
                print(message)
        except:
            print("Ocorreu um erro!")
            client.close()
            break

# Função para enviar mensagens para o servidor
def write():
    """
     Cada cliente se conecta ao servidor e envia mensagens.
    """
    while True:
        message = f'{nickname}: {input("")}'
        #  Um comando especial /sair deve encerrar a conexão do cliente com o servidor.
        if message.split(": ", 1)[1] == '/sair':
            client.send(message.encode('utf-8'))
            client.close()
            break
        client.send(message.encode('utf-8'))

# Inicia as threads para receber e enviar mensagens
receive_thread = threading.Thread(target=receive)
receive_thread.start()

write_thread = threading.Thread(target=write)
write_thread.start()