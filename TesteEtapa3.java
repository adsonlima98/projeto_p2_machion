public class TesteEtapa3 {

    public static void main(String[] args) {
        System.out.println("========== TESTE ETAPA 3 — NossoHash e Catalogo ==========\n");

        System.out.println(">> NossoHash<String, Integer>");
        NossoHash<String, Integer> mapa = new NossoHash<>();
        mapa.put("um", 1);
        mapa.put("dois", 2);
        mapa.put("tres", 3);
        mapa.put("quatro", 4);

        System.out.println("get(\"dois\"): " + mapa.get("dois"));
        System.out.println("get(\"cinco\") (inexistente): " + mapa.get("cinco"));
        System.out.println("containsKey(\"tres\"): " + mapa.containsKey("tres"));
        System.out.println("containsKey(\"dez\"): " + mapa.containsKey("dez"));
        System.out.println("containsValue(4): " + mapa.containsValue(4));
        System.out.println("containsValue(99): " + mapa.containsValue(99));
        System.out.println();
        mapa.exibeMap();
        System.out.println();

        System.out.println(">> put(\"um\", 100) — chave repetida fica a frente");
        mapa.put("um", 100);
        System.out.println("get(\"um\") agora retorna: " + mapa.get("um"));
        System.out.println();
        System.out.println(">> Catalogo (NossoHash<String, Livro>)");
        Catalogo catalogo = new Catalogo();
        catalogo.cadastrar(new Livro("978-85-430-0067-8", "Estruturas de Dados", "Goodrich", 2013));
        catalogo.cadastrar(new Livro("978-85-352-0123-4", "Algoritmos", "Cormen", 2012));
        catalogo.cadastrar(new Livro("978-85-7522-456-7", "Java Como Programar", "Deitel", 2017));

        System.out.println("buscar(\"978-85-352-0123-4\"): " + catalogo.buscar("978-85-352-0123-4"));
        System.out.println("existe(\"978-85-7522-456-7\"): " + catalogo.existe("978-85-7522-456-7"));
        System.out.println("existe(\"000-00-000-0000-0\"): " + catalogo.existe("000-00-000-0000-0"));
        System.out.println();
        catalogo.exibirCatalogo();
    }
}
