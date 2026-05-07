package mercado.repository;

import mercado.model.Produto;

public interface ProdutoRepository {

	// CRUD do Produto
		public void procurarPorId(int id);
		public void listarTodas();
		public void cadastrar(Produto produto);
		public void atualizar(Produto produto);
		public void deletar(int id);
	
}
