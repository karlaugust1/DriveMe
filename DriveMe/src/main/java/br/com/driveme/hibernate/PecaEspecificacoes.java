package br.com.driveme.hibernate;
// Generated 05/10/2018 12:48:45 by Hibernate Tools 5.2.11.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PecaEspecificacoes generated by hbm2java
 */
@Entity
@Table(name = "peca_especificacoes", catalog = "drivemedev_v1")
public class PecaEspecificacoes implements java.io.Serializable {

	private long peesId;
	private Peca peca;
	private String pecaEspecificacao;

	public PecaEspecificacoes() {
	}

	public PecaEspecificacoes(long peesId, Peca peca, String pecaEspecificacao) {
		this.peesId = peesId;
		this.peca = peca;
		this.pecaEspecificacao = pecaEspecificacao;
	}

	@Id

	@Column(name = "pees_id", unique = true, nullable = false)
	public long getPeesId() {
		return this.peesId;
	}

	public void setPeesId(long peesId) {
		this.peesId = peesId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "peca_id", nullable = false)
	public Peca getPeca() {
		return this.peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	@Column(name = "peca_especificacao", nullable = false, length = 200)
	public String getPecaEspecificacao() {
		return this.pecaEspecificacao;
	}

	public void setPecaEspecificacao(String pecaEspecificacao) {
		this.pecaEspecificacao = pecaEspecificacao;
	}

}