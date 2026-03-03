Suite de testes (sem JUnit)

Como os testes foram feitos
- Para evitar dependências (ex.: JUnit), criei testes auto-contidos que usam uma pequena utilidade `Assert`.
- Os testes ficam na pasta `tests/`.
- Cada arquivo `Test*.java` contém comentários explicando o que está sendo verificado e por quê — você pode copiar esses comentários para sua explicação.

Como executar (Windows PowerShell)
1) Compile tudo (gera classes em `out`):

   javac -Xlint:all -d out *.java tests\*.java

2) Execute a suíte de testes:

   java -cp out TestAll

O que cada teste verifica
- TestJogo: getters, setters, toString, equals/hashCode (case-insensitive por título).
- TestTabelaHash: inserir, rejeitar duplicatas, buscar, remover, exportarParaVetor e tamanho.
- TestOrdenacao: valida bubble, insertion e quick comparando o resultado com o critério por título.
- TestBibliotecaJogos: testa a fachada (inserir, buscar, remover e ordenar por campo).

Notas para explicar à professora
- Use os comentários em cada arquivo de teste — eles descrevem a intenção de cada asserção.
- Estes são testes básicos, pensados para validar comportamento funcional clássico; para um curso seria ideal complementar com JUnit e casos de borda adicionais.
