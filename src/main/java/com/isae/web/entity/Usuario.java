package com.isae.web.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idusuario;

	@Column(name = "correo")
	private String correo;

	private String jefeinmediato;

	private String nombre;

	private String pass;

	private int passtemp;

	private String telefono;

	private String ubicacion;

	private String usuario;
	
	private String status;
	
	private String token;

	//bi-directional many-to-one association to Perfile
	@OneToOne
	@JoinColumn(name="perfil")
	private Perfile perfiles;

	public Usuario() {
	}
	
	public Usuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public Usuario(int idusuario, String correo, String jefeinmediato, String nombre, String pass, int passtemp,
			String telefono, String ubicacion, String usuario, Perfile perfiles) {
		this.idusuario = idusuario;
		this.correo = correo;
		this.jefeinmediato = jefeinmediato;
		this.nombre = nombre;
		this.pass = pass;
		this.passtemp = passtemp;
		this.telefono = telefono;
		this.ubicacion = ubicacion;
		this.usuario = usuario;
		this.perfiles = perfiles;
	}

	public int getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getJefeinmediato() {
		return this.jefeinmediato;
	}

	public void setJefeinmediato(String jefeinmediato) {
		this.jefeinmediato = jefeinmediato;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getPasstemp() {
		return this.passtemp;
	}

	public void setPasstemp(int passtemp) {
		this.passtemp = passtemp;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Perfile getPerfile() {
		return this.perfiles;
	}

	public void setPerfile(Perfile perfile) {
		this.perfiles = perfile;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", correo=" + correo + ", jefeinmediato=" + jefeinmediato
				+ ", nombre=" + nombre + ", pass=" + pass + ", passtemp=" + passtemp + ", telefono=" + telefono
				+ ", ubicacion=" + ubicacion + ", usuario=" + usuario + ", status=" + status + ", token=" + token
				+ ", perfiles=" + perfiles + "]";
	}	

}