import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class GraphPanel extends JPanel {
    private Graph grafo;

    public GraphPanel(Graph grafo) {
        this.grafo = grafo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenha as cidades e arestas
        for (String cidade : grafo.getCidades()) {
            int x = gerarCoordenada();
            int y = gerarCoordenada();

            // Desenha a cidade como uma bola preta
            g.setColor(Color.BLACK);
            g.fillOval(x, y, 20, 20);

          
            //Map<String, Integer> vizinhos = grafo.getVizinhos(cidade);
           // for (Map.Entry<String, Integer> vizinho : vizinhos.entrySet()) {
             //   int xVizinho = gerarCoordenada();
            //    int yVizinho = gerarCoordenada();

                // Desenha a aresta como uma linha preta
            //    g.drawLine(x + 10, y + 10, xVizinho + 10, yVizinho + 10);
           // }
        }
    }

    private int gerarCoordenada() {
        // Gera uma coordenada aleatória no intervalo [0, 500)
        return (int) (Math.random() * 500);
    }
}
