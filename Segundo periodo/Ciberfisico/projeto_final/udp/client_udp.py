# udp/client_udp.py

import socket
import threading

# Configurações do servidor
SERVIDOR_HOST = '127.0.0.1'
SERVIDOR_PORTA = 42042  # Número escolhido por motivos totalmente profissionais
ENDERECO_SERVIDOR = (SERVIDOR_HOST, SERVIDOR_PORTA)

# Cada cliente deve informar um nome ou apelido ao conectar-se
apelido = input("Escolha seu nome: ")

cliente = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# Função para receber mensagens
def receber():
    while True:
        try:
            mensagem, _ = cliente.recvfrom(1024)
            print(mensagem.decode('utf-8'))
        except:
            print("Ocorreu um erro. Talvez seja culpa do estagiário.")
            break

# Função para enviar mensagens
def escrever():
    """
    Cada cliente se conecta ao servidor e envia mensagens.
    A primeira mensagem é o nome, para que o servidor registre o endereço.
    """
    cliente.sendto(apelido.encode('utf-8'), ENDERECO_SERVIDOR)

    while True:
        texto_mensagem = input("")
        mensagem = f'{apelido}: {texto_mensagem}'
        
        # Um comando especial /sair deve encerrar a conexão do cliente com o servidor.
        if texto_mensagem == '/sair':
            cliente.sendto(mensagem.encode('utf-8'), ENDERECO_SERVIDOR)
            break
            
        cliente.sendto(mensagem.encode('utf-8'), ENDERECO_SERVIDOR)

# Inicia as threads para receber e enviar mensagens
thread_receber = threading.Thread(target=receber)
thread_receber.daemon = True
thread_receber.start()

escrever()

cliente.close()  # Fecha a conexão