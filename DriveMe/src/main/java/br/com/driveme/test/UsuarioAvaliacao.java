package br.com.driveme.test;
// Generated 02/10/2018 20:15:55 by Hibernate Tools 5.2.11.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UsuarioAvaliacao generated by hbm2java
 */
@Entity
@Table(name = "usuario_avaliacao", catalog = "driveme")
public class UsuarioAvaliacao implements java.io.Serializable {

	private Long usavId;
	private Usuario usuario;
	private int usavEstrelas;

	public UsuarioAvaliacao() {
	}

	public UsuarioAvaliacao(Usuario usuario, int usavEstrelas) {
		this.usuario = usuario;
		this.usavEstrelas = usavEstrelas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "usav_id", unique = true, nullable = false)
	public Long getUsavId() {
		return this.usavId;
	}

	public void setUsavId(Long usavId) {
		this.usavId = usavId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usua_id", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "usav_estrelas", nullable = false)
	public int getUsavEstrelas() {
		return this.usavEstrelas;
	}

	public void setUsavEstrelas(int usavEstrelas) {
		this.usavEstrelas = usavEstrelas;
	}

}
