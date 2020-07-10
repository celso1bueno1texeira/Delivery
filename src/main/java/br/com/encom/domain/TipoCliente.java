package br.com.encom.domain;

public enum TipoCliente{
	
	FISICA("Física"),
	JURIDICA("Jurídica");
	
	
	private String tipoCliente;
	
	TipoCliente(String tipoCliente){
		this.tipoCliente = tipoCliente;
	}
	
	public String getTipoCliente() {
		return tipoCliente;
	}
	

}
