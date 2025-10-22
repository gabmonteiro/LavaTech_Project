package modelDominio;

import java.io.Serializable;

public class Veiculo implements Serializable {
    private static final long serialVersionUID = 2L;

    private int id;
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    private Cliente cliente; // relacionamento

    public Veiculo(int id, String placa, String marca, String modelo, String cor, int ano, Cliente cliente) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.cliente = cliente;
    }

    public Veiculo(String placa, String marca, String modelo, String cor, int ano, Cliente cliente) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.cliente = cliente;
    }

    public Veiculo(int id) {
        this.id = id;
    }

    // Getters e Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    @Override
    public String toString() {
        return "Veiculo{" + "id=" + id + ", placa=" + placa + ", marca=" + marca +
                ", modelo=" + modelo + ", cor=" + cor + ", ano=" + ano + ", cliente=" + cliente + '}';
    }
}
