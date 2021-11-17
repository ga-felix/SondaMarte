<h1 align="left">Explorando Marte</h1>
           <article>
            <section>
             <h2 align="left">Problema</h2>
             <p>O problema consiste em explorar Marte. A Nasa fez o envio de uma Sonda que irá pousar num planalto. Através do envio de sinais, é desejável movimentar essa Sonda, usando os quatro pontos cardeais como referência. Com isso em vista, a Elo7 requisitou um programa em Java para atingir esses objetivos. Mais detalhes podem ser encontrados clicando <b><a href="https://gist.github.com/elo7-developer/1a40c96a5d062b69f02c">aqui</a></b>.</p>
            </section>
            <section>
             <h2 align="left">Solução</h2>
             <p>A solução foi escrita usando Java puro. A seguir, uma visão de cada classe / interface:</p>
             <ul>
              <li><b>App.java</b>: é responsável por manter o ponto de entrada do programa.</li>
              <li><b>Vetor2D.java</b>: o problema envolve uma malha de duas dimensões, então seria interessante ter uma classe que encapsula operações com vetores de duas dimensões. Assim nasceu Vetor2D.</li>
              <li><b>Bussola.java</b>: encapsula cálculos de direção. Usando um Map, uma Bussola consegue dizer qual é a direção que um Explorador está olhando toda vez que ele gira 90 graus para à direita ou esquerda.</li>
              <li><b>Explorador.java</b>: classes que implementarem essa interface serão capazes de explorar terrenos. Ela existe para garantir que, caso humanos sejam enviados à Marte, criar um Explorador humano seja uma tarefa tranquila.</li>
              <li><b>Terreno.java</b>: classes que implementarem essa interface serão terrenos exploráveis por exploradores. Qualquer terreno é explorável por um Explorador.</li>
              <li><b>Sonda.java</b>: classes que implementarem essa interface serão capazes de explorar terrenos. Ela existe para garantir que, caso humanos sejam enviados à Marte, criar um Explorador humano seja uma tarefa tranquila.</li>
             </ul>
            </section>
           </article>
