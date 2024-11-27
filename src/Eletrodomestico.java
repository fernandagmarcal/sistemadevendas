public class Eletrodomestico extends Produto {
    private int garantiaMeses;

    public Eletrodomestico(String codigo, String nome, double valorUnitario, int estoque, int garantiaMeses) {
        super(codigo, nome, valorUnitario, estoque);
        this.garantiaMeses = garantiaMeses;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    @Override
    public String toString() {
        return super.toString() + ", Garantia: " + garantiaMeses + " meses";
    }
}
