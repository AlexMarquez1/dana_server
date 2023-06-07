package com.isae.web.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the proyecto database table.
 * 
 */
@Entity
@Table(name="proyecto")
@NamedQuery(name="Proyecto.findAll", query="SELECT p FROM Proyecto p")
public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproyecto;

	@Temporal(TemporalType.DATE)
	private Date fechacreacion;

	private String proyecto;

	//bi-directional many-to-one association to Tipoproyecto
	@ManyToOne
	@JoinColumn(name="idtipo")
	private Tipoproyecto tipoproyecto;
	
	private String folioautomatico;

	public Proyecto() {
	}

	public Proyecto(int idproyecto) {
		this.idproyecto = idproyecto;
	}

	public Proyecto(int idproyecto, Date fechacreacion, String proyecto, Tipoproyecto tipoproyecto) {
		this.idproyecto = idproyecto;
		this.fechacreacion = fechacreacion;
		this.proyecto = proyecto;
		this.tipoproyecto = tipoproyecto;
	}

	public Proyecto(int idproyecto, Date fechacreacion, String proyecto, Tipoproyecto tipoproyecto,
			String folioautomatico) {
		this.idproyecto = idproyecto;
		this.fechacreacion = fechacreacion;
		this.proyecto = proyecto;
		this.tipoproyecto = tipoproyecto;
		this.folioautomatico = folioautomatico;
	}

	public int getIdproyecto() {
		return this.idproyecto;
	}

	public void setIdproyecto(int idproyecto) {
		this.idproyecto = idproyecto;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public Tipoproyecto getTipoproyecto() {
		return this.tipoproyecto;
	}

	public void setTipoproyecto(Tipoproyecto tipoproyecto) {
		this.tipoproyecto = tipoproyecto;
	}

	public String getFolioautomatico() {
		return folioautomatico;
	}

	public void setFolioautomatico(String folioautomatico) {
		this.folioautomatico = folioautomatico;
	}

	@Override
	public String toString() {
		return "Proyecto [idproyecto=" + idproyecto + ", fechacreacion=" + fechacreacion + ", proyecto=" + proyecto
				+ ", tipoproyecto=" + tipoproyecto + ", folioautomatico=" + folioautomatico + "]";
	}


}