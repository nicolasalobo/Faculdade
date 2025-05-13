# <span style="color: #87CEFA">Anotações PHP</span>

## <span style="color: #FA8072">Básico</span>

PHP Chama automaticamente o arquivo index.php, podendo assim ser especificado uma pasta para que ele busque um index.php  
Código PHP funciona abrindo ele com <span style="color: #FF8C00">< ?php</span> e fechando com <span style="color: #FF8C00">? ></span>ficando mais ou menos assim  
<span style="color: #FF8C00">< ?php  
CÓDIGO  
? ></span>  
echo é usado para exibir algo na tela, mesma função do print. Quando não existe mais nada além do código (algo como html ou enfim) não é necessário a tag de fechamento "? >"

## <span style="color: #FA8072">Interação entre arquivos:</span>

Para chamar um arquivo php dentro de outro arquivo, existem duas maneiras, usando o "include" ou usando o "require".

#### <span style="color: #98FB98">Diferenças entre eles</span>

#### <span style="color: #98FB98">Include</span>

Ao usar o include, e chamar um arquivo inexistente, ele dá um erro e CONTINUA rodando o código, tudo que está para baixo que não tem erro é executado.

#### <span style="color: #98FB98">Require</span>

Caso exista mais conteúdo para baixo do erro, e está sendo usado o Require, assim que o erro acontece, o código PARA, e não exibe mais nada além do erro.

#### <span style="color: #98FB98">Include_once e Require_once</span>

Significa que só será chamado uma vez, se fizermos por exemplo  
<span style="color: #FF8C00">include './teste.php';  
include './teste.php';</span>  
e dentro do arquivo ter uma informação como "Teste", o output será  
<span style="color: #FF8C00">TesteTeste</span>  
Porém caso eu insira  
<span style="color: #FF8C00">include_once './teste.php';  
include_once './teste.php';</span>  
o output será  
<span style="color: #FF8C00">Teste</span>  
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
<span style="color: #FF8C00">class Person  
{  
}  
echo gettype(new Person);</span>  
Mais para frente terá mais falando sobre orientado a objetos.

#### <span style="color: #98FB98">Nulo</span>

Simplesmente a ausência de algum dado.

#### <span style="color: #98FB98">Voltando</span>

Todos esses tipos de dados podem ser armazenados em uma variável, e o nome da variável só funciona se começar com \_ ou com letras, qualquer outra coisa não funciona.  
Se por exemplo fizermos  
<span style="color: #FF8C00">$name = 'Nicolas'</span>

<span style="color: #FF8C00">echo $name</span>  
O output será <span style="color: #FF8C00">"Nicolas"</span>  
Quando trabalhamos com nomes compostos, temos dois padrões para separar, e é de pessoa pra pessoa, não tendo um certo ou errado e sim preferências, mas recomenda-se que uma vez que você adote sua própria preferência, mantenha ela.  
Temos o padrão **camelCase** ou o padrão **snake_case**, que só de olhar assim para eles se percebe como cada um funciona. Pessoalmente eu gosto de usar o snake_case.  
Lembrando que o camelCase funciona, pois o PHP é sensível a letras maiúsculas e minuúsculas, então se se colocarmos <span style="color: #ff8c00"> $myname </span> vai ser completamente diferente de <span style="color: #FF8C00"> $myName </span> e serão duas variáveis diferentes.  
Outro tópico muito importante é sobre como são armazenados os dados nas variáveis. Podemos armazenar de uma maneira simples, igualando a variável a alguma coisa, porém se fizermos  
<span style="color: #FF8C00"> $name = 'Nicolas'</span>

<span style="color: #FF8C00"> $my_name = $name</span>

<span style="color: #FF8C00"> $name = 'João'</span>

<span style="color: #FF8C00"> echo $name</span>

<span style="color: #FF8C00"> echo $my_name</span>  
Nós teremos um output desta maneira  
<span style="color: #FF8C00"> João</span>  
<span style="color: #FF8C00"> Nicolas</span>  
Isso acontece pois a variável <span style="color: #FF8C00"> $my_name</span> já registrou seu próprio valor como Nicolas, e depois disso a outra variável se alterou, porém caso mude o código e coloquemos  
<span style="color: #FF8C00"> $my_name = & $name</span> (sem o espaço entre o & e o $) ele não atribuirá apenas o valor, e sim a referência, então se a outra variável mudar igual mudou, ambas ficarão iguais.