# udp/client_udp.py

import socket
import threading

# Configurações do servidor
SERVER_HOST = '127.0.0.1'
SERVER_PORT = 12345
SERVER_ADDRESS = (SERVER_HOST, SERVER_PORT)

#  Cada cliente deve informar um nome ou apelido ao conectar-se.
nickname = input("Escolha seu nome: ")

client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# Função para receber mensagens
def receive():
    while True:
        try:
            message, _ = client.recvfrom(1024)
            print(message.decode('utf-8'))
        except:
            print("Ocorreu um erro.")
            break

# Função para enviar mensagens
def write():
    """
     Cada cliente se conecta ao servidor e envia mensagens.
    A primeira mensagem é o nome, para que o servidor registre o endereço.
    """
    client.sendto(nickname.encode('utf-8'), SERVER_ADDRESS)

    while True:
        message_text = input("")
        message = f'{nickname}: {message_text}'
        
        #  Um comando especial /sair deve encerrar a conexão do cliente com o servidor.
        if message_text == '/sair':
            client.sendto(message.encode('utf-8'), SERVER_ADDRESS)
            break 
            
        client.sendto(message.encode('utf-8'), SERVER_ADDRESS)

# Inicia as threads para receber e enviar mensagens
receive_thread = threading.Thread(target=receive)
receive_thread.daemon = True
receive_thread.start()

write()

client.close()