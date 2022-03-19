import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Cliente {
    private String nome;
    private String cpf;
    private Queue<Livro> historicoAlugueis = new LinkedList<>();
    private int qtdAlugueis;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente(String nome, String cpf, Queue<Livro> historicoAlugueis, int qtdAlugueis) {
        this.nome = nome;
        this.cpf = cpf;
        this.historicoAlugueis = historicoAlugueis;
        this.qtdAlugueis = qtdAlugueis;
    }



    public void alugaLivro(Biblioteca biblioteca, Livro livro, Cliente cliente) {
        if (livro.getStatusLivro().equals(StatusLivro.DISPONIVEL) && qtdAlugueis < 2) {
            if (!historicoAlugueis.contains(livro)) {
                Aluguel aluguel = new Aluguel(cliente, livro, new Date(), StatusAluguel.EM_ANDAMENTO);
                biblioteca.getAlugueis().add(aluguel);
                if (historicoAlugueis.size() == 3) {
                    historicoAlugueis.poll();
                    historicoAlugueis.add(aluguel.getLivro());
                } else {
                    historicoAlugueis.add(aluguel.getLivro());
                }
                aluguel.setStatusAluguel(StatusAluguel.EM_ANDAMENTO);
                livro.setStatusLivro(StatusLivro.ALUGADO);
                qtdAlugueis++;
                System.out.println("Aluguel concluido!");
                return;
            } else {
                System.out.println("Erro, livro alugado anteriormente!");

            }
        } else {
            System.out.println("ERRO");
        }
    }
    public void devolveLivro(Biblioteca biblioteca, Livro livro, Cliente cliente){
        for (Aluguel aluguel : biblioteca.getAlugueis()) {
            if (aluguel.getLivro().equals(livro) && aluguel.getCliente().equals(cliente)) {
                aluguel.setStatusAluguel(StatusAluguel.ENCERRADO);
                livro.setStatusLivro(StatusLivro.DISPONIVEL);
                return;
            }
        }
        System.out.println("Aluguel não encontrado!");
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }


}
