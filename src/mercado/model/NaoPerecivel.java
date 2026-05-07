package mercado.model;

public class NaoPerecivel extends Produto {

	// 2. Atributo específico desta classe
    private String setor;

    // 3. Construtor
    public NaoPerecivel(int id, String nome, int tipo, float preco, String setor) {
        // 4. 'super' envia os dados para o construtor da classe Mãe (Produto)
        super(id, nome, tipo, preco);
        this.setor = setor;
    }

    // 5. Getters e Setters específicos
    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    // 6. Polimorfismo: Adaptando o método visualizar
    @Override
    public void visualizar() {
        super.visualizar(); // Chama o visualizar da Mãe
        System.out.println("Setor: " + this.setor); // Adiciona o setor próprio
    }
	
}
