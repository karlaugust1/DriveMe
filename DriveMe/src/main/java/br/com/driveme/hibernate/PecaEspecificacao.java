package br.com.driveme.hibernate;
// Generated 18/11/2018 00:04:27 by Hibernate Tools 5.2.11.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PecaEspecificacao generated by hbm2java
 */
@Entity
@Table(name = "peca_especificacao", catalog = "drivemedev_v1")
public class PecaEspecificacao implements java.io.Serializable {

	private Long peesId;
	private Peca peca;
	private String pecaEspecificacao;

	public PecaEspecificacao() {
	}

	public PecaEspecificacao(Peca peca, String pecaEspecificacao) {
		this.peca = peca;
		this.pecaEspecificacao = pecaEspecificacao;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "pees_id", unique = true, nullable = false)
	public Long getPeesId() {
		return this.peesId;
	}

	public void setPeesId(Long peesId) {
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
