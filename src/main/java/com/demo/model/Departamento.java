package com.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "departamento_codigo")
    private String departamentoCodigo;
    @Column(name = "departamento_nombre")
    private String departamentoNombre;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechacrea")
    private Date fechaHoraCrea;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaModifica")
    private Date fechaHoraModifica;

    
    
	public Departamento() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the departamentoCodigo
	 */
	public String getDepartamentoCodigo() {
		return departamentoCodigo;
	}

	/**
	 * @param departamentoCodigo the departamentoCodigo to set
	 */
	public void setDepartamentoCodigo(String departamentoCodigo) {
		this.departamentoCodigo = departamentoCodigo;
	}

	/**
	 * @return the departamentoNombre
	 */
	public String getDepartamentoNombre() {
		return departamentoNombre;
	}

	/**
	 * @param departamentoNombre the departamentoNombre to set
	 */
	public void setDepartamentoNombre(String departamentoNombre) {
		this.departamentoNombre = departamentoNombre;
	}

	/**
	 * @return the fechaHoraCrea
	 */
	public Date getFechaHoraCrea() {
		return fechaHoraCrea;
	}

	/**
	 * @param fechaHoraCrea the fechaHoraCrea to set
	 */
	public void setFechaHoraCrea(Date fechaHoraCrea) {
		this.fechaHoraCrea = fechaHoraCrea;
	}

	/**
	 * @return the fechaHoraModifica
	 */
	public Date getFechaHoraModifica() {
		return fechaHoraModifica;
	}

	/**
	 * @param fechaHoraModifica the fechaHoraModifica to set
	 */
	public void setFechaHoraModifica(Date fechaHoraModifica) {
		this.fechaHoraModifica = fechaHoraModifica;
	}
    
    
    
}
