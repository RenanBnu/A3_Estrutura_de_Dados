import java.util.*;

public class AlgoritmoDijkstra{
    public Map<String, Integer> encontrarMenorCaminho(Graph grafo, String verticeInicial) {
        Map<String, Integer> distancia = new HashMap<>();
        Set<String> visitados = new HashSet<>();
        PriorityQueue<String> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(distancia::get));

        // define a distancia inicial do vértice
        distancia.put(verticeInicial, 0);
        filaPrioridade.offer(verticeInicial);

        // Algoritmo de Dijkstra
        while (!filaPrioridade.isEmpty()) {
            String verticeAtual = filaPrioridade.poll();

            if (visitados.contains(verticeAtual)) {
                continue;
            }

            visitados.add(verticeAtual);

            for (Map<String, Integer> vizinhosMap : grafo.getVizinhos(verticeAtual)) {
            	
            	for (Map.Entry<String, Integer> vizinho : vizinhosMap.entrySet()) {
	                String vizinhoNome = vizinho.getKey();
	                int pesoAresta = vizinho.getValue();
	                int novaDistancia = distancia.get(verticeAtual) + pesoAresta;
	
	                if (novaDistancia < distancia.getOrDefault(vizinhoNome, Integer.MAX_VALUE)) {
	                    distancia.put(vizinhoNome, novaDistancia);
	                    filaPrioridade.offer(vizinhoNome);
	                }
            	}
            }
        }

        return distancia;
    }
}
