public class Catalogo {

    private NossoHash<String, Livro> indice;
    private int quantidade;

    public Catalogo() {
        this.indice = new NossoHash<>();
        this.quantidade = 0;
    }


    public void cadastrar(Livro livro) {
        indice.put(livro.getIsbn(), livro);
        quantidade++;
    }


    public Livro buscar(String isbn) {
        return indice.get(isbn);
    }
    public boolean existe(String isbn) {
        return indice.containsKey(isbn);
    }

    public void exibirCatalogo() {
        System.out.println("===== CATALOGO (" + quantidade + " livro(s)) =====");
        indice.exibeMap();
    }
}
