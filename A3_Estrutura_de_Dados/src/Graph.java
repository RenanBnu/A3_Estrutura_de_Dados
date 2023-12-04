import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<String, List<Map<String, Integer>>> listaAdjacencia;

    public Graph() {
        this.listaAdjacencia = new HashMap<>();
    }

    public void addCidade(String cidade) {
    	if (!listaAdjacencia.containsKey(cidade))
    		listaAdjacencia.put(cidade, new ArrayList<Map<String, Integer>>());
    }

    public void addAresta(String origem, String destino, int distancia) {
        addCidade(origem);  // Garante que as cidades estão registradas
        addCidade(destino);
        
        HashMap<String, Integer> caminho = new HashMap<String, Integer>();
        
        caminho.put(destino, distancia);
        
        listaAdjacencia.get(origem).add(caminho);
        
        HashMap<String, Integer> caminhoInverso = new HashMap<String, Integer>();

        caminhoInverso.put(origem, distancia);
        
        listaAdjacencia.get(destino).add(caminhoInverso);
    }

    public List<Map<String, Integer>> getVizinhos(String vertice) {
        return listaAdjacencia.getOrDefault(vertice, new ArrayList<>());
    }

    public Iterable<String> getCidades() {
        return listaAdjacencia.keySet();
    }
}
