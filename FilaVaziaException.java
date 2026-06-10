
public class FilaVaziaException extends RuntimeException {

    public FilaVaziaException() {
        super("A fila esta vazia.");
    }

    public FilaVaziaException(String mensagem) {
        super(mensagem);
    }
}
