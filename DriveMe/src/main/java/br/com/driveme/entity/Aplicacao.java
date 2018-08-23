package br.com.driveme.entity;
// Generated 22/08/2018 18:35:11 by Hibernate Tools 5.2.11.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Aplicacao generated by hbm2java
 */
@Entity
@Table(name = "aplicacao", catalog = "driveme")
public class Aplicacao implements java.io.Serializable {

	private long apliId;
	private String apliDescricao;
	private Set<PecaAplicacao> pecaAplicacaos = new HashSet(0);

	public Aplicacao() {
	}

	public Aplicacao(long apliId, String apliDescricao) {
		this.apliId = apliId;
		this.apliDescricao = apliDescricao;
	}

	public Aplicacao(long apliId, String apliDescricao, Set<PecaAplicacao> pecaAplicacaos) {
		this.apliId = apliId;
		this.apliDescricao = apliDescricao;
		this.pecaAplicacaos = pecaAplicacaos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "apli_id", unique = true, nullable = false)
	public long getApliId() {
		return this.apliId;
	}

	public void setApliId(long apliId) {
		this.apliId = apliId;
	}

	@Column(name = "apli_descricao", nullable = false, length = 100)
	public String getApliDescricao() {
		return this.apliDescricao;
	}

	public void setApliDescricao(String apliDescricao) {
		this.apliDescricao = apliDescricao;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aplicacao")
	public Set<PecaAplicacao> getPecaAplicacaos() {
		return this.pecaAplicacaos;
	}

	public void setPecaAplicacaos(Set<PecaAplicacao> pecaAplicacaos) {
		this.pecaAplicacaos = pecaAplicacaos;
	}

}
