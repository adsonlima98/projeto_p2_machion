public class TesteEtapa1 {

    public static void main(String[] args) {
        System.out.println("========== TESTE ETAPA 1 — ListaDupla ==========\n");

        ListaDupla acervo = new ListaDupla();

        Livro l1 = new Livro("978-85-430-0067-8", "Estruturas de Dados", "Goodrich", 2013);
        Livro l2 = new Livro("978-85-352-0123-4", "Algoritmos", "Cormen", 2012);
        Livro l3 = new Livro("978-85-7522-456-7", "Java Como Programar", "Deitel", 2017);
        Livro l4 = new Livro("978-85-0000-111-2", "Logica de Programacao", "Forbellone", 2005);

        System.out.println(">> insereFim(l1), insereFim(l2), insereInicio(l3), insereInicio(l4)");
        acervo.insereFim(l1);
        acervo.insereFim(l2);
        acervo.insereInicio(l3);
        acervo.insereInicio(l4);
        System.out.println("Tamanho da lista: " + acervo.tamanho() + "\n");

        acervo.listarDoInicio();
        System.out.println();
        acervo.listarDoFim();
        System.out.println();
        System.out.println(">> buscarPorIsbn(\"978-85-352-0123-4\")");
        Livro achado = acervo.buscarPorIsbn("978-85-352-0123-4");
        System.out.println("Encontrado: " + achado);

        System.out.println(">> buscarPorIsbn(\"000-00-000-0000-0\") (inexistente)");
        Livro naoAchado = acervo.buscarPorIsbn("000-00-000-0000-0");
        System.out.println("Resultado: " + naoAchado + "\n");

        Livro copia = new Livro("978-85-430-0067-8", "Outro titulo", "Outro autor", 2020);
        System.out.println(">> l1.equals(copia com mesmo ISBN)? " + l1.equals(copia) + "\n");

        System.out.println(">> removePrimeiro(): " + acervo.removePrimeiro());
        System.out.println(">> removeUltimo():   " + acervo.removeUltimo());
        System.out.println("Tamanho apos remocoes: " + acervo.tamanho() + "\n");

        acervo.listarDoInicio();
        System.out.println();
        acervo.listarDoFim();
        System.out.println();

        acervo.removePrimeiro();
        acervo.removePrimeiro();
        System.out.println(">> removePrimeiro() em lista vazia: " + acervo.removePrimeiro());
        System.out.println(">> removeUltimo() em lista vazia:   " + acervo.removeUltimo());
        System.out.println("Tamanho final: " + acervo.tamanho());
        acervo.listarDoInicio();

        System.out.println("\n>> Teste da classe Usuario");
        Usuario u1 = new Usuario(1001, "Adson Lima", "adson@email.com");
        Usuario u2 = new Usuario(1001, "Outro Nome", "outro@email.com");
        System.out.println(u1);
        u1.setEmail("novo@email.com");
        System.out.println("Apos setEmail: " + u1);
        System.out.println("u1.equals(u2) (mesma matricula)? " + u1.equals(u2));
    }
}
