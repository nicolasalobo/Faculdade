// Adicionando interatividade com estado
// Vamos explorar como o React nos ajuda a adicionar interatividade com estado e manipuladores de eventos.
// Como exemplo, vamos criar um botão "Curtir" dentro do seu componente HomePage. Primeiro, adicione um elemento de botão dentro da declaração return():

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
      <button>Like</button>
    </div>
  );
}

//

// Ouvindo eventos
// Para fazer o botão fazer algo quando clicado, você pode usar o evento onClick:
function HomePage() {
  // ...
  return (
    <div>
      {/* ... */}
      <button onClick={}>Like</button>
    </div>
  );
}
// Em React, os nomes dos eventos são em camelCase. O evento onClick é um dos muitos eventos possíveis que você pode usar para responder à interação do usuário. Por exemplo, você pode usar onChange para campos de entrada ou onSubmit para formulários.

//

// Lidando com eventos
// Você pode definir uma função para "lidar" com eventos quando forem disparados. Vamos criar uma função antes do retorno do statement chamado handleClick():
function HomePage() {
  // ...
 
  function handleClick() {
    console.log("increment like count")
  }
 
  return (
    <div>
      {/* ... */}
	  <button onClick={}>Like</button>
    </div>
     )
   }
   // Então, você pode chamar a função handleClick quando o evento onClick for disparado:
function HomePage() {
  // 	...
  function handleClick() {
    console.log('increment like count');
  }
 
  return (
    <div>
      {/* ... */}
      <button onClick={handleClick}>Like</button>
    </div>
  );
}
// Tente executar isso em seu navegador. Observe nas ferramentas de desenvolvedor como a saída do log aumenta.

//State e os hooks
// React tem funções chamadas hooks. Hooks permitem que você adicione lógica adicional, como estado, aos seus componentes. Você pode pensar em estado como qualquer informação na sua UI que muda ao longo do tempo, geralmente acionada pela interação do usuário.
// Você pode usar o estado para armazenar e incrementar o número de vezes que um usuário clicou no botão "Curtir". Na verdade, o hook do React usado para gerenciar o estado é chamado: useState()
// Adicione useState() ao seu projeto. Ele retorna um array, e você pode acessar e usar esses valores de array dentro do seu componente usando desestruturação de array:
function HomePage() {
  // ...
  const [] = React.useState();
 
  // ...
}
// O primeiro item no array é o valor do estado, que você pode nomear como quiser. É recomendado nomeá-lo de forma descritiva:
function HomePage() {
  // ...
  const [likes] = React.useState();
 
  // ...
}
// O segundo item no array é uma função que você pode chamar para atualizar o valor do estado. Novamente, você pode nomeá-lo como quiser, mas é comum nomeá-lo como set seguido pelo nome do valor do estado:
function HomePage() {
  // ...
  const [likes, setLikes] = React.useState();
 
  // ...
}
// Você também pode aproveitar a oportunidade para adicionar o valor inicial do seu estado likes como 0:
function HomePage() {
  // ...
  const [likes, setLikes] = React.useState(0);
 
  // ...
}
// Em seguida, você pode verificar se o estado inicial está funcionando usando a variável de estado dentro do seu componente.
function HomePage() {
  // ...
  const [likes, setLikes] = React.useState(0);
  // ...
 
  return (
    // ...
    <button onClick={handleClick}>Like({likes})</button>
  );
}
// Finalmente, você pode chamar sua função atualizadora de estado, setLikes, dentro do seu componente HomePage, vamos adicioná-la dentro da função handleClick() que você definiu anteriormente:
function HomePage() {
  // ...
  const [likes, setLikes] = React.useState(0);
 
  function handleClick() {
    setLikes(likes + 1);
  }
 
  return (
    <div>
      {/* ... */}
      <button onClick={handleClick}>Likes ({likes})</button>
    </div>
  );
}
// Clicar no botão agora chamará a função handleClick, que chama a função atualizadora de estado setLikes com um único argumento do número atual de curtidas + 1.

// Manuseando estado
// Isso foi apenas uma introdução ao estado, e há mais que você pode aprender sobre o gerenciamento de estado e fluxo de dados em suas aplicações React. Para saber mais, recomendamos que você passe pelas seções Adicionando Interatividade e Gerenciando Estado na documentação do React.