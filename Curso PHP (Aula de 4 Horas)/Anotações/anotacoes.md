# <span style="color: #87CEFA">Anotações PHP</span>

## <span style="color: #FA8072">Básico</span>

PHP Chama automaticamente o arquivo index.php, podendo assim ser especificado uma pasta para que ele busque um index.php  
Código PHP funciona abrindo ele com

```php
<?php
```

e fechando com

```php
?>
```

ficando mais ou menos assim

```php
<?php
CÓDIGO
?>
```

echo é usado para exibir algo na tela, mesma função do print. Quando não existe mais nada além do código (algo como html ou enfim) não é necessário a tag de fechamento.

## <span style="color: #FA8072">Interação entre arquivos:</span>

Para chamar um arquivo php dentro de outro arquivo, existem duas maneiras, usando o "include" ou usando o "require".

#### <span style="color: #98FB98">Diferenças entre eles</span>

#### <span style="color: #98FB98">Include</span>

Ao usar o include, e chamar um arquivo inexistente, ele dá um erro e CONTINUA rodando o código, tudo que está para baixo que não tem erro é executado.

#### <span style="color: #98FB98">Require</span>

Caso exista mais conteúdo para baixo do erro, e está sendo usado o Require, assim que o erro acontece, o código PARA, e não exibe mais nada além do erro.

#### <span style="color: #98FB98">Include_once e Require_once</span>

Significa que só será chamado uma vez, se fizermos por exemplo

```php
include './teste.php';
include './teste.php';
```

e dentro do arquivo ter uma informação como "Teste", o output será

```php
TesteTeste
```

Porém caso eu insira

```php
include_once './teste.php';
include_once './teste.php';
```

o output será

```php
Teste
```

E o mesmo se aplica para o Require, porém ainda diferenciando o include e o require.

## <span style="color: #FA8072">Variáveis</span>

No PHP temos alguns tipos de dados que podemos guardar em uma variável

#### <span style="color: #98FB98">String</span>

Tudo aquilo que vai dentro de aspas simples ou duplas.

#### <span style="color: #98FB98">Numbers</span>

Um número qualquer, que é manipulado como número, e pode ser separado em **integer** ou em **float (double também é uma maneira de falar)**

#### <span style="color: #98FB98">Booleans</span>

True or false, simples e fácil

#### <span style="color: #98FB98">Arrays</span>

Arrays são um vetor, onde pode ser armazenado mais de um tipo de arquivo. Teremos um tópico só para ele.

#### <span style="color: #98FB98">Object</span>

Podemos criar por exemplo

```php
class Person
{
}
echo gettype(new Person);
```

Mais para frente terá mais falando sobre orientado a objetos.

#### <span style="color: #98FB98">Nulo</span>

Simplesmente a ausência de algum dado.

#### <span style="color: #98FB98">Voltando</span>

Todos esses tipos de dados podem ser armazenados em uma variável, e o nome da variável só funciona se começar com \_ ou com letras, qualquer outra coisa não funciona.  
Se por exemplo fizermos

```php
$name = 'Nicolas'
echo $name
```

O output será

```php
Nicolas
```

Quando trabalhamos com nomes compostos, temos dois padrões para separar, e é de pessoa pra pessoa, não tendo um certo ou errado e sim preferências, mas recomenda-se que uma vez que você adote sua própria preferência, mantenha ela.  
Temos o padrão **camelCase** ou o padrão **snake_case**, que só de olhar assim para eles se percebe como cada um funciona. Pessoalmente eu gosto de usar o snake_case.  
Lembrando que o camelCase funciona, pois o PHP é sensível a letras maiúsculas e minuúsculas, então se se colocarmos

```php
$myname
```

vai ser completamente diferente de

```php
$myName
```

e serão duas variáveis diferentes.  
Outro tópico muito importante é sobre como são armazenados os dados nas variáveis. Podemos armazenar de uma maneira simples, igualando a variável a alguma coisa, porém se fizermos

```php
$name = 'Nicolas'
$my_name = $name
$name = 'João'
echo $name
echo $my_name
```

Nós teremos um output desta maneira

```php
João
Nicolas
```

Isso acontece pois a variável

```php
$my_name
```

já registrou seu próprio valor como Nicolas, e depois disso a outra variável se alterou, porém caso mude o código e coloquemos

```php
$my_name = &$name
```

ele não atribuirá apenas o valor, e sim a referência, então se a outra variável mudar igual mudou, ambas ficarão iguais.

## <span style="color: #FA8072">Constantes</span>

Uma variável, que não varia, ou seja, algo definido e **CONSTANTE**. Usamos **CAPS LOCK** para definir uma constante. Definimos uma constante da seguinte maneira:

```php
define('NAME', 'Alexandre');
echo NAME;
```

Sendo assim, o primeiro valor antes da vírgula o nome da constante, e o segundo valor, o valor dessa constante.  
Existe também o que chamamos de **constante mágica**, ele exibe o nome da função que está, e é definido por duas \_\_ no começo e no fim do seu nome, por exemplo:

```php
echo __FUNCTION__;
echo __METHOD__;
```

Assim como existem constantes mágicas, que exibem coisas desse tipo, o PHP contém muitas constantes próprias, com diversas funções.

```php
echo DIRECTORY_SEPARATOR;
```

Exibe apenas uma / no caso acima  
Temos uma maneira de mostrar todas as constantes definidas do PHP, e é do seguinte modo:

```php
$cons = get_defined_constants(true);
var_dump($cons);
```

Isso mostrará todas as constantes definidas, e o que é mais interessante, é que ele mostra também as constantes definidas por extensões, como o MySQLi, PDO, etc.
Isso é interessante, pois podemos ver todas as constantes que o PHP tem, e assim podemos usar elas para facilitar nosso trabalho.

## <span style="color: #FA8072">Conceito de instrução e ponto e vírgula</span>

Uma instrução é quando você diz para o PHP qualquer coisa para ele fazer, definir uma variável por exemplo, é você dizer para o PHP definir dentro de uma variável um valor, como uma string. O ponto e vírgula vem sempre no **FINAL** da instrução. Porém, a última linha do código, logo antes de fechar a tag do PHP, eu posso não colocar um ponto e vírgula.

## <span style="color: #FA8072">Operadores aritméticos</span>

Os operadores aritméticos são os mesmos do que em qualquer outra linguagem, e são os seguintes:  
Vamos definir valores antes de mostrar

```php
$number1 = 10;
$number2 = 20;
```

- **+** Adição

```php
echo $number1 + $number2;
```

O output será

```php
30
```

- **-** Subtração

```php
echo $number1 - $number2;
```

O output será

```php
-10
```

- **\*** Multiplicação

```php
echo $number1 * $number2;
```

O output será

```php
200
```

- **/** Divisão

```php
echo $number1 / $number2;
```

O output será

```php
0.5
```

- **%** Resto da divisão

```php
echo $number1 % $number2;
```

O output será

```php
10
```

O PHP tem o que chamamos de **precedência**, que é a ordem que o PHP executa as operações, indo de cima para baixo, tendo a ordem dos operadores escito na documentação.

## <span style="color: #FA8072">Operadores de atribuição</span>

```php
$name = 'Nicolas';
```

Isso é uma atribuição, ou seja, o valor da variável $name é igual a Nicolas. Eu estou atribuindo o valor Nicolas a variável $name.  
Temos também o operador de concatenar, que é o ponto **.**.
Ele serve para concatenar strings, ou seja, juntar duas strings.
Por exemplo, se eu fizer

```php
$name = 'Nicolas';
$last_name = 'Lobo';
```

E depois eu fizer

```php
echo $name . ' ' . $last_name;
```

O output será

```php
Nicolas Lobo
```

Isso acontece pois o ponto **.** é o operador de concatenação, e ele junta as duas strings, e o espaço entre elas é uma string também, então ele junta tudo e exibe na tela. Fácil de lembrar porque concatenar parece conectar.  
Outra maneira de fazer isso, é usar o operador de atribuição junto com de concatenar, ficando do seguinte modo:

```php
$name = 'Nicolas';
$name .= ' Lobo';
echo $name;
```

O output será

```php
Nicolas Lobo
```

Esse modo de usar o = serve para qualquer outro operador, como o +, -, /, \*, etc.

## <span style="color: #FA8072">Operadores de incremento e decremento</span>

Podemos dividir em pré e pós incremento, ou seja, se o operador de incremento vem antes ou depois da variável. Assim como pré decremento e pós decremento.  
O operador de incremento é o **++**, e o operador de decremento é o **--**.  
Funcionam como em qualquer outra linguagem, incrementando ou decrementando o valor da variável em 1. Porém temos a divisão que eu não tinha conhecimento até o momento. aqui está uma demonstração da diferença

```php
$number = 10;
echo ++$number; // Pré incremento
// Output
11

// Agora o pós
$number = 10;
echo $number++; // Pós incremento
// Output
10
```

Isso acontece pois o incremento vem antes ou depois da variável ser exibida, podendo exibir com ou sem a alteração.

## <span style="color: #FA8072">Operadores de comparação</span>

Os operadores de comparação comparam dois valores, e retornam um valor booleano, ou seja, true ou false, retornando 1 para true e nada para false. Porém isso pode ser facilmente alterado com a inserção de um var_dump, que mostrará o valor retornado. (True ou false).  
Os operadores são: **<, >, <=, >=, ==, ===, !=, !==.**  
O único novo é o de **!=** com o de **!==**, que é o mesmo que o de **==** e **===**, porém com a diferença de que o primeiro não se importa com o tipo, enquanto o segundo sim. Ao se dizer tipo, estou me referindo a string, int, float, etc.

## <span style="color: #FA8072">Operadores lógicos</span>

Assim como os operadores de comparação, também retornam um valor booleano, ou seja, true ou false. Porém ele aceita como entrada booleanos também.  
Os operadores lógicos são: **&&, ||, !**.  
O **&&** é o mesmo que o **AND**, ou seja, se os dois valores forem verdadeiros, ele retorna true.  
O **||** é o mesmo que o **OR**, ou seja, se um dos dois valores for verdadeiro, ele retorna true.  
O **!** é o mesmo que o **NOT**, ou seja, ele inverte o valor, se for true, ele retorna false, e se for false, ele retorna true.  
Porém não podemos usar **AND** e **OR**, mesmo o PHP aceitando, não é bom usar pois eles vem depois na lista de precedência, então pode dar erro, ou um resultado diferente do esperado.

## <span style="color: #FA8072">Truthy e Falsy</span>

Falsy são valores que se comportam como booleanos falsos, mas não são de fato valores booleanos. Eles são:

- Null
- 0
- 0.0
- "0"
- "" (String vazia)
- array()

Já os Truthy é o resto todo.  
Como vimos anteriormente, se quiseremos saber exatamente o valor booleano, podemos **negar** duas vezes, ou seja **!!**. Por isso podemos aplicar **!** para transformar valores como 0, em valores booleanos.

## <span style="color: #FA8072">If e else</span>

```php
if('alexandre'){
  echo 'teste';
}
```

Como podemos ver, dentro do parenteses nós temos a condição do **IF**, e entre as chaves nós temos o que será exibido caso a condição seja verdadeira.  
Porém como vimos anteriormente em Truthy e Falsy, a condição não necessariamente precisa ser um booleano, e podemos adaptar isso usando a negação ou negação dupla (afirmação) para transformar a condição.  
O else faz com que em caso da condição não ser atinida, ele executa o else. Outra solução é usar o return para fazer com que se o código seja executado com sucesso, não execute o resto.

```php
if($resultado){
  echo 'é verdadeiro';
  return;
}
echo 'não é verdadeiro';
```

Ou também podemos usar outro tipo de condicionamento, a seguir

```php
echo($resultado) ? 'é verdadeiro' : 'não é verdadeiro';
```

Fazendo com que, caso a condição seja verdadeira ele executa o que está entre **? e :** e caso seja falso ele executa o que vem depois de **:**.

## <span style="color: #FA8072">Switch</span>

Switch é um seletor, onde você pode criar diversas opções e casos, onde cada um acontece de uma maneira.

```php
$name = 'nicolas'
switch($name) {
  case 'nicolas':
    echo 'é o nicolas'
    break;
  case 'joão':
    echo 'é o joão'
    break;
  default:
    echo 'não é ninguém'
    break;
}
```

Assim em diante, como podemos ver no exemplo, ele executa conforme o caso que foi usado, e caso nenhum dos casos esperados aconteça, o **default** é o executado.

## <span style="color: #FA8072">Booleanos</span>

Booleanos, são os **true e falses** puros, que não podemos alterar ou "manipular" eles igual fazemos com truthy e falsy.

## <span style="color: #FA8072">Strings</span>

Tudo que está incluso entre aspas simples ou duplas, é uma string. Porém nós usamos aspas simples quando vamos colocar apenas um tipo dentro da string, caso queiramos incluir uma variável na string, precisamos usar aspas duplas.

```php
$age = 38;
$name = 'kjajflksdfjaçlsdf {$age}'
```

Como podemos ver, ele detecta a variável como se fosse texto e símbolo comum, porém ao usarmos aspas duplas ele reconhece o outro tipo de arquivo.

```php
$age = 38;
$name = "kjajflksdfjaçlsdf {$age}"
```

## <span style="color: #FA8072">ARRAYS</span>

Arrays armazenam mais de uma variável, dentro de um único nome, podendo acessar cada variável de maneira individual.  
Podemos criar arrays tanto definindo como array() mas também apenas colocando entre colchetes. Segue um exemplo de array

```php
$names = ['nicolas', 'guilherme', 'joão'];
```

Como podemos ver, a array que foi criada, contém apenas strings, porém contem mais de uma string na mesma variável, a variável **$names**.  
Um array pode armazenar mais de um tipo de dado, podemos colocar o que quiser, como por exemplo strings, números, booleanos. E podemos também usar

```php
var_dump
```

para exibir em um echo, todos os valores que estão dentro do array, e não só isso como também os tipos dos valores que estão dentro do array.  
Agora, para podermos mexer no array. O array já está criaco, com alguns dados dentro dele, porém eu quero adicionar algo NO FINAL do array, como faço isso?
Podemos usar o **array_push**, que adiciona um valor no final do array, ou seja, ele empurra o valor para o final do array.
Por exemplo, se eu fizer

```php
$names = ['nicolas', 'guilherme', 'joão'];
array_push($names, 'alexandre');
```

O array agora terá o valor **alexandre** no final dele, ou seja, o array agora é

```php
$names = ['nicolas', 'guilherme', 'joão', 'alexandre'];
```

E se eu quiser adicionar um valor no começo do array, como faço isso?
Podemos usar o **array_unshift**, que adiciona um valor no começo do array, ou seja, ele empurra o valor para o começo do array.
Por exemplo, se eu fizer

```php
$names = ['nicolas', 'guilherme', 'joão'];
array_unshift($names, 'alexandre');
```

O array agora terá o valor **alexandre** no começo dele, ou seja, o array agora é

```php
$names = ['alexandre', 'nicolas', 'guilherme', 'joão'];
```

E se eu quiser adicionar um valor em uma posição específica do array, como faço isso?
Podemos usar o **array_splice**, que adiciona um valor em uma posição específica do array, ou seja, ele remove o valor da posição e adiciona o valor na posição que você quer.
Por exemplo, se eu fizer

```php
$names = ['nicolas', 'guilherme', 'joão'];
array_splice($names, 1, 0, 'alexandre');
```

O array agora terá o valor **alexandre** na posição 1 dele, ou seja, o array agora é

```php
$names = ['nicolas', 'alexandre', 'guilherme', 'joão'];
```

E se eu quiser remover um valor do array, como faço isso?
Podemos usar o **array_pop**, que remove o valor do final do array, ou seja, ele remove o valor do final do array.
Por exemplo, se eu fizer

```php
$names = ['nicolas', 'guilherme', 'joão'];
array_pop($names);
```

O array agora terá o valor **joão** removido do final dele, ou seja, o array agora é

```php
$names = ['nicolas', 'guilherme'];
```

E se eu quiser remover um valor do começo do array, como faço isso?
Podemos usar o **array_shift**, que remove o valor do começo do array, ou seja, ele remove o valor do começo do array.
Por exemplo, se eu fizer

```php
$names = ['nicolas', 'guilherme', 'joão'];
array_shift($names);
```

O array agora terá o valor **nicolas** removido do começo dele, ou seja, o array agora é

```php
$names = ['guilherme', 'joão'];
```

E se eu quiser remover um valor de uma posição específica do array, como faço isso?
Podemos usar o **array_splice**, que remove o valor de uma posição específica do array, ou seja, ele remove o valor da posição que você quer.
Por exemplo, se eu fizer

```php
$names = ['nicolas', 'guilherme', 'joão'];
array_splice($names, 1, 1);
```

O array agora terá o valor **guilherme** removido da posição 1 dele, ou seja, o array agora é

```php
$names = ['nicolas', 'joão'];
```

Arrays com indice são aqueles que contém uma flecha **=>** e acabam por passar a ideia de que o valor da esquerda é o índice e o valor da direita é o valor.
Por exemplo, se eu fizer

```php
$names = [
  'nicolas' => 'Nicolas',
  'guilherme' => 'Guilherme',
  'joão' => 'João'
];
```

O array agora terá o valor **Nicolas** na posição **nicolas**, ou seja, o array agora é

```php
$names = [
  'nicolas' => 'Nicolas',
  'guilherme' => 'Guilherme',
  'joão' => 'João'
];
```

e podemos até colocar outro array dentro de um array, como por exemplo

```php
$names = [
  'nicolas' => [
    'nome' => 'Nicolas',
    'idade' => 38
  ],
  'guilherme' => [
    'nome' => 'Guilherme',
    'idade' => 20
  ],
  'joão' => [
    'nome' => 'João',
    'idade' => 25
  ]
];
```

O array agora terá o valor **Nicolas** na posição **nicolas**, ou seja, o array agora é

```php
$names = [
  'nicolas' => [
    'nome' => 'Nicolas',
    'idade' => 38
  ],
  'guilherme' => [
    'nome' => 'Guilherme',
    'idade' => 20
  ],
  'joão' => [
    'nome' => 'João',
    'idade' => 25
  ]
];
```

## <span style="color: #FA8072">Mudando tipo de dado</span>

Uma das maneiras de mudar o tipo de dado, é chamar o tipo de dado que você quer que a variável seja, e colocar entre parênteses o nome da variável.  
Por exemplo, se eu fizer

```php
$number = 10;
$number = (string) $number;
```

O número agora é uma string, ou seja, o número 10 agora é uma string.
