package br.com.driveme.test;
// Generated 02/10/2018 20:15:55 by Hibernate Tools 5.2.11.Final

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
 * TipoVeiculo generated by hbm2java
 */
@Entity
@Table(name = "tipo_veiculo", catalog = "driveme")
public class TipoVeiculo implements java.io.Serializable {

	private Long tiveId;
	private String tiveDescricao;
	private String tiveIcone;
	private Set pecas = new HashSet(0);

	public TipoVeiculo() {
	}

	public TipoVeiculo(String tiveDescricao, String tiveIcone) {
		this.tiveDescricao = tiveDescricao;
		this.tiveIcone = tiveIcone;
	}

	public TipoVeiculo(String tiveDescricao, String tiveIcone, Set pecas) {
		this.tiveDescricao = tiveDescricao;
		this.tiveIcone = tiveIcone;
		this.pecas = pecas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "tive_id", unique = true, nullable = false)
	public Long getTiveId() {
		return this.tiveId;
	}

	public void setTiveId(Long tiveId) {
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
	@JoinTable(name = "peca_tipo_veiculo", catalog = "driveme", joinColumns = {
			@JoinColumn(name = "tive_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "peca_id", nullable = false, updatable = false) })
	public Set getPecas() {
		return this.pecas;
	}

	public void setPecas(Set pecas) {
		this.pecas = pecas;
	}

}
