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
 * TipoVeiculo generated by hbm2java
 */
@Entity
@Table(name = "tipo_veiculo", catalog = "drivemedev_v1")
@JsonIgnoreProperties(value = {"pecas"})
public class TipoVeiculo implements java.io.Serializable {

	private long tiveId;
	private String tiveDescricao;
	private String tiveIcone;
	private Set<Peca> pecas = new HashSet<Peca>(0);

	public TipoVeiculo() {
	}

	public TipoVeiculo(long tiveId, String tiveDescricao, String tiveIcone) {
		this.tiveId = tiveId;
		this.tiveDescricao = tiveDescricao;
		this.tiveIcone = tiveIcone;
	}

	public TipoVeiculo(long tiveId, String tiveDescricao, String tiveIcone, Set<Peca> pecas) {
		this.tiveId = tiveId;
		this.tiveDescricao = tiveDescricao;
		this.tiveIcone = tiveIcone;
		this.pecas = pecas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tive_id", unique = true, nullable = false)
	public long getTiveId() {
		return this.tiveId;
	}

	public void setTiveId(long tiveId) {
		this.tiveId = tiveId;
	}

	@Column(name = "tive_descricao", nullable = false, length = 100)
	public String getTiveDescricao() {
		return this.tiveDescricao;
	}

	public void setTiveDescricao(String tiveDescricao) {
		this.tiveDescricao = tiveDescricao;
	}

	@Column(name = "tive_icone", nullable = false, length = 100)
	public String getTiveIcone() {
		return this.tiveIcone;
	}

	public void setTiveIcone(String tiveIcone) {
		this.tiveIcone = tiveIcone;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "peca_tipo_veiculo", catalog = "drivemedev_v1", joinColumns = {
			@JoinColumn(name = "tive_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "peca_id", nullable = false, updatable = false) })
	public Set<Peca> getPecas() {
		return this.pecas;
	}

	public void setPecas(Set<Peca> pecas) {
		this.pecas = pecas;
	}

}
