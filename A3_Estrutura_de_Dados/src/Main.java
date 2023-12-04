//import javax.swing.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Responsável pela leitura do arquivo e validá-lo
        
    	Graph grafo = new Graph();
        try {
            File arquivo = new File("C:/temp/ws-eclipse/A3_Estrutura_de_Dados/distancias.txt");
            Scanner scannerArquivo = new Scanner(arquivo);

            while (scannerArquivo.hasNextLine()) {
                String linha = scannerArquivo.nextLine();
                String[] partes = linha.split(";");

                if (partes.length == 3) {
                    String origem = partes[0];
                    String destino = partes[1];
                    int distancia = Integer.parseInt(partes[2]);

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

        
        /* SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Interface Gráfica");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            GraphPanel graphPanel = new GraphPanel(grafo);
            frame.getContentPane().add(graphPanel);

            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }); */

        //Opções pro usuário selecionar
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1) Calcular a distância entre dois pontos (Dijkstra)");
            System.out.println("2) Criar uma Pilha e listar");
            System.out.println("3) Criar uma Fila e listar");
            System.out.println("4) Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    System.out.println("Informe o ponto de origem:");
                    String origem = scanner.nextLine();
                    System.out.println("Informe o ponto de destino:");
                    String destino = scanner.nextLine();

                    AlgoritmoDijkstra dijkstra = new AlgoritmoDijkstra();
                    Map<String, Integer> menoresCaminhos = dijkstra.encontrarMenorCaminho(grafo, origem);

                    System.out.println(
                            "Distância de " + origem + " para " + destino + ": " + menoresCaminhos.get(destino)+"km");
                    break;
                case 2:
                    lerPilha();
                    break;
                case 3:
                    lerFila();
                    break;
                case 4:
                    System.out.println("Saindo do programa. Até logo!");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    scanner.close();          
            }
        }       
    }

    private static void lerPilha() {
        System.out.println("Lendo a Pilha:");
        Pilha pilha = new Pilha(40);

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/temp/ws-eclipse/A3_Estrutura_de_Dados/distancias.txt"));

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                String origem = partes[0];
                String destino = partes[1];
                int distancia = Integer.parseInt(partes[2]);

                pilha.push(origem + " para " + destino + ": " + distancia + " km");
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!pilha.isEmpty()) {
            System.out.println(pilha.pop());
        }
    }

    private static void lerFila() {
        System.out.println("Lendo a Fila:");
        Fila fila = new Fila(40);

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/temp/ws-eclipse/A3_Estrutura_de_Dados/distancias.txt"));

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                String origem = partes[0];
                String destino = partes[1];
                int distancia = Integer.parseInt(partes[2]);

                fila.enqueue(origem + " para " + destino + ": " + distancia + " km");
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!fila.isEmpty()) {
            System.out.println(fila.dequeue());
        }
    }

}
