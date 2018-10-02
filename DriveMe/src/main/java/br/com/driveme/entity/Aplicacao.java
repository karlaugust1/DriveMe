package br.com.driveme.entity;
// Generated 09/09/2018 21:13:34 by Hibernate Tools 5.2.11.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Aplicacao generated by hbm2java
 */
@Entity
@Table(name = "aplicacao", catalog = "driveme")
@JsonIgnoreProperties(value = "pecas")
public class Aplicacao implements java.io.Serializable {

	private long apliId;
	private String apliDescricao;
	private String apliIcone;
	private Set<Peca> pecas = new HashSet<Peca>(0);

	public Aplicacao() {
	}

	public Aplicacao(long apliId, String apliDescricao, String apliIcone) {
		this.apliId = apliId;
		this.apliDescricao = apliDescricao;
		this.apliIcone = apliIcone;
	}

	public Aplicacao(long apliId, String apliDescricao, String apliIcone, Set<Peca> pecas) {
		this.apliId = apliId;
		this.apliDescricao = apliDescricao;
		this.apliIcone = apliIcone;
		this.pecas = pecas;
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

	@Column(name = "apli_icone", nullable = false, length = 100)
	public String getApliIcone() {
		return this.apliIcone;
	}

	public void setApliIcone(String apliIcone) {
		this.apliIcone = apliIcone;
	}

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "aplicacaos")
	/*@JoinTable(name = "peca_aplicacao", catalog = "driveme", joinColumns = {
			@JoinColumn(name = "apli_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "peca_id", nullable = false, updatable = false) })*/
	public Set<Peca> getPecas() {
		return this.pecas;
	}

	public void setPecas(Set<Peca> pecas) {
		this.pecas = pecas;
	}

}
