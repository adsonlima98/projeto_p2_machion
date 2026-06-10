import java.util.Scanner;


public class BibliotecaDigital {

    private ListaDupla acervo;
    private Catalogo catalogo;
    private GestorEmprestimos gestor;

    public BibliotecaDigital() {
        this.acervo = new ListaDupla();
        this.catalogo = new Catalogo();
        this.gestor = new GestorEmprestimos(acervo);
    }


    public void cadastrarLivro(Livro livro) {
        if (catalogo.existe(livro.getIsbn())) {
            System.out.println("Ja existe um livro cadastrado com o ISBN " + livro.getIsbn() + ".");
            return;
        }
        acervo.insereFim(livro);
        catalogo.cadastrar(livro);
        System.out.println("Livro cadastrado com sucesso: " + livro);
    }

    public void buscarLivro(String isbn) {
        Livro livro = catalogo.buscar(isbn);
        if (livro != null) {
            System.out.println("Encontrado: " + livro);
        } else {
            System.out.println("Nenhum livro encontrado com o ISBN " + isbn + ".");
        }
    }

    public void listarDoInicio() {
        acervo.listarDoInicio();
    }

    public void listarDoFim() {
        acervo.listarDoFim();
    }

    public void solicitarEmprestimo(String isbn, Usuario usuario) {
        gestor.solicitarEmprestimo(isbn, usuario);
    }

    public void devolverLivro(String isbn) {
        gestor.devolverLivro(isbn);
    }

    public void verFilaDeEspera(String isbn) {
        gestor.listarFilaDeEspera(isbn);
    }

    public static void main(String[] args) {
        BibliotecaDigital biblioteca = new BibliotecaDigital();
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();
            try {
                opcao = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida. Digite um numero.");
                continue;
            }

            System.out.println();
            switch (opcao) {
                case 1:
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine().trim();
                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine().trim();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine().trim();
                    System.out.print("Ano de publicacao: ");
                    int ano;
                    try {
                        ano = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Ano invalido. Cadastro cancelado.");
                        break;
                    }
                    biblioteca.cadastrarLivro(new Livro(isbn, titulo, autor, ano));
                    break;

                case 2: 
                    System.out.print("ISBN para busca: ");
                    biblioteca.buscarLivro(sc.nextLine().trim());
                    break;

                case 3: 
                    biblioteca.listarDoInicio();
                    break;

                case 4: 
                    biblioteca.listarDoFim();
                    break;

                case 5: 
                    System.out.print("Matricula do usuario: ");
                    int matricula;
                    try {
                        matricula = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Matricula invalida.");
                        break;
                    }
                    System.out.print("Nome do usuario: ");
                    String nome = sc.nextLine().trim();
                    System.out.print("Email do usuario: ");
                    String email = sc.nextLine().trim();
                    System.out.print("ISBN do livro: ");
                    String isbnEmp = sc.nextLine().trim();
                    biblioteca.solicitarEmprestimo(isbnEmp, new Usuario(matricula, nome, email));
                    break;

                case 6: 
                    System.out.print("ISBN do livro a devolver: ");
                    biblioteca.devolverLivro(sc.nextLine().trim());
                    break;

                case 7: 
                    System.out.print("ISBN do livro: ");
                    biblioteca.verFilaDeEspera(sc.nextLine().trim());
                    break;

                case 0:
                    System.out.println("Encerrando a Biblioteca Digital. Ate logo!");
                    break;

                default:
                    System.out.println("Opcao inexistente. Tente novamente.");
            }
            System.out.println();
        }

        sc.close();
    }

    private static void exibirMenu() {
        System.out.println("========== BIBLIOTECA DIGITAL ==========");
        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Buscar livro por ISBN");
        System.out.println("3 - Listar acervo do inicio ao fim");
        System.out.println("4 - Listar acervo do fim ao inicio");
        System.out.println("5 - Solicitar emprestimo (usuario + ISBN)");
        System.out.println("6 - Devolver livro (ISBN)");
        System.out.println("7 - Ver fila de espera de um livro");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opcao: ");
    }
}
