public class TesteEtapa2 {

    public static void main(String[] args) {
        System.out.println("========== TESTE ETAPA 2 — Fila<T> e GestorEmprestimos ==========\n");
        System.out.println(">> Teste da Fila<String>");
        Fila<String> filaTexto = new Fila<>();
        filaTexto.enfileira("A");
        filaTexto.enfileira("B");
        filaTexto.enfileira("C");
        System.out.println("toString: " + filaTexto);
        System.out.println("primeiro(): " + filaTexto.primeiro());
        System.out.println("desenfileira(): " + filaTexto.desenfileira());
        System.out.println("tamanho(): " + filaTexto.tamanho());
        System.out.println("filaVazia(): " + filaTexto.filaVazia());
        filaTexto.desenfileira();
        filaTexto.desenfileira();
        System.out.println("Apos esvaziar -> filaVazia(): " + filaTexto.filaVazia());
        try {
            filaTexto.desenfileira();
        } catch (FilaVaziaException e) {
            System.out.println("FilaVaziaException capturada: " + e.getMessage());
        }
        System.out.println();

        System.out.println(">> Cenario do GestorEmprestimos\n");

        ListaDupla acervo = new ListaDupla();
        Livro livro = new Livro("978-85-430-0067-8", "Estruturas de Dados", "Goodrich", 2013);
        acervo.insereFim(livro);

        Usuario ana = new Usuario(1, "Ana", "ana@email.com");
        Usuario bruno = new Usuario(2, "Bruno", "bruno@email.com");
        Usuario carla = new Usuario(3, "Carla", "carla@email.com");

        GestorEmprestimos gestor = new GestorEmprestimos(acervo);

        System.out.println("--- 1) Emprestimo de livro disponivel ---");
        gestor.solicitarEmprestimo("978-85-430-0067-8", ana);
        System.out.println("Status do livro: " + livro + "\n");
        System.out.println("--- 2) Mesmo livro solicitado por outros usuarios ---");
        gestor.solicitarEmprestimo("978-85-430-0067-8", bruno);
        gestor.solicitarEmprestimo("978-85-430-0067-8", carla);
        gestor.listarFilaDeEspera("978-85-430-0067-8");
        System.out.println();

        System.out.println("--- 3) Devolucao (atendimento automatico) ---");
        gestor.devolverLivro("978-85-430-0067-8");
        gestor.listarFilaDeEspera("978-85-430-0067-8");
        System.out.println("Status do livro: " + livro + "\n");
        System.out.println("--- 4) Segunda devolucao (Carla e atendida) ---");
        gestor.devolverLivro("978-85-430-0067-8");
        gestor.listarFilaDeEspera("978-85-430-0067-8");
        System.out.println("Status do livro: " + livro + "\n");
        System.out.println("--- 5) Devolucao com fila vazia ---");
        gestor.devolverLivro("978-85-430-0067-8");
        System.out.println("Status do livro: " + livro);
    }
}
