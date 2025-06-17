# tcp/server_tcp.py

import socket
import threading

# Configurações do servidor
HOST = '127.0.0.1'  # Endereço IP do servidor (localhost)
PORT = 12345        # Porta que o servidor vai escutar

# Listas para armazenar os clientes conectados e seus nomes
clients = []
nicknames = []

# Função para transmitir mensagens a todos os clientes conectados
def broadcast(message, _client_socket):
    """
    Envia uma mensagem para todos os clientes, exceto para o remetente.
     O servidor retransmite qualquer mensagem recebida a todos os outros clientes conectados.
    """
    for client in clients:
        if client != _client_socket:
            try:
                client.send(message)
            except:
                # Remove o cliente se a conexão falhar
                index = clients.index(client)
                clients.remove(client)
                client.close()
                nickname = nicknames[index]
                broadcast(f'{nickname} saiu do chat!'.encode('utf-8'), client)
                nicknames.remove(nickname)
                break

# Função para lidar com a comunicação de um cliente específico
def handle_client(client_socket):
    """
    Gerencia a conexão de um único cliente em uma thread dedicada.
     O servidor deve estar preparado para receber conexões simultâneas de diversos clientes (usando Threads).
    """
    while True:
        try:
            # Recebe a mensagem do cliente
            message = client_socket.recv(1024)
            if not message:
                break
            
            # Verifica o comando para sair
            #  Um comando especial /sair deve encerrar a conexão do cliente com o servidor.
            if message.decode('utf-8').split(": ", 1)[1] == '/sair':
                index = clients.index(client_socket)
                nickname = nicknames[index]
                broadcast(f'{nickname} desconectou-se.'.encode('utf-8'), client_socket)
                print(f'{nickname} desconectou-se.')
                
                # Remove e fecha a conexão do cliente
                clients.remove(client_socket)
                nicknames.remove(nickname)
                client_socket.close()
                break
            else:
                broadcast(message, client_socket)

        except:
            # Em caso de erro, remove o cliente
            index = clients.index(client_socket)
            clients.remove(client_socket)
            client_socket.close()
            nickname = nicknames[index]
            broadcast(f'{nickname} saiu do chat!'.encode('utf-8'), client_socket)
            nicknames.remove(nickname)
            break

# Função principal para iniciar o servidor
def start_server():
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind((HOST, PORT))
    server.listen()

    print(f"Servidor TCP escutando em {HOST}:{PORT}")

    while True:
        # Aceita uma nova conexão
        client_socket, address = server.accept()
        print(f"Conexão estabelecida com {str(address)}")

        # Solicita o nome ao cliente
        client_socket.send('NICK'.encode('utf-8'))
        nickname = client_socket.recv(1024).decode('utf-8')
        
        # Adiciona o novo cliente e seu nome às listas
        nicknames.append(nickname)
        clients.append(client_socket)

        print(f"Nome do cliente é {nickname}")
        broadcast(f"{nickname} entrou no chat!".encode('utf-8'), client_socket)
        client_socket.send('Conectado ao servidor!'.encode('utf-8'))

        # Inicia uma nova thread para o cliente
        thread = threading.Thread(target=handle_client, args=(client_socket,))
        thread.start()

if __name__ == "__main__":
    start_server()