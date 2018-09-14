import java.util.ArrayList;
import java.util.PriorityQueue;

// Algoritmo de Dijkstra
public class Dijkstra {
        PriorityQueue<Node> naoacomodados;
	final Graph g; 
	final int n;  // number of nodes
	final int source; 
	final int dest; 
        int[] dist;
        int[] pred;
        boolean[] settled; 
	Fenetre f; // graphcs interface

	// construtor
	Dijkstra(Graph g, int source, int   dest) {
		this.g = g; // grafo
		n = g.n;
		this.source = source; // índice do nó de partida
		this.dest = dest; // índice do nó de destino
                
                this.dist = new int[this.n]; // vetor de distncias do nó de partida até o nó da posição inó de partida até o nó da posição i
                this.pred = new int[this.n]; // vetor dos predecessores de cada nó
                this.settled = new boolean[this.n];
                
                for(int i=0 ; i<this.n; i++){
                    this.settled[i] = false; // inicia todos os nós como não acomodados
		    // inicia dodos os predecessores com '-1', exceto o predecessor do ponto de partida (source)
                    if(i != this.source) this.pred[i] = -1;
		    // inicia dodas as distâncias com o valor "infinito", exceto a distância do ponto de partida (source)
                    if(i != this.source) this.dist[i] = Integer.MAX_VALUE;
                }
                
                this.dist[this.source] = 0; // distância do ponto de partida ao próprio ponto de partida
                this.pred[this.source] = this.source; // inicia como predecessor do ponto de partida como sendo ele mesmo
                
		// nós que ainda não estão totalmente atualizados (com valores válidos de dist[i] e pred[i])
                this.naoacomodados = new PriorityQueue<>(); 
	}
	
	// atualizacao da distancia, da lista de prioridade, e do predecessor de um no
	void update(int y, int x) {
	    // verifica qual a menor distância do nó 'x' ao nó 'y' e atualiza a distância da posição 'y'
            if(this.dist[y] > this.dist[x] + this.g.value(x, y)){  
                this.dist[y] = this.dist[x] + this.g.value(x, y);
                this.pred[y] = x;
                this.naoacomodados.add(new Node(y, this.dist[y])); // adiciona o nó a fila de não acomodados
                this.g.drawUnsettledPoint(this.f,y); // ------- Desconsidere (só para fins de exibição)
            }
	}
	
	// retorna o próximo nó a ser acomodado na lista de 'setted'
	int nextNode() {
            Node aux;
		// varre a Fila (naoacomodados) de elementos até encontrar
		// um nó não acomodado ou até que a Fila fique vazia
            while(!this.naoacomodados.isEmpty()){
                aux = this.naoacomodados.poll(); // retira o elemento prioritário da 'fila' e o armazena em 'aux'
                if(!this.settled[aux.id])
                    return aux.id; // retorna o índice do primeiro nó encontrado (não acomodado)
            }
            return -1; // esse valor indica o fim do programa
        }
	
	// pega o índice do nó a ser acomodado e adiciona todos os nós ligados ao mesmo à 
	// fila 'naoacomodados'
	int oneStep() {
            this.slow();// ------- Desconsidere (só para fins de exibição)
            int i = this.nextNode(); // índice do nó a ser acomodado, caso o retorno não seja -1
            if(i != -1){ 
		// Grafo.successors(int): retorna a lista de posições dos
		// nós ligados ao nó da posição 'i'
                ArrayList<Integer> sucessores = this.g.successors(i);
		
                this.settled[i] = true; // acomoda o nó 'i'
                this.g.drawSettledPoint(this.f,i);// ------- Desconsidere (só para fins de exibição)
                for(int k=0; k<sucessores.size(); k++) // adiciona a lista de successores de 'i' na fila 'naoacomodados'
                   this.update(sucessores.get(k), i);
            }
            return i;
        }
	
	// computa a parte principal do algoritmo de Dijsktra
	int compute() {
            this.naoacomodados.add(new Node(this.source, 0)); // adiciona o primeiro nó na fila 'naoacomodados'
            int i = -2; // define i = -2 para entrar no laço abaixo
            
	    // roda enquanto não acomodarmos o nó de destino 
            while(!this.settled[this.dest] && i != -1){
                i = this.oneStep();
            }
            
	    // se o programa não acusou erro, retorna-se a distância mínima
	    // entre o nó 'source' (pondo de partida) e o nó 'dest' (destino)
            if(i == this.dest) 
                return this.dist[i]; // resultado !!
            return -1;
	}
	
	// desacelera o visualizador
	void slow(){
	    if(f == null) return;
	    try {
	        Thread.sleep(5);
	    } catch (InterruptedException e) {}
	}
}
