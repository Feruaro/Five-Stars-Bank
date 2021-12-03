package br.com.fivestarsbank.BlueBank.models.enums;

public enum TipoCliente {
	
	PF(1, "Pessoa Física"),
	PJ(2, "Pessoa Jurídica");
	
	private Integer cod;
	private String descricao;	

	private TipoCliente(Integer cod, String descricao) {
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
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) return null;
		
		for(TipoCliente i : TipoCliente.values()) {
			if(cod.equals(i.getCod())) return i; 
		}
		
		//se não cair no if ou for:
		throw new IllegalArgumentException("Código para informar o tipo de cliente inválido!");
	}
	
}
