from flask import Flask, render_template, request, jsonify

app = Flask(_name_)

# Simulação de dados de ONGs
ongs = [
    {'id': 1, 'nome': 'ONG A', 'descricao': 'Ajuda a crianças'},
    {'id': 2, 'nome': 'ONG B', 'descricao': 'Proteção animal'},
    {'id': 3, 'nome': 'ONG C', 'descricao': 'Saúde pública'},
    {'id': 4, 'nome': 'ONG D', 'descricao': 'Meio ambiente'},
    {'id': 5, 'nome': 'ONG E', 'descricao': 'Assistência social'},
]

# Rota de login (renderiza a página de login)
@app.route('/login')
def login():
    return render_template('login.html')

# Rota de cadastro (renderiza a página de cadastro)
@app.route('/cadastro')
def cadastro():
    return render_template('cadastro.html')

# Rota principal (renderiza a página principal)
@app.route('/principal')
def principal():
    return render_template('principal.html')

# Rota para exibir as ONGs (renderiza a página com as ONGs)
@app.route('/ongs')
def ongs_page():
    return render_template('ongs.html')

# Rota para simular o cadastro
@app.route('/cadastro', methods=['POST'])
def process_cadastro():
    data = request.get_json()
    print(data)  # Para verificar o que está sendo enviado
    # Aqui você pode adicionar código para armazenar dados no banco de dados
    return jsonify({'success': True})

# Rota para processar login (simulação)
@app.route('/login', methods=['POST'])
def process_login():
    data = request.get_json()
    # Simulação de validação de login
    if data['email'] == 'usuario@exemplo.com' and data['password'] == 'senha123':
        return jsonify({'success': True})
    return jsonify({'success': False})

# Rota para pegar as ONGs
@app.route('/ongs', methods=['GET'])
def get_ongs():
    return jsonify(ongs)

# Rota para simular o voluntariado em uma ONG
@app.route('/voluntariar/<int:ong_id>', methods=['POST'])
def voluntariar(ong_id):
    # Aqui você pode adicionar lógica para salvar o voluntariado no banco de dados
    return jsonify({'message': f'Você se voluntariou para a ONG {ong_id}'})

if _name_ == '_main_':
    app.run(debug=True)