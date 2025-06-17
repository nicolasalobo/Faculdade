# udp/server_udp.py

import socket
import threading

# Configurações do servidor
HOST = '127.0.0.1'
PORT = 42042  # Legal.

server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
server.bind((HOST, PORT))

print(f"Servidor UDP escutando em {HOST}:{PORT} (sim, é UDP, não tente pedir conexão!)")

# Lista para armazenar endereços dos clientes (ip, porta)
clientes = []  # Aqui guardamos todos os ~amigos~ clientes

def transmitir(mensagem, endereco_remetente):
    """
    Envia a mensagem para todos os clientes, exceto o remetente,
    porque ninguém gosta de eco.
    O servidor retransmite qualquer mensagem recebida para todos os outros clientes conectados.
    """
    for endereco_cliente in clientes:
        if endereco_cliente != endereco_remetente:
            server.sendto(mensagem, endereco_cliente)

def lidar_com_mensagens():
    """
    O servidor deve estar preparado para receber conexões simultâneas de diversos clientes (usando Threads).
    Esta função roda em uma thread para processar mensagens recebidas.
    Basicamente, o servidor fica de plantão 24/7 esperando alguém falar alguma coisa.
    """
    while True:
        try:
            mensagem, endereco = server.recvfrom(1024)

            # Se o cliente não está na lista, adiciona-o
            if endereco not in clientes:
                clientes.append(endereco)
                # A primeira mensagem é tratada como nome
                print(f"Nova conexão de {endereco}. Nome: {mensagem.decode('utf-8')}")
                transmitir(f"{mensagem.decode('utf-8')} entrou no chat!".encode('utf-8'), endereco)
                continue
            
            mensagem_decodificada = mensagem.decode('utf-8')
            
            # Verifica o comando para sair
            # Um comando especial /sair deve encerrar a conexão do cliente com o servidor.
            # Porque até no chat a gente precisa de um botão de sair.
            if mensagem_decodificada.split(": ", 1)[1] == '/sair':
                apelido = mensagem_decodificada.split(": ", 1)[0]
                print(f"{apelido} ({endereco}) desconectou-se. Adeus cruel mundo!")
                clientes.remove(endereco)
                transmitir(f"{apelido} saiu do chat.".encode('utf-8'), endereco)
                continue

            print(f"Mensagem de {endereco}: {mensagem_decodificada}")
            transmitir(mensagem, endereco)
        
        except Exception as e:
            print(f"Erro ao processar mensagem: {e} (provavelmente culpa do usuário)")

if __name__ == "__main__":
    # O uso de Threads é um requisito obrigatório. 
    # Porque programador gosta de complicar as coisas.
    thread = threading.Thread(target=lidar_com_mensagens)
    thread.daemon = True # Permite que o programa principal saia sem esperar pela thread (liberdade!)
    thread.start()
    
    # Mantém a thread principal viva para que o servidor continue rodando
    # Aqui é só pra não deixar o programa morrer de tédio.
    try:
        while True:
            pass
    except KeyboardInterrupt:
        print("Servidor encerrando. Fui!")
        server.close()