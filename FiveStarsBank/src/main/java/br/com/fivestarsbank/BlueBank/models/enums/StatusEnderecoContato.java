package br.com.fivestarsbank.BlueBank.models.enums;

public enum StatusEnderecoContato {

	ATIVO(1, "Dados ativo"), 
	INATIVO(2, "Dados inativo");

	private Integer cod;
	private String descricao;

	private StatusEnderecoContato(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	//é static para poder usar esse método sem instanciar a classe
	public static StatusEnderecoContato toEnum(Integer cod) {
		if (cod == null) return null;

		for (StatusEnderecoContato i : StatusEnderecoContato.values()) {
			if (cod.equals(i.getCod())) return i;
		}

		// se não cair no if ou for:
		throw new IllegalArgumentException("Código do status do endereço ou contato inválido!");
	}

}
