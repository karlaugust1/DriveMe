package br.com.driveme.util;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

public class ServiceResponse {

	private ResponseType status;
	private String mensagem;
	private String detalhes;
	private Map<String, Object> result;
	
	public ServiceResponse() {}
	
	public ServiceResponse(ResponseType status, String mensagem, String detalhes, Map<String, Object> result) {
		this.status = status;
		this.mensagem = mensagem;
		this.detalhes = detalhes;
		this.result = result;
	}

	public ResponseType getStatus() {
		return status;
	}
	public void setStatus(ResponseType status) {
		this.status = status;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	@JsonAnyGetter
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	
}
