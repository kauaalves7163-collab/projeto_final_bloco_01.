package mercado.model;

public abstract class Produto {

	// Atributos privados (Encapsulamento)
    private int id;
    private String nome;
    private int tipo;
    private float preco;

    // Método Construtor para inicializar os Objetos
    public Produto(int id, String nome, int tipo, float preco) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }

    // Métodos Getters e Setters (Modificadores de acesso)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    // Método Auxiliar para visualização (Base para Polimorfismo)
    public void visualizar() {

        String tipoProduto = "";

        switch (this.tipo) {
        case 1:
            tipoProduto = "Não Perecível";
            break;
        case 2:
            tipoProduto = "Perecível";
            break;
        }

        System.out.println("\n\n*****************************************************");
        System.out.println("Dados do Produto:");
        System.out.println("*****************************************************");
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Tipo: " + tipoProduto);
        System.out.println("Preço: " + this.preco);
        
    }
	
}
