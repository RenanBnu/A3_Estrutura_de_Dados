class Fila {
    private String[] elementos;
    private int tamanho;
    private int inicio;
    private int fim;

    public Fila(int capacidade) {
        elementos = new String[capacidade];
        tamanho = 0;
        inicio = 0;
        fim = -1;
    }

    public void enqueue(String elemento) {
        if (tamanho < elementos.length) {
            fim = (fim + 1) % elementos.length;
            elementos[fim] = elemento;
            tamanho++;
        } else {
            System.out.println("Fila cheia");
        }
    }

    public String dequeue() {
        if (tamanho > 0) {
            String elemento = elementos[inicio];
            inicio = (inicio + 1) % elementos.length;
            tamanho--;
            return elemento;
        } else {
            System.out.println("Fila vazia");
            return null;
        }
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}