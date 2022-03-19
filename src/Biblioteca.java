import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Biblioteca {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();
    private List<Aluguel> alugueis = new ArrayList<>();

    public Biblioteca(List<Cliente> clientes, List<Livro> livros, List<Aluguel> alugueis) {
        this.clientes = clientes;
        this.livros = livros;
        this.alugueis = alugueis;
    }

    public int buscaCliente(String cpf){
        for(Cliente c : clientes){
            if(c.getCpf().equals(cpf)){
                return clientes.indexOf(c);
            }
        }
        return -1;
    }

    public int buscaLivro(String id){
        for(Livro l: livros){

            if(l.getId().equals(id)){
                return livros.indexOf(l);
            }
        }
        return -1;
    }

    public void cadastraCliente(String nome, String cpf){
        if(buscaCliente(cpf) != -1){
            System.out.println("Cpf já cadastrado!");
        }else {
            Cliente cliente = new Cliente(nome, cpf);
            clientes.add(cliente);
            System.out.println("Cadastro concluído!");
        }
    }

    public void removeCliente(String cpf){
        for(Cliente c : clientes){
            if(c.getCpf().equals(cpf)){
                clientes.remove(c);
                System.out.println("Cliente removido!");
                return;
            }
        }
    }
    public void cadastraLivro(String titulo, String autor, String editora, String dataPublicacao, String id){
        if(buscaLivro(id) != -1){
            System.out.println("Erro, livro já cadastrado!");
            return;
        }else if(livros.size() <= 1000){
            Livro livro = new Livro(titulo, autor, editora, dataPublicacao, id, StatusLivro.DISPONIVEL);
            livros.add(livro);
            System.out.println("Cadastro concluído!");
        }

    }

    public void removeLivro(String id){
        if(buscaLivro(id) != -1){
            for(Livro l: livros){
                if(l.getId().equals(id)){
                    livros.remove(l);
                    return;
                }
            }
        }else {
            System.out.println("Livro não existe!");
        }
    }

    public void imprimeRelatorioAlugueis(Date dataMin, Date dataMax) {
        for (Aluguel aluguel : alugueis) {
            Date dataAluguel = aluguel.getDataInicio();

            if (dataAluguel.equals(dataMin) || dataAluguel.after(dataMin) && dataAluguel.before(dataMax) || dataAluguel.equals(dataMax)) {
                System.out.println("Cliente: " + aluguel.getCliente().getNome() + " Cpf: " + aluguel.getCliente().getCpf());
                System.out.println("Livro: " + aluguel.getLivro().getTitulo() + " Id: " + aluguel.getLivro().getId());
                System.out.println("Data de Incio: " + aluguel.getDataInicio());
                System.out.println("Status: " + aluguel.getStatusAluguel());
                System.out.println("----------------------");
            }
        }
    }
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }
}
