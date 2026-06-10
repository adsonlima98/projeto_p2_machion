public class GestorEmprestimos {

  
    private NossoHash<String, Fila<Usuario>> filasDeEspera;

    
    private ListaDupla acervo;

    public GestorEmprestimos(ListaDupla acervo) {
        this.acervo = acervo;
        this.filasDeEspera = new NossoHash<>();
    }

   
    public void solicitarEmprestimo(String isbn, Usuario u) {
        Livro livro = acervo.buscarPorIsbn(isbn);
        if (livro == null) {
            System.out.println("Livro com ISBN " + isbn + " nao encontrado no acervo.");
            return;
        }

        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            System.out.println("Emprestimo registrado: \"" + livro.getTitulo()
                    + "\" para " + u.getNome() + ".");
        } else {
            Fila<Usuario> fila = filasDeEspera.get(isbn);
            if (fila == null) {
                fila = new Fila<>();
                filasDeEspera.put(isbn, fila);
            }
            fila.enfileira(u);
            System.out.println("Livro \"" + livro.getTitulo() + "\" indisponivel. "
                    + u.getNome() + " entrou na fila de espera (posicao "
                    + fila.tamanho() + ").");
        }
    }

   
    public void devolverLivro(String isbn) {
        Livro livro = acervo.buscarPorIsbn(isbn);
        if (livro == null) {
            System.out.println("Livro com ISBN " + isbn + " nao encontrado no acervo.");
            return;
        }

        livro.setDisponivel(true);
        System.out.println("Livro \"" + livro.getTitulo() + "\" devolvido.");

        Fila<Usuario> fila = filasDeEspera.get(isbn);
        if (fila != null && !fila.filaVazia()) {
            Usuario proximo = fila.desenfileira();
            livro.setDisponivel(false);
            System.out.println("Atendimento automatico: \"" + livro.getTitulo()
                    + "\" emprestado para " + proximo.getNome()
                    + " (proximo da fila).");
        } else {
            System.out.println("Nao ha fila de espera. O livro permanece disponivel.");
        }
    }


    public void listarFilaDeEspera(String isbn) {
        Livro livro = acervo.buscarPorIsbn(isbn);
        String titulo = (livro != null) ? livro.getTitulo() : isbn;

        Fila<Usuario> fila = filasDeEspera.get(isbn);
        System.out.println("Fila de espera de \"" + titulo + "\":");
        if (fila == null || fila.filaVazia()) {
            System.out.println("(fila vazia)");
        } else {
            System.out.println(fila);
        }
    }
}
