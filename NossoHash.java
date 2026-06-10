
public class NossoHash<K, V> {

    private static final int CAPACIDADE_INICIAL = 16;

    private Entrada<K, V>[] tabela;
    private int capacidade;

    @SuppressWarnings("unchecked")
    public NossoHash() {
        this.capacidade = CAPACIDADE_INICIAL;

        this.tabela = (Entrada<K, V>[]) new Entrada[capacidade];
    }

   
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacidade;
    }


    public void put(K key, V value) {
        int pos = hash(key);
        Entrada<K, V> nova = new Entrada<>(key, value);
        nova.proximo = tabela[pos]; 
        tabela[pos] = nova;         
    }


    public V get(K key) {
        int pos = hash(key);
        Entrada<K, V> atual = tabela[pos];
        while (atual != null) {
            if (atual.key.equals(key)) {
                return atual.value;
            }
            atual = atual.proximo;
        }
        return null;
    }

   
    public boolean containsKey(K key) {
        int pos = hash(key);
        Entrada<K, V> atual = tabela[pos];
        while (atual != null) {
            if (atual.key.equals(key)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < capacidade; i++) {
            Entrada<K, V> atual = tabela[i];
            while (atual != null) {
                if (atual.value.equals(value)) {
                    return true;
                }
                atual = atual.proximo;
            }
        }
        return false;
    }

    
    public void exibeMap() {
        System.out.println("--- NossoHash (capacidade " + capacidade + ") ---");
        for (int i = 0; i < capacidade; i++) {
            System.out.print("[" + i + "]: ");
            Entrada<K, V> atual = tabela[i];
            if (atual == null) {
                System.out.println("(vazia)");
            } else {
                StringBuilder sb = new StringBuilder();
                while (atual != null) {
                    sb.append(atual);
                    if (atual.proximo != null) {
                        sb.append(" -> ");
                    }
                    atual = atual.proximo;
                }
                System.out.println(sb);
            }
        }
    }
}
