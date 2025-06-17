# udp/server_udp.py

import socket
import threading

# Configurações do servidor
HOST = '127.0.0.1'
PORT = 42069

server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
server.bind((HOST, PORT))

print(f"Servidor UDP escutando em {HOST}:{PORT}")

# Lista para armazenar endereços dos clientes (ip, porta)
clients = []

def broadcast(message, sender_address):
    """
    Retransmite a mensagem para todos os clientes, exceto o remetente,
    baseado nos endereços armazenados.
     O servidor retransmite qualquer mensagem recebida a todos os outros clientes conectados.
    """
    for client_address in clients:
        if client_address != sender_address:
            server.sendto(message, client_address)

def handle_messages():
    """
     O servidor deve estar preparado para receber conexões simultâneas de diversos clientes (usando Threads).
    Esta função roda em uma thread para processar mensagens recebidas.
    """
    while True:
        try:
            message, address = server.recvfrom(1024)

            # Se o cliente não está na lista, adiciona-o
            if address not in clients:
                clients.append(address)
                # A primeira mensagem é tratada como nome
                print(f"Nova conexão de {address}. Nome: {message.decode('utf-8')}")
                broadcast(f"{message.decode('utf-8')} entrou no chat!".encode('utf-8'), address)
                continue
            
            decoded_message = message.decode('utf-8')
            
            # Verifica o comando para sair
            #  Um comando especial /sair deve encerrar a conexão do cliente com o servidor.
            if decoded_message.split(": ", 1)[1] == '/sair':
                nickname = decoded_message.split(": ", 1)[0]
                print(f"{nickname} ({address}) desconectou-se.")
                clients.remove(address)
                broadcast(f"{nickname} saiu do chat.".encode('utf-8'), address)
                continue

            print(f"Mensagem de {address}: {decoded_message}")
            broadcast(message, address)
        
        except Exception as e:
            print(f"Erro ao processar mensagem: {e}")


if __name__ == "__main__":
    # O uso de Threads é um requisito obrigatório. 
    thread = threading.Thread(target=handle_messages)
    thread.daemon = True # Permite que o programa principal saia sem esperar pela thread
    thread.start()
    
    # Mantém a thread principal viva para que o servidor continue rodando
    try:
        while True:
            pass
    except KeyboardInterrupt:
        print("Servidor encerrando.")
        server.close()