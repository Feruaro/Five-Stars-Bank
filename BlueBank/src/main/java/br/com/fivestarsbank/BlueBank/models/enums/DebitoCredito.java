package br.com.fivestarsbank.BlueBank.models.enums;

public enum DebitoCredito {

	NA(0, ""),
	DEBITO(1, "débito"), 
	CREDITO(2, "crédito");

	private Integer cod;
	private String descrição;

	private DebitoCredito(Integer cod, String descrição) {
		this.cod = cod;
		this.descrição = descrição;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	//é static para poder usar esse método sem instanciar a classe
	public static DebitoCredito toEnum(Integer cod) {
		if(cod == null) return null;
		
		for(DebitoCredito i : DebitoCredito.values()) {
			if(cod.equals(i.getCod())) return i; 
		}
		
		// se não cair no if ou for:
		throw new IllegalArgumentException("Código para informa débito ou crédito inválido!");
		
	}
	
}
