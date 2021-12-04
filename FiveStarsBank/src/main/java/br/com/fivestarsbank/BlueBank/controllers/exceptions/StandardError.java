package br.com.fivestarsbank.BlueBank.controllers.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer statusHttp;
	private String mensagemErro;
	private Long timeStamp;

	public StandardError(Integer statusHttp, String mensagemErro, Long timeStamp) {
		this.statusHttp = statusHttp;
		this.mensagemErro = mensagemErro;
		this.timeStamp = timeStamp;
	}

	public Integer getStatusHttp() {
		return statusHttp;
	}

	public void setStatusHttp(Integer statusHttp) {
		this.statusHttp = statusHttp;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
