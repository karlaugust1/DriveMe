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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TipoUsuario generated by hbm2java
 */
@Entity
@Table(name = "tipo_usuario", catalog = "drivemedev_v1")
public class TipoUsuario implements java.io.Serializable {

	private Long tiusId;
	private String tiusDescricao;
	private Set usuarios = new HashSet(0);

	public TipoUsuario() {
	}

	public TipoUsuario(String tiusDescricao) {
		this.tiusDescricao = tiusDescricao;
	}

	public TipoUsuario(String tiusDescricao, Set usuarios) {
		this.tiusDescricao = tiusDescricao;
		this.usuarios = usuarios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "tius_id", unique = true, nullable = false)
	public Long getTiusId() {
		return this.tiusId;
	}

	public void setTiusId(Long tiusId) {
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
