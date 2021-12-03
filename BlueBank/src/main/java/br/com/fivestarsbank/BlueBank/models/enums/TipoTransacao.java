package br.com.fivestarsbank.BlueBank.models.enums;

public enum TipoTransacao {
	
	NA(0, ""),
	PIX(1, "Pix"), 
	TED(2, "TED"), 
	DOC(3, "DOC"), 
	TRANSF(4, "Transferência"), 
	CHEQUE(5, "Cheque");

	private Integer cod;
	private String descricao;

	private TipoTransacao(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	//é static para poder usar esse método sem instanciar a classe
	public static TipoTransacao toEnum(Integer cod) {
		if (cod == null)
			return null;

		for (TipoTransacao i : TipoTransacao.values()) {
			if (cod.equals(i.getCod()))
				return i;
		}

		throw new IllegalArgumentException("Código do tipo de transação inválido!");
	}
}
