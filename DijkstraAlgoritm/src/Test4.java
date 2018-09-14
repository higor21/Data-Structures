
// Test de l'algorithme de Dijkstra basique sur un gros graphe
public class Test4 {
    public static void main(String args[]) throws Exception {
            System.out.println("Teste 4 : teste do algoritmo de Dijkstra");

            // preparation de la fenetre
            Graph g=new Graph("C:\\Users\\Higor Felype\\Google Drive\\ECT\\2017.2\\Estrutura de Dados\\Unid. 3\\Projeto II\\pratica9a\\Projeto\\USA-road-d-NY.gr");
            g.setCoordinates("C:\\Users\\Higor Felype\\Google Drive\\ECT\\2017.2\\Estrutura de Dados\\Unid. 3\\Projeto II\\pratica9a\\Projeto\\USA-road-d-NY.co");
            Fenetre f;
            f = new Fenetre("C:\\Users\\Higor Felype\\Google Drive\\ECT\\2017.2\\Estrutura de Dados\\Unid. 3\\Projeto II\\pratica9a\\Projeto\\NY_Metropolitan.png", "Dijkstra", -73.9987, -73.9437, 40.7523, 40.78085);
            g.drawGraph(f);
            f.repaint();

            // algorithme de Dijkstra
            int source = 190637, destination = 187333;
            Dijkstra d = new Dijkstra(g, source, destination);
            d.f = f;
            System.out.println("caminho mais curto entre " + source + " et " + destination + " = " + d.compute());
            g.drawSourceDestination(f, source, destination);
            g.drawPath(f, d.pred, destination);
    }
}
