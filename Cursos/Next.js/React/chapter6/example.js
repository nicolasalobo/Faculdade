// Você pode pensar nas chaves { } como uma forma de entrar no "mundo JavaScript" enquanto estiver no "mundo JSX". Você pode adicionar qualquer expressão JavaScript (algo que seja avaliado para um único valor) dentro das chaves.

// A propriedade de um objeto com notação de ponto:

function Header(props) {
    return <h1>{props.title}</h1>;
}

// Um template literal:

function Header({ title }) {
  return <h1>{`Cool ${title}`}</h1>;
}

// O valor retornado de uma função:

function createTitle(title) {
  if (title) {
    return title;
  } else {
    return 'Default title';
  }
}
 
function Header({ title }) {
  return <h1>{createTitle(title)}</h1>;
}

// Ou operadores ternários:

function Header({ title }) {
  return <h1>{title ? title : 'Default title'}</h1>;
}

// Você agora pode passar qualquer string para sua prop title ou, se você usou o operador ternário, pode até não passar uma prop title, já que você considerou o caso padrão em seu componente:

function Header({ title }) {
  return <h1>{title ? title : 'Default title'}</h1>;
}
 
function HomePage() {
  return (
    <div>
      <Header />
    </div>
  );
}

// Seu componente agora aceita uma prop title genérica que você pode reutilizar em diferentes partes do seu aplicativo. Tudo o que você precisa fazer é mudar a string do título:

function HomePage() {
  return (
    <div>
      <Header title="React" />
      <Header title="A new title" />
    </div>
  );
}

// Iterando por listas
// É comum ter dados que você precisa mostrar como uma lista. Você pode usar métodos de array para manipular seus dados e gerar elementos de UI que são idênticos em estilo, mas contêm diferentes pedaços de informação.
// Adicione o seguinte array de nomes ao seu componente HomePage:

function HomePage() {
  const names = ['Ada Lovelace', 'Grace Hopper', 'Margaret Hamilton'];
 
  return (
    <div>
      <Header title="Develop. Preview. Ship." />
      <ul>
        {names.map((name) => (
          <li>{name}</li>
        ))}
      </ul>
    </div>
  );
}

// Ou algo muito utilizado é o map.
// Você pode então usar o método array.map() para iterar sobre o array e usar uma função arrow para mapear um nome para um item de lista:

function HomePage() {
  const names = ['Ada Lovelace', 'Grace Hopper', 'Margaret Hamilton'];
 
  return (
    <div>
      <Header title="Develop. Preview. Ship." />
      <ul>
        {names.map((name) => (
          <li>{name}</li>
        ))}
      </ul>
    </div>
  );
}

// Note como você usou chaves para entrar e sair do "mundo JavaScript" e "mundo JSX".
// Se você executar este código, o React nos dará um aviso sobre uma prop key ausente. Isso ocorre porque o React precisa de algo para identificar exclusivamente os itens em um array, para saber quais elementos atualizar no DOM.
// Você pode usar os nomes por enquanto, já que eles são atualmente únicos, mas é recomendado usar algo garantidamente único, como um ID de item.

function HomePage() {
  const names = ['Ada Lovelace', 'Grace Hopper', 'Margaret Hamilton'];
 
  return (
    <div>
      <Header title="Develop. Preview. Ship." />
      <ul>
        {names.map((name) => (
          <li key={name}>{name}</li>
        ))}
      </ul>
    </div>
  );
}