package br.com.fivestarsbank.BlueBank.models.enums;

public enum StatusConta {
	
	ATIVO(1, "Conta ativa"), 
	INATIVO(2, "Conta inativa");
	
	private Integer cod;
	private String descricao;	

	private StatusConta(Integer cod, String descricao) {
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
	public static StatusConta toEnum(Integer cod) {
		if(cod == null) return null;
		
		for(StatusConta i : StatusConta.values()) {
			if(cod.equals(i.getCod())) return i; 
		}
		
		//se não cair no if ou for:
		throw new IllegalArgumentException("Código do status da conta inválido!");
	}
}
