<h1 align="left">Explorando Marte</h1><hr>
           <article>
            <section>
             <h2 align="left">Problema</h2><hr>
             <p>O problema consiste em explorar Marte. A Nasa fez o envio de uma Sonda que irá pousar num planalto. Através do envio de sinais, é desejável movimentar essa Sonda, usando os quatro pontos cardeais como referência. Com isso em vista, a Elo7 requisitou um programa em Java para atingir esses objetivos. Mais detalhes podem ser encontrados clicando <b><a href="https://gist.github.com/elo7-developer/1a40c96a5d062b69f02c">aqui</a></b>.</p>
            </section>
            <section>
             <h2 align="left">Solução</h2><hr>
             <p>A solução foi escrita usando Java puro. A seguir, uma visão de cada classe / interface:</p>
             <ul>
              <li><b>App.java</b>: é responsável por manter o ponto de entrada do programa.</li>
              <li><b>Vetor2D.java</b>: o problema envolve uma malha de duas dimensões, então seria interessante ter uma classe que encapsula operações com vetores de duas dimensões. Assim nasceu Vetor2D.</li>
              <li><b>Bussola.java</b>: encapsula cálculos de direção. Usando um Map, uma Bussola consegue dizer qual é a direção que um Explorador está olhando toda vez que ele gira 90 graus para à direita ou esquerda.</li>
              <li><b>Explorador.java</b>: classes que implementarem essa interface serão capazes de explorar terrenos. Ela existe para garantir que, caso humanos sejam enviados à Marte, criar um Explorador humano seja uma tarefa tranquila.</li>
              <li><b>Terreno.java</b>: classes que implementarem essa interface serão terrenos exploráveis por exploradores. Qualquer terreno é explorável por um Explorador.</li>
              <li><b>Sonda.java</b>: implementa Explorador e é capaz de movimentar-se, mudar de direção e aterrissar.</li>
              <li><b>Planalto.java</b>: implementa Terreno e fornece métodos para serem utilizados por um Explorador.</li>
              <li><b>Console.java</b>: garante a leitura dos dados na ordem correta e que os dados enviados tem tamanho correto, porém não faz checagem de tipo!</li>
             </ul>
             <p><b>Colisão de sondas</b><br><hr>
             O planalto é, na verdade, uma matriz de duas dimensões que precisa ser percorrida. Várias sondas podem explorar um mesmo planalto, o que pode gerar uma colisão física. Para solucionar esse problema, existe uma estratégia que utiliza uma matriz esparsa para checagem de colisão. Porém, minha solução utilizou um Map, sendo as chaves todas as posições possíveis e valores armazenados variáveis booleanas. Para utilizar o Map junto com a classe Vetor2D, foi necessário fazer o override, em Vetor2D, dos métodos equals e hashCode. Dessa forma, um vetor 2D (1, 2) é equivalente a outro vetor 2D (1, 2), mas não igual a um outro vetor 2D (2, 1). Essa solução foi adotada devido a praticidade que o uso do Map traz em relação à matriz esparsa, porque já existem várias implementações de Map com métodos bons. Os valores booleanos fornecidos pelo Map são usados para verificar se há uma sonda (ou outro obstáculo, é possível) naquela posição.</p>
             <p><b>Aterrissagem</b><br><hr>
             Sondas precisam aterrissar... no lugar certo. Por isso, quando uma Sonda é instanciada, ela recebe coordenadas de aterrissagem. Caso as coordenadas de aterrissagem apontem um lugar obstruído ou fora do terreno desejado, a aterrissagem é abortada e as coordenadas de aterrissagem podem ser alteradas para uma nova tentativa.</p>
             <p><b>Orientação</b><br><hr>
             As sondas possuem bússolas internas que calculam os comandos de giro. Essa solução foi implementada através do uso de um Map duplo. O primeiro Map mapeia a direção atual do Explorador para as possíveis rotações. O segundo Map mapeia o comando de rotação para o novo ponto cardeal correto. Por exemplo, se estou apontando para o norte, então girar 90 graus pode mudar meu ponto cardeal apenas para leste ou oeste, dependendo do sentido de rotação.</p>
            </section>
           <h2 align="left">Conclusão</h2><hr>
           <p>Caso haja dúvidas ou sugestões, entre em contato pelo GitHub. Não sei se essa é a melhor solução possível e mesmo assim sempre há margem para melhorar! O desafio é bem divertido.</p>
           </article>
