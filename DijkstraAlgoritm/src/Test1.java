
// Test de la classe Graph
public class Test1 {
	public static void main(String[] args) throws Exception {
		System.out.println("Teste 1 : teste da classe Graph");
		
		Graph g;

		// petit graphe
		g = new Graph("C:\\Users\\Higor Felype\\Google Drive\\ECT\\2017.2\\Estrutura de Dados\\Unid. 3\\Projeto II\\pratica9a\\Projeto\\mini.gr");
		System.out.println(g);

		// gros graphe
		g = new Graph("C:\\Users\\Higor Felype\\Google Drive\\ECT\\2017.2\\Estrutura de Dados\\Unid. 3\\Projeto II\\pratica9a\\Projeto\\USA-road-d-NY.gr");
		g.setCoordinates("C:\\Users\\Higor Felype\\Google Drive\\ECT\\2017.2\\Estrutura de Dados\\Unid. 3\\Projeto II\\pratica9a\\Projeto\\USA-road-d-NY.co");
		Fenetre f;
		f = new Fenetre("C:\\Users\\Higor Felype\\Google Drive\\ECT\\2017.2\\Estrutura de Dados\\Unid. 3\\Projeto II\\pratica9a\\Projeto\\NY_Metropolitan.png", "Dijkstra", -73.9987, -73.9437, 40.7523, 40.78085);
		g.drawGraph(f);
	}
}
