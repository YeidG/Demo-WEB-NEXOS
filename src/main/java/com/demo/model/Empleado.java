package com.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "documento_tipo")
	private String documentoTipo;
	@Column(name = "documento_numero")
	private String documentoNumero;
	@Column(name = "nombre")
	private String nombres;
	@Column(name = "apellidos")
	private String apellidos;

	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;
	@Column(name = "ciudad")
	private String ciudad;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "correo")
	private String correo;
	@Column(name = "telefono")
	private Long telefono;
	@Column(name = "fecha_hora_crea")
	private Date fecha_hora_crea;
	@Column(name = "fecha_hora_modifica")
	private Date fecha_hora_modifica;
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
	 * @return the documentoTipo
	 */
	public String getDocumentoTipo() {
		return documentoTipo;
	}
	/**
	 * @param documentoTipo the documentoTipo to set
	 */
	public void setDocumentoTipo(String documentoTipo) {
		this.documentoTipo = documentoTipo;
	}
	/**
	 * @return the documentoNumero
	 */
	public String getDocumentoNumero() {
		return documentoNumero;
	}
	/**
	 * @param documentoNumero the documentoNumero to set
	 */
	public void setDocumentoNumero(String documentoNumero) {
		this.documentoNumero = documentoNumero;
	}
	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}
	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * @return the departamento
	 */
	public Departamento getDepartamento() {
		return departamento;
	}
	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * @return the telefono
	 */
	public Long getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the fecha_hora_crea
	 */
	public Date getFecha_hora_crea() {
		return fecha_hora_crea;
	}
	/**
	 * @param fecha_hora_crea the fecha_hora_crea to set
	 */
	public void setFecha_hora_crea(Date fecha_hora_crea) {
		this.fecha_hora_crea = fecha_hora_crea;
	}
	/**
	 * @return the fecha_hora_modifica
	 */
	public Date getFecha_hora_modifica() {
		return fecha_hora_modifica;
	}
	/**
	 * @param fecha_hora_modifica the fecha_hora_modifica to set
	 */
	public void setFecha_hora_modifica(Date fecha_hora_modifica) {
		this.fecha_hora_modifica = fecha_hora_modifica;
	}

}
