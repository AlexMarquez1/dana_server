package com.isae.web.entity;

public class Registro {
	private int idRegistro;
	private String folio;
	private String fechaCreacion;
	private Proyecto proyecto;
	private String estatus;
	

	public Registro(int idRegistro, String folio, String fechaCreacion, Proyecto proyecto, String estatus) {
		this.idRegistro = idRegistro;
		this.folio = folio;
		this.fechaCreacion = fechaCreacion;
		this.proyecto = proyecto;
		this.estatus = estatus;
	}

	public Registro() {
	}

	public int getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Registro [idRegistro=" + idRegistro + ", folio=" + folio + ", fechaCreacion=" + fechaCreacion
				+ ", proyecto=" + proyecto + ", estatus=" + estatus + "]";
	}

	
}
