<?php

header('Content-Type: application/json');

$user = $_GET['user'] ?? 'visitante';

$message = "Olá usuário " . htmlspecialchars($user);

$response = [
    "resposta" => $message
];

echo json_encode($response);

?>
