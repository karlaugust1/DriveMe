package br.com.driveme.test;
// Generated 02/10/2018 20:15:55 by Hibernate Tools 5.2.11.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TipoUsuario generated by hbm2java
 */
@Entity
@Table(name = "tipo_usuario", catalog = "driveme")
public class TipoUsuario implements java.io.Serializable {

	private long tiusId;
	private String tiusDescricao;
	private Set usuarios = new HashSet(0);

	public TipoUsuario() {
	}

	public TipoUsuario(long tiusId, String tiusDescricao) {
		this.tiusId = tiusId;
		this.tiusDescricao = tiusDescricao;
	}

	public TipoUsuario(long tiusId, String tiusDescricao, Set usuarios) {
		this.tiusId = tiusId;
		this.tiusDescricao = tiusDescricao;
		this.usuarios = usuarios;
	}

	@Id

	@Column(name = "tius_id", unique = true, nullable = false)
	public long getTiusId() {
		return this.tiusId;
	}

	public void setTiusId(long tiusId) {
		this.tiusId = tiusId;
	}

	@Column(name = "tius_descricao", nullable = false, length = 100)
	public String getTiusDescricao() {
		return this.tiusDescricao;
	}

	public void setTiusDescricao(String tiusDescricao) {
		this.tiusDescricao = tiusDescricao;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoUsuario")
	public Set getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set usuarios) {
		this.usuarios = usuarios;
	}

}
