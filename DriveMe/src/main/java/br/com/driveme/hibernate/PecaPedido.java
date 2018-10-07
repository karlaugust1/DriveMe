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
 * PecaPedido generated by hbm2java
 */
@Entity
@Table(name = "peca_pedido", catalog = "drivemedev_v1")
public class PecaPedido implements java.io.Serializable {

	private long pepeId;
	private Peca peca;
	private Pedido pedido;
	private int pepeQuantidade;
	private double pepeSubtotal;

	public PecaPedido() {
	}

	public PecaPedido(long pepeId, Peca peca, Pedido pedido, int pepeQuantidade, double pepeSubtotal) {
		this.pepeId = pepeId;
		this.peca = peca;
		this.pedido = pedido;
		this.pepeQuantidade = pepeQuantidade;
		this.pepeSubtotal = pepeSubtotal;
	}

	@Id

	@Column(name = "pepe_id", unique = true, nullable = false)
	public long getPepeId() {
		return this.pepeId;
	}

	public void setPepeId(long pepeId) {
		this.pepeId = pepeId;
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
	@JoinColumn(name = "pedi_id", nullable = false)
	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Column(name = "pepe_quantidade", nullable = false)
	public int getPepeQuantidade() {
		return this.pepeQuantidade;
	}

	public void setPepeQuantidade(int pepeQuantidade) {
		this.pepeQuantidade = pepeQuantidade;
	}

	@Column(name = "pepe_subtotal", nullable = false, precision = 22, scale = 0)
	public double getPepeSubtotal() {
		return this.pepeSubtotal;
	}

	public void setPepeSubtotal(double pepeSubtotal) {
		this.pepeSubtotal = pepeSubtotal;
	}

}