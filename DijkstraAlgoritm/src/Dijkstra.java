import java.util.ArrayList;
import java.util.PriorityQueue;

// Algoritmo de Dijkstra
public class Dijkstra {
        PriorityQueue<Node> naoacomodados;
	final Graph g; 
	final int n; 
	final int source; 
	final int dest; 
        int[] dist;
        int[] pred;
        boolean[] settled; 
	Fenetre f; 

	// construtor
	Dijkstra(Graph g, int source, int   dest) {
		this.g = g;
		n = g.n;
		this.source = source;
		this.dest = dest;
                
                this.dist = new int[this.n];
                this.pred = new int[this.n];
                this.settled = new boolean[this.n];
                
                for(int i=0 ; i<this.n; i++){
                    this.settled[i] = false;
                    if(i != this.source) this.pred[i] = -1;
                    if(i != this.source) this.dist[i] = Integer.MAX_VALUE;
                }
                
                this.dist[this.source] = 0;
                this.pred[this.source] = this.source;
                
                this.naoacomodados = new PriorityQueue<>();
	}
	
	// atualizacao da distancia, da prioridade, e do predecessor de um no
	void update(int y, int x) {
            if(this.dist[y] > this.dist[x] + this.g.value(x, y)){
                this.dist[y] = this.dist[x] + this.g.value(x, y);
                this.pred[y] = x;
                this.naoacomodados.add(new Node(y, this.dist[y]));
                this.g.drawUnsettledPoint(this.f,y); // ------- LINHA ADD
            }
	}
	
	// retorna o próximo nó a ser acomodado
	int nextNode() { // Pega o primeiro Nó ainda não acomodado
            Node aux;
            while(!this.naoacomodados.isEmpty()){
                aux = this.naoacomodados.poll();
                if(!this.settled[aux.id])
                    return aux.id;
            }
            return -1;
        }
	
	// uma etapa do algoritmo de Dijkstra
	int oneStep() {
            this.slow();// ------- LINHA ADD
            int i = this.nextNode(); // Pega o primeiro Nó ainda não acomodado
            if(i != -1){
                ArrayList<Integer> sucessores = this.g.successors(i);
                this.settled[i] = true;
                this.g.drawSettledPoint(this.f,i);// ------- LINHA ADD
                for(int k=0; k<sucessores.size(); k++)
                   this.update(sucessores.get(k), i);
            }
            return i;
        }
	
	// algoritmo de Dijsktra completo
	int compute() {
            this.naoacomodados.add(new Node(this.source, 0));
            int i = -2;
            
            while(!this.settled[this.dest] && i != -1){
                i = this.oneStep();
            }
            
            if(i == this.dest)
                return this.dist[i];
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
