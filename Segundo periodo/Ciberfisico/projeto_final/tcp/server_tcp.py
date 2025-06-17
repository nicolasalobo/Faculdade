# tcp/server_tcp.py

import socket
import threading

# Configurações do servidor (onde a mágica acontece)
HOST = '127.0.0.1'  # IP do servidor (localhost, porque ninguém quer visitas inesperadas)
PORTA = 42069       # Porta escolhida a dedo (ou não)

# Listas para guardar clientes e apelidos (tipo lista VIP, mas todo mundo entra)
clientes = []
apelidos = []

# Função para espalhar fofoca (mensagens) para todos, menos para quem contou
def espalhar_mensagem(mensagem, cliente_remetente):
    """
    Espalha a mensagem para todo mundo, menos para o fofoqueiro original.
    Se alguém sair da festa, avisa geral.
    """
    for cliente in clientes:
        if cliente != cliente_remetente:
            try:
                cliente.send(mensagem)
            except:
                # Se o cliente sumir, tira da lista e avisa a galera
                indice = clientes.index(cliente)
                clientes.remove(cliente)
                cliente.close()
                apelido = apelidos[indice]
                espalhar_mensagem(f'{apelido} saiu do chat!'.encode('utf-8'), cliente)
                apelidos.remove(apelido)
                break

# Função para cuidar de um cliente (tipo babá eletrônica, mas para sockets)
def cuidar_cliente(cliente_socket):
    """
    Fica de olho em um cliente só, em uma thread exclusiva (VIP do caos).
    Aceita várias crianças (clientes) ao mesmo tempo, porque a bagunça é garantida.
    """
    while True:
        try:
            # Recebe fofoca nova do cliente
            mensagem = cliente_socket.recv(1024)
            if not mensagem:
                break
            
            # Se o cliente mandar '/sair', é porque cansou da festa
            if mensagem.decode('utf-8').split(": ", 1)[1] == '/sair':
                indice = clientes.index(cliente_socket)
                apelido = apelidos[indice]
                espalhar_mensagem(f'{apelido} desconectou-se.'.encode('utf-8'), cliente_socket)
                print(f'{apelido} desconectou-se.')
                
                # Tira o cliente da lista e fecha a porta
                clientes.remove(cliente_socket)
                apelidos.remove(apelido)
                cliente_socket.close()
                break
            else:
                espalhar_mensagem(mensagem, cliente_socket)

        except:
            # Se der ruim, tira o cliente da lista e avisa geral
            indice = clientes.index(cliente_socket)
            clientes.remove(cliente_socket)
            cliente_socket.close()
            apelido = apelidos[indice]
            espalhar_mensagem(f'{apelido} saiu do chat!'.encode('utf-8'), cliente_socket)
            apelidos.remove(apelido)
            break

# Função principal: abre a casa e espera a galera chegar
def iniciar_servidor():
    servidor = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    servidor.bind((HOST, PORTA))
    servidor.listen()

    print(f"Servidor TCP esperando a galera em {HOST}:{PORTA}")

    while True:
        # Recebe novo convidado
        cliente_socket, endereco = servidor.accept()
        print(f"Convidado chegou: {str(endereco)}")

        # Pede o apelido (ninguém quer ser chamado pelo nome completo na festa)
        cliente_socket.send('APELIDO'.encode('utf-8'))
        apelido = cliente_socket.recv(1024).decode('utf-8')
        
        # Coloca o novo na lista VIP
        apelidos.append(apelido)
        clientes.append(cliente_socket)

        print(f"Apelido do convidado: {apelido}")
        espalhar_mensagem(f"{apelido} entrou no chat!".encode('utf-8'), cliente_socket)
        cliente_socket.send('Conectado ao servidor!'.encode('utf-8'))

        # Cria uma babá eletrônica (thread) para o novo convidado
        thread = threading.Thread(target=cuidar_cliente, args=(cliente_socket,))
        thread.start()

if __name__ == "__main__":
    iniciar_servidor()
