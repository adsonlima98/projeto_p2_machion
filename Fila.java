public class Fila<T> {

    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho;

    public Fila() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }


    public void enfileira(T info) {
        No<T> novo = new No<>(info);
        if (filaVazia()) {
            primeiro = novo;
        } else {
            ultimo.setProximo(novo);
        }
        ultimo = novo;
        tamanho++;
    }

    
    public T desenfileira() {
        if (filaVazia()) {
            throw new FilaVaziaException();
        }
        T info = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        if (primeiro == null) {
            ultimo = null;
        }
        tamanho--;
        return info;
    }

   
    public T primeiro() {
        if (filaVazia()) {
            throw new FilaVaziaException();
        }
        return primeiro.getInfo();
    }

   
    public boolean filaVazia() {
        return primeiro == null;
    }

   
    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        No<T> atual = primeiro;
        while (atual != null) {
            sb.append("[").append(atual.getInfo()).append("]->");
            atual = atual.getProximo();
        }
        sb.append("\\\\");
        return sb.toString();
    }
}
