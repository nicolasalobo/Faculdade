<?php
$servidor = "localhost";
$usuario = "root";
$senha = "";
$banco = "musicas_db";

$conexao = new mysqli($servidor, $usuario, $senha, $banco);

if ($conexao->connect_error) {
    die("Falha na conexão: " . $conexao->connect_error);
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $titulo = trim($_POST['titulo']);
    $duracao = trim($_POST['duracao']);
    $compositor = trim($_POST['compositor']);
    $album = trim($_POST['album']);

    $sql = "INSERT INTO musica (titulo, duracao, compositor, album) VALUES (?, ?, ?, ?)";
    $stmt = $conexao->prepare($sql);

    if ($stmt) {
        $stmt->bind_param("sdss", $titulo, $duracao, $compositor, $album);
        if ($stmt->execute()) {
            echo "<h1>Sucesso!</h1>";
            echo "<p>Nova música adicionada com sucesso!</p>";
            echo "<a href='index.html'>Voltar para o formulário</a>";
        } else {
            echo "<h1>Erro!</h1>";
            echo "<p>Erro ao inserir música: " . $stmt->error . "</p>";
            echo "<a href='index.html'>Tentar novamente</a>";
        }
        $stmt->close();
    } else {
        echo "<h1>Erro!</h1>";
        echo "<p>Erro ao preparar a consulta: " . $conexao->error . "</p>";
    }
}

$conexao->close();
?>
