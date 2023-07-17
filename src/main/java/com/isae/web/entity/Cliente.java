package com.isae.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcliente;
	
	private String cliente;
	private String urllogo;
	private String estatus;
	
	@OneToOne
	@JoinColumn(name="idclienteaplicacion")
	private ClienteAplicacion clienteAplicacion;
	
	public Cliente() {
		super();
	}

	public Cliente(int idcliente, String cliente, String urllogo, String estatus, ClienteAplicacion clienteAplicacion) {
		super();
		this.idcliente = idcliente;
		this.cliente = cliente;
		this.urllogo = urllogo;
		this.estatus = estatus;
		this.clienteAplicacion = clienteAplicacion;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getUrllogo() {
		return urllogo;
	}

	public void setUrllogo(String urllogo) {
		this.urllogo = urllogo;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public ClienteAplicacion getClienteAplicacion() {
		return clienteAplicacion;
	}

	public void setClienteAplicacion(ClienteAplicacion clienteAplicacion) {
		this.clienteAplicacion = clienteAplicacion;
	}

	@Override
	public String toString() {
		return "Cliente [idcliente=" + idcliente + ", cliente=" + cliente + ", urllogo=" + urllogo + ", estatus="
				+ estatus + ", clienteAplicacion=" + clienteAplicacion + "]";
	}

	
}
