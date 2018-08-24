package br.com.driveme.entity;
// Generated 24/08/2018 20:23:20 by Hibernate Tools 5.2.11.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Peca generated by hbm2java
 */
@Entity
@Table(name = "peca", catalog = "driveme")
public class Peca implements java.io.Serializable {

	private long pecaId;
	private String pecaIdOriginal;
	private String pecaDescricao;
	private Integer pecaVisualizacao;
	private double pecaValor;
	private Set<PecaImagem> pecaImagems = new HashSet(0);
	private Set<PecaAplicacao> pecaAplicacaos = new HashSet(0);
	private Set<PecaAvaliacao> pecaAvaliacaos = new HashSet(0);
	private Set<PecaModelo> pecaModelos = new HashSet(0);
	private Set<PecaPedido> pecaPedidos = new HashSet(0);

	public Peca() {
	}

	public Peca(long pecaId, String pecaIdOriginal, String pecaDescricao, double pecaValor) {
		this.pecaId = pecaId;
		this.pecaIdOriginal = pecaIdOriginal;
		this.pecaDescricao = pecaDescricao;
		this.pecaValor = pecaValor;
	}

	public Peca(long pecaId, String pecaIdOriginal, String pecaDescricao, Integer pecaVisualizacao, double pecaValor,
			Set<PecaImagem> pecaImagems, Set<PecaAplicacao> pecaAplicacaos, Set<PecaAvaliacao> pecaAvaliacaos, Set<PecaModelo> pecaModelos, Set<PecaPedido> pecaPedidos) {
		this.pecaId = pecaId;
		this.pecaIdOriginal = pecaIdOriginal;
		this.pecaDescricao = pecaDescricao;
		this.pecaVisualizacao = pecaVisualizacao;
		this.pecaValor = pecaValor;
		this.pecaImagems = pecaImagems;
		this.pecaAplicacaos = pecaAplicacaos;
		this.pecaAvaliacaos = pecaAvaliacaos;
		this.pecaModelos = pecaModelos;
		this.pecaPedidos = pecaPedidos;
	}

	@Id

	@Column(name = "peca_id", unique = true, nullable = false)
	public long getPecaId() {
		return this.pecaId;
	}

	public void setPecaId(long pecaId) {
		this.pecaId = pecaId;
	}

	@Column(name = "peca_id_original", nullable = false, length = 45)
	public String getPecaIdOriginal() {
		return this.pecaIdOriginal;
	}

	public void setPecaIdOriginal(String pecaIdOriginal) {
		this.pecaIdOriginal = pecaIdOriginal;
	}

	@Column(name = "peca_descricao", nullable = false, length = 200)
	public String getPecaDescricao() {
		return this.pecaDescricao;
	}

	public void setPecaDescricao(String pecaDescricao) {
		this.pecaDescricao = pecaDescricao;
	}

	@Column(name = "peca_visualizacao")
	public Integer getPecaVisualizacao() {
		return this.pecaVisualizacao;
	}

	public void setPecaVisualizacao(Integer pecaVisualizacao) {
		this.pecaVisualizacao = pecaVisualizacao;
	}

	@Column(name = "peca_valor", nullable = false, precision = 22, scale = 0)
	public double getPecaValor() {
		return this.pecaValor;
	}

	public void setPecaValor(double pecaValor) {
		this.pecaValor = pecaValor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "peca")
	public Set<PecaImagem> getPecaImagems() {
		return this.pecaImagems;
	}

	public void setPecaImagems(Set<PecaImagem> pecaImagems) {
		this.pecaImagems = pecaImagems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "peca")
	public Set<PecaAplicacao> getPecaAplicacaos() {
		return this.pecaAplicacaos;
	}

	public void setPecaAplicacaos(Set<PecaAplicacao> pecaAplicacaos) {
		this.pecaAplicacaos = pecaAplicacaos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "peca")
	public Set<PecaAvaliacao> getPecaAvaliacaos() {
		return this.pecaAvaliacaos;
	}

	public void setPecaAvaliacaos(Set<PecaAvaliacao> pecaAvaliacaos) {
		this.pecaAvaliacaos = pecaAvaliacaos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "peca")
	public Set<PecaModelo> getPecaModelos() {
		return this.pecaModelos;
	}

	public void setPecaModelos(Set<PecaModelo> pecaModelos) {
		this.pecaModelos = pecaModelos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "peca")
	public Set<PecaPedido> getPecaPedidos() {
		return this.pecaPedidos;
	}

	public void setPecaPedidos(Set<PecaPedido> pecaPedidos) {
		this.pecaPedidos = pecaPedidos;
	}

}