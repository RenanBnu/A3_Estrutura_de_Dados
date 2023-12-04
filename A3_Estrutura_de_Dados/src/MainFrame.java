import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MainFrame {
    private static GraphPanel graphPanel;
    private static Graph grafo;

    public static void main(String[] args) {
        grafo = new Graph();

        // Leitura do arquivo e construção do grafo
        try {
            File arquivo = new File("/Users/Renan/.vscode/Projetos Java/A3_Estrutura_de_Dados/src/distancias.txt");
            Scanner scannerArquivo = new Scanner(arquivo);

            while (scannerArquivo.hasNextLine()) {
                String linha = scannerArquivo.nextLine();
                String[] partes = linha.split(";");

                if (partes.length == 3) {
                    String origem = partes[0];
                    String destino = partes[1];
                    int distancia = Integer.parseInt(partes[2]);

                    // Adiciona as cidades ao grafo
                    grafo.addCidade(origem);
                    grafo.addCidade(destino);

                    // Adiciona as arestas ao grafo
                    grafo.addAresta(origem, destino, distancia);
                } else {
                    System.out.println("Formato inválido na linha: " + linha);
                }
            }

            scannerArquivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: distancias.txt");
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Visualização de Distâncias");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            graphPanel = new GraphPanel(grafo);
            frame.getContentPane().add(graphPanel, BorderLayout.CENTER);
            frame.setSize(800, 600);
            frame.setVisible(true);
        });

       
    }
}
