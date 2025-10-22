package modelDominio;

import java.io.Serializable;

public class Servico implements Serializable {
    private static final long serialVersionUID = 4L;

    private int id;
    private String nome;
    private String descricao;
    private float preco;
    private int duracaoEstimadaMin;

    public Servico(int id, String nome, String descricao, float preco, int duracaoEstimadaMin) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.duracaoEstimadaMin = duracaoEstimadaMin;
    }

    public Servico(String nome, String descricao, float preco, int duracaoEstimadaMin) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.duracaoEstimadaMin = duracaoEstimadaMin;
    }

    public Servico(int id) {
        this.id = id;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public float getPreco() { return preco; }
    public void setPreco(float preco) { this.preco = preco; }

    public int getDuracaoEstimadaMin() { return duracaoEstimadaMin; }
    public void setDuracaoEstimadaMin(int duracaoEstimadaMin) { this.duracaoEstimadaMin = duracaoEstimadaMin; }

    @Override
    public String toString() {
        return "Servico{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao +
                ", preco=" + preco + ", duracaoEstimadaMin=" + duracaoEstimadaMin + '}';
    }
}
