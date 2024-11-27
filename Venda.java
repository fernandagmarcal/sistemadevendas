import java.util.ArrayList;
import java.util.List;

public class Venda {
    private List<Produto> itens;
    private double totalVenda;

    public Venda() {
        this.itens = new ArrayList<>();
        this.totalVenda = 0.0;
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (produto.getEstoque() >= quantidade) {
            for (int i = 0; i < quantidade; i++) {
                itens.add(produto);
            }
            totalVenda += produto.getValorUnitario() * quantidade;
        } else {
            System.out.println("Estoque insuficiente para o produto: " + produto.getNome());
        }
    }

    public void cancelarProduto(String codigo) {
        for (Produto produto : itens) {
            if (produto.getCodigo().equals(codigo)) {
                itens.remove(produto);
                totalVenda -= produto.getValorUnitario();
                break;
            }
        }
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public List<Produto> getItens() {
        return itens;
    }

    public void finalizarVenda() {
        itens.clear();
    }
}
