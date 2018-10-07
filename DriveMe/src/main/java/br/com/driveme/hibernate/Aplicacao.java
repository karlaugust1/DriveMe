package br.com.driveme.hibernate;
// Generated 05/10/2018 12:48:45 by Hibernate Tools 5.2.11.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Aplicacao generated by hbm2java
 */
@Entity
@Table(name = "aplicacao", catalog = "drivemedev_v1")
public class Aplicacao implements java.io.Serializable {

	private Long apliId;
	private String apliDescricao;
	private String apliIcone;
	private Set pecas = new HashSet(0);

	public Aplicacao() {
	}

	public Aplicacao(String apliDescricao, String apliIcone) {
		this.apliDescricao = apliDescricao;
		this.apliIcone = apliIcone;
	}

	public Aplicacao(String apliDescricao, String apliIcone, Set pecas) {
		this.apliDescricao = apliDescricao;
		this.apliIcone = apliIcone;
		this.pecas = pecas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "apli_id", unique = true, nullable = false)
	public Long getApliId() {
		return this.apliId;
	}

	public void setApliId(Long apliId) {
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

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "peca_aplicacao", catalog = "drivemedev_v1", joinColumns = {
			@JoinColumn(name = "apli_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "peca_id", nullable = false, updatable = false) })
	public Set getPecas() {
		return this.pecas;
	}

	public void setPecas(Set pecas) {
		this.pecas = pecas;
	}

}