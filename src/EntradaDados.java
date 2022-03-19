import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EntradaDados {

        public static void lerDadosCliente(Biblioteca biblioteca){
            Scanner sc = new Scanner(System.in);

            System.out.println("---Cadastro Cliente---");
            System.out.println("Nome:");
            String nome = sc.nextLine();
            System.out.println("Cpf:");
            String cpf = sc.nextLine();

            biblioteca.cadastraCliente(nome, cpf);

        }

        public static void lerDadosRemoveCliente(Biblioteca biblioteca){
            Scanner sc = new Scanner(System.in);
            System.out.println("---REMOVER CLIENTE---");
            System.out.println("Cpf:");
            String cpf = sc.nextLine();
            if(biblioteca.buscaCliente(cpf) != -1){
                biblioteca.removeCliente(cpf);
            }else {
                System.out.println("Erro, cliente não existe!");
            }
        }

        public static void lerDadosLivro(Biblioteca biblioteca){
            Scanner sc = new Scanner(System.in);
            System.out.println("---Cadastro Livro---");
            System.out.println("Título:");
            String titulo = sc.nextLine();
            System.out.println("Autor:");
            String autor = sc.nextLine();
            System.out.println("Editora:");
            String editora = sc.nextLine();
            System.out.println("Data de Publicação:");
            String dataPublicacao = sc.nextLine();
            System.out.println("Id:");
            String id = sc.nextLine();

            biblioteca.cadastraLivro(titulo, autor, editora, dataPublicacao, id);
        }

        public static void lerDadosRemoveLivro(Biblioteca biblioteca){
            Scanner sc = new Scanner(System.in);
            System.out.println("---Remover Livro---");
            System.out.println("Id:");
            String id = sc.nextLine();
            biblioteca.removeLivro(id);
        }

        public static void lerDadosAluguel(Biblioteca biblioteca){
            Scanner sc = new Scanner(System.in);
            System.out.println("---Aluguel---");
            System.out.println("Id:");
            String id = sc.nextLine();
            System.out.println("Cpf:");
            String cpf = sc.nextLine();

            for(Cliente c: biblioteca.getClientes()){

            }
            int indiceCliente =biblioteca.buscaCliente(cpf);
            int indiceLivro = biblioteca.buscaLivro(id);

            if(indiceCliente != -1 && indiceLivro != -1){
                Cliente cliente = biblioteca.getClientes().get(indiceCliente);
                Livro livro = biblioteca.getLivros().get(indiceLivro);
                cliente.alugaLivro(biblioteca,livro,cliente);
            }else {
                System.out.println("Erro, dados não encontrados!");
            }

        }

        public static void lerDadosDevolucao(Biblioteca biblioteca){
            Scanner sc = new Scanner(System.in);

            System.out.println("--- Devolver Livro ---");
            System.out.println("Cpf: ");
            String cpf = sc.nextLine();
            System.out.println("Id:");
            String id = sc.nextLine();

            int indiceCliente = biblioteca.buscaCliente(cpf);
            int indiceLivro = biblioteca.buscaLivro(id);

            if(indiceCliente != -1 && indiceLivro != -1){
                Cliente cliente = biblioteca.getClientes().get(indiceCliente);
                Livro livro = biblioteca.getLivros().get(indiceLivro);
                cliente.devolveLivro(biblioteca,livro,cliente);
            }else {
                System.out.println("Erro, dados não encontrados!");
            }


        }

        public static void lerDadosRelatorio(Biblioteca biblioteca) throws ParseException {
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");

            System.out.println("Data min(dd/MM/yyyy):");
            Date dataMin = sfd.parse(sc.nextLine());
            System.out.println("Data max(dd/MM/yyyy):");
            Date dataMax = sfd.parse(sc.nextLine());

            if(dataMax.before(dataMin)){
                System.out.println("Data máxima inválida!");
            }else {
                biblioteca.imprimeRelatorioAlugueis(dataMin, dataMax);
            }

        }
    }

