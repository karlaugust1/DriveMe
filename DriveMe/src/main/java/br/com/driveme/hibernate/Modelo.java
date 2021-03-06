package br.com.driveme.hibernate;
// Generated 18/11/2018 00:04:27 by Hibernate Tools 5.2.11.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Modelo generated by hbm2java
 */
@Entity
@Table(name = "modelo", catalog = "drivemedev_v1")
public class Modelo implements java.io.Serializable {

	private Long modeId;
	private Montadora montadora;
	private String modeDescricao;
	private int modeAno;
	private String modeIcone;
	private Set pecas = new HashSet(0);

	public Modelo() {
	}

	public Modelo(Montadora montadora, String modeDescricao, int modeAno, String modeIcone) {
		this.montadora = montadora;
		this.modeDescricao = modeDescricao;
		this.modeAno = modeAno;
		this.modeIcone = modeIcone;
	}

	public Modelo(Montadora montadora, String modeDescricao, int modeAno, String modeIcone, Set pecas) {
		this.montadora = montadora;
		this.modeDescricao = modeDescricao;
		this.modeAno = modeAno;
		this.modeIcone = modeIcone;
		this.pecas = pecas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "mode_id", unique = true, nullable = false)
	public Long getModeId() {
		return this.modeId;
	}

	public void setModeId(Long modeId) {
		this.modeId = modeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mont_id", nullable = false)
	public Montadora getMontadora() {
		return this.montadora;
	}

	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}

	@Column(name = "mode_descricao", nullable = false, length = 100)
	public String getModeDescricao() {
		return this.modeDescricao;
	}

	public void setModeDescricao(String modeDescricao) {
		this.modeDescricao = modeDescricao;
	}

	@Column(name = "mode_ano", nullable = false)
	public int getModeAno() {
		return this.modeAno;
	}

	public void setModeAno(int modeAno) {
		this.modeAno = modeAno;
	}

	@Column(name = "mode_icone", nullable = false, length = 100)
	public String getModeIcone() {
		return this.modeIcone;
	}

	public void setModeIcone(String modeIcone) {
		this.modeIcone = modeIcone;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "modelos")
	public Set getPecas() {
		return this.pecas;
	}

	public void setPecas(Set pecas) {
		this.pecas = pecas;
	}

}
