package mercado.controller;

import java.util.ArrayList;
import mercado.model.Produto;
import mercado.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	// 1. Uso de Collections: ArrayList para armazenar os produtos
    private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    int numero = 0; // Auxiliar para gerar o ID automaticamente

    @Override
    public void procurarPorId(int id) {
        var produto = buscarNaCollection(id);

        if (produto != null)
            produto.visualizar();
        else
            System.out.println("\nO Produto id: " + id + " não foi encontrado!");
    }

    @Override
    public void listarTodas() {
        for (var produto : listaProdutos) {
            produto.visualizar();
        }
    }

    @Override
    public void cadastrar(Produto produto) {
        listaProdutos.add(produto);
        System.out.println("\nO Produto: " + produto.getNome() + " foi cadastrado com sucesso!");
    }

    @Override
    public void atualizar(Produto produto) {
        var buscaProduto = buscarNaCollection(produto.getId());

        if (buscaProduto != null) {
            listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
            System.out.println("\nO Produto id: " + produto.getId() + " foi atualizado com sucesso!");
        } else {
            System.out.println("\nO Produto id: " + produto.getId() + " não foi encontrado!");
        }
    }

    @Override
    public void deletar(int id) {
        var produto = buscarNaCollection(id);

        if (produto != null) {
            if (listaProdutos.remove(produto) == true)
                System.out.println("\nO Produto id: " + id + " foi deletado com sucesso!");
        } else {
            System.out.println("\nO Produto id: " + id + " não foi encontrado!");
        }
    }

    // Método Auxiliar para encontrar o produto na lista
    public Produto buscarNaCollection(int id) {
        for (var produto : listaProdutos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }
    
    // Método para gerar o ID automático
    public int gerarNumero() {
        return ++numero;
    }
	
}
