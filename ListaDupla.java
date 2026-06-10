
public class ListaDupla {

    private NoDuplo primeiro;
    private NoDuplo ultimo;
    private int tamanho;

    public ListaDupla() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    
    public void insereInicio(Livro livro) {
        NoDuplo novo = new NoDuplo(livro);
        if (primeiro == null) {          
            primeiro = novo;
            ultimo = novo;
        } else {
            novo.setProximo(primeiro);
            primeiro.setAnterior(novo);
            primeiro = novo;
        }
        tamanho++;
    }

   
    public void insereFim(Livro livro) {
        NoDuplo novo = new NoDuplo(livro);
        if (ultimo == null) {             
            primeiro = novo;
            ultimo = novo;
        } else {
            novo.setAnterior(ultimo);
            ultimo.setProximo(novo);
            ultimo = novo;
        }
        tamanho++;
    }

    
    public Livro removePrimeiro() {
        if (primeiro == null) {
            return null;
        }
        Livro removido = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        if (primeiro == null) {          
            ultimo = null;
        } else {
            primeiro.setAnterior(null);
        }
        tamanho--;
        return removido;
    }

   
    public Livro removeUltimo() {
        if (ultimo == null) {
            return null;
        }
        Livro removido = ultimo.getInfo();
        ultimo = ultimo.getAnterior();
        if (ultimo == null) {             
            primeiro = null;
        } else {
            ultimo.setProximo(null);
        }
        tamanho--;
        return removido;
    }

    
    public Livro buscarPorIsbn(String isbn) {
        NoDuplo atual = primeiro;
        while (atual != null) {
            if (atual.getInfo().getIsbn().equals(isbn)) {
                return atual.getInfo();
            }
            atual = atual.getProximo();
        }
        return null;
    }

    
    public void listarDoInicio() {
        System.out.println("--- Acervo (inicio -> fim) ---");
        if (primeiro == null) {
            System.out.println("(lista vazia)");
            return;
        }
        NoDuplo atual = primeiro;
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getProximo();
        }
    }

   
    public void listarDoFim() {
        System.out.println("--- Acervo (fim -> inicio) ---");
        if (ultimo == null) {
            System.out.println("(lista vazia)");
            return;
        }
        NoDuplo atual = ultimo;
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getAnterior();
        }
    }


    public int tamanho() {
        return tamanho;
    }
}
