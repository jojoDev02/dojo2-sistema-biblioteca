import java.util.Date;

public class Aluguel {
    private Cliente cliente;
    private Livro livro;
    private Date dataInicio;
    private StatusAluguel statusAluguel;

    public Aluguel(Cliente cliente, Livro livro, Date dataInicio, StatusAluguel statusAluguel) {
        this.cliente = cliente;
        this.livro = livro;
        this.dataInicio = dataInicio;
        this.statusAluguel = statusAluguel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public StatusAluguel getStatusAluguel() {
        return statusAluguel;
    }

    public void setStatusAluguel(StatusAluguel statusAluguel) {
        this.statusAluguel = statusAluguel;
    }
}
