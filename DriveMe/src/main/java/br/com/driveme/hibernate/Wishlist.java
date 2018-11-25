package br.com.driveme.hibernate;
// Generated 18/11/2018 00:04:27 by Hibernate Tools 5.2.11.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Wishlist generated by hbm2java
 */
@Entity
@Table(name = "wishlist", catalog = "drivemedev_v1")
public class Wishlist implements java.io.Serializable {

	private long wishId;
	private Peca peca;
	private Usuario usuario;

	public Wishlist() {
	}

	public Wishlist(long wishId, Peca peca, Usuario usuario) {
		this.wishId = wishId;
		this.peca = peca;
		this.usuario = usuario;
	}

	@Id

	@Column(name = "wish_id", unique = true, nullable = false)
	public long getWishId() {
		return this.wishId;
	}

	public void setWishId(long wishId) {
		this.wishId = wishId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "peca_id", nullable = false)
	public Peca getPeca() {
		return this.peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usua_id", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
