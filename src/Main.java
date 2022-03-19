import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        List<Cliente> clientes = new ArrayList<>();
        List<Livro> livros = new ArrayList<>();
        List<Aluguel> alugueis = new ArrayList<>();
        Biblioteca biblioteca = new Biblioteca(clientes, livros, alugueis);
        menu(biblioteca);


    }

    public static void menu(Biblioteca biblioteca) throws ParseException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--- Menu Principal ---");
            System.out.println("(1)Cadastrar/Remover\n(2)Alugar/Devolver\n(3)Relatório de Aluguéis\n(4)Sair");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    menuCasdatro(biblioteca);
                    break;
                case 2:
                    menuAluguel(biblioteca);
                    break;
                case 3:
                    EntradaDados.lerDadosRelatorio(biblioteca);
                    break;
                default:
                    return;
            }
        }
    }

    public static void menuCasdatro(Biblioteca biblioteca) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---Menu Cadastro ---");
            System.out.println("(1)Cadastrar Cliente\n(2)Remover Cliente\n(3)Cadastrar Livro\n(4)Remover Livro\n(5)voltar");
            int op = sc.nextInt();


            switch (op) {
                case 1:
                    EntradaDados.lerDadosCliente(biblioteca);
                    break;
                case 2:
                    EntradaDados.lerDadosRemoveCliente(biblioteca);
                    break;
                case 3:
                    EntradaDados.lerDadosLivro(biblioteca);
                    break;
                case 4:
                    EntradaDados.lerDadosRemoveLivro(biblioteca);
                    break;
                default:
                    return;
            }
        }
    }

    public static void menuAluguel(Biblioteca biblioteca) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--- Menu Aluguel ---");
            System.out.println("(1)Alugar livro\n(2)Devolver Livro\n(3)Voltar");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    EntradaDados.lerDadosAluguel(biblioteca);
                    break;
                case 2:
                    EntradaDados.lerDadosDevolucao(biblioteca);
                    break;
                default:
                    return;
            }
        }
    }


}
