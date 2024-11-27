public class AlimentoUtensilio extends Produto {
    private int validadeDias;

    public AlimentoUtensilio(String codigo, String nome, double valorUnitario, int estoque, int validadeDias) {
        super(codigo, nome, valorUnitario, estoque);
        this.validadeDias = validadeDias;
    }

    public int getValidadeDias() {
        return validadeDias;
    }

    @Override
    public String toString() {
        return super.toString() + ", Validade: " + validadeDias + " dias";
    }
}
