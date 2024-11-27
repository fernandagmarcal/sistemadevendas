public class Produto {
    private String codigo;
    private String nome;
    private double valorUnitario;
    private int estoque;

    public Produto(String codigo, String nome, double valorUnitario, int estoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.estoque = estoque;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Valor Unitário: " + valorUnitario + ", Estoque: " + estoque;
    }
}
