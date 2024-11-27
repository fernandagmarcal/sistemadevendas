import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<String, Produto> produtos;

    public Estoque() {
        this.produtos = new HashMap<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getCodigo(), produto);
    }

    public Produto consultarProduto(String codigo) {
        return produtos.get(codigo);
    }

    public void editarEstoque(String codigo, int novoEstoque) {
        Produto produto = produtos.get(codigo);
        if (produto != null) {
            produto.setEstoque(novoEstoque);
        }
    }

    public void desativarProduto(String codigo) {
        Produto produto = produtos.get(codigo);
        if (produto != null) {
            produto = new Produto(produto.getCodigo(), produto.getNome() + " [DESATIVADO]", produto.getValorUnitario(), 0);
            produtos.put(produto.getCodigo(), produto);
        }
    }

    public Map<String, Produto> getProdutos() {
        return produtos;
    }
}
