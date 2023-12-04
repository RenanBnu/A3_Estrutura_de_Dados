class Pilha {
    private String[] elementos;
    private int topo;

    public Pilha(int capacidade) {
        elementos = new String[capacidade];
        topo = -1;
    }

    
    public void push(String elemento) {
        if (topo < elementos.length - 1) {
            topo++;
            elementos[topo] = elemento;
        } else {
            System.out.println("Pilha cheia");
        }
    }

    public String pop() {
        if (topo >= 0) {
            String elemento = elementos[topo];
            topo--;
            return elemento;
        } else {
            System.out.println("Pilha vazia");
            return null;
        }
    }

    public boolean isEmpty() {
        return topo == -1;
    }
}
