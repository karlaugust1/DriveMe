package br.com.driveme.entity;
// Generated 22/08/2018 18:35:11 by Hibernate Tools 5.2.11.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PecaAplicacao generated by hbm2java
 */
@Entity
@Table(name = "peca_aplicacao", catalog = "driveme")
public class PecaAplicacao implements java.io.Serializable {

	private long peapId;
	private Aplicacao aplicacao;
	private Peca peca;

	public PecaAplicacao() {
	}

	public PecaAplicacao(long peapId, Aplicacao aplicacao, Peca peca) {
		this.peapId = peapId;
		this.aplicacao = aplicacao;
		this.peca = peca;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "peap_id", unique = true, nullable = false)
	public long getPeapId() {
		return this.peapId;
	}

	public void setPeapId(long peapId) {
		this.peapId = peapId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "peap_apli_id", nullable = false)
	public Aplicacao getAplicacao() {
		return this.aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "peap_peca_id", nullable = false)
	public Peca getPeca() {
		return this.peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

}