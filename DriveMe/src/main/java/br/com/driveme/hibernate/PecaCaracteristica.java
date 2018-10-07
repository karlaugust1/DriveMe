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
 * PecaCaracteristica generated by hbm2java
 */
@Entity
@Table(name = "peca_caracteristica", catalog = "drivemedev_v1")
public class PecaCaracteristica implements java.io.Serializable {

	private long pecaId;
	private Peca peca;
	private String pecaTitulo;
	private String pecaCaracteristica;

	public PecaCaracteristica() {
	}

	public PecaCaracteristica(long pecaId, Peca peca, String pecaTitulo, String pecaCaracteristica) {
		this.pecaId = pecaId;
		this.peca = peca;
		this.pecaTitulo = pecaTitulo;
		this.pecaCaracteristica = pecaCaracteristica;
	}

	@Id

	@Column(name = "peca_id", unique = true, nullable = false)
	public long getPecaId() {
		return this.pecaId;
	}

	public void setPecaId(long pecaId) {
		this.pecaId = pecaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "peca_peca_id", nullable = false)
	public Peca getPeca() {
		return this.peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	@Column(name = "peca_titulo", nullable = false, length = 100)
	public String getPecaTitulo() {
		return this.pecaTitulo;
	}

	public void setPecaTitulo(String pecaTitulo) {
		this.pecaTitulo = pecaTitulo;
	}

	@Column(name = "peca_caracteristica", nullable = false, length = 200)
	public String getPecaCaracteristica() {
		return this.pecaCaracteristica;
	}

	public void setPecaCaracteristica(String pecaCaracteristica) {
		this.pecaCaracteristica = pecaCaracteristica;
	}

}
