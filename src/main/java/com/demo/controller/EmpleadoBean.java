package com.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.demo.model.Departamento;
import com.demo.model.Empleado;

@ManagedBean(name = "empleadobean")
@RequestScoped
public class EmpleadoBean {

	
	   @PersistenceContext(unitName = "yourPersistenceUnitName")
	    private EntityManager entityManager;

	    private Empleado selectedEmpleado;
	    private List<Empleado> Empleados;

	    @PostConstruct
	    public void init() {
	        selectedEmpleado = new Empleado();
	        loadEmpleados();
	    }

	    public void loadEmpleados() {
	        Empleados = entityManager.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
	    }

	    @Transactional
	    public void saveEmpleado() {
	        if (selectedEmpleado.getId() == null) {
	            // Nuevo empleado
	            entityManager.persist(selectedEmpleado);
	        } else {
	            // Actualizar empleado existente
	            entityManager.merge(selectedEmpleado);
	        }
	        selectedEmpleado = new Empleado(); // Limpiar el formulario
	        loadEmpleados(); // Recargar la lista de empleados
	    }

	    @Transactional
	    public void deleteEmpleado(Empleado Empleado) {
	        entityManager.remove(entityManager.merge(Empleado));
	        loadEmpleados(); // Recargar la lista de empleados
	    }

	    // Getters y setters

	    public Empleado getSelectedEmpleado() {
	        return selectedEmpleado;
	    }

	    public void setSelectedEmpleado(Empleado selectedEmpleado) {
	        this.selectedEmpleado = selectedEmpleado;
	    }

	    public List<Empleado> getEmpleados() {
	        return Empleados;
	    }
	    
	    public Empleado getbyid(Long id) {
	    	
	    	Empleado dep = new Empleado();
	    	dep =  entityManager.createQuery("SELECT d FROM Empleado d where d.id=" + id, Empleado.class).getSingleResult();
	    	return 	dep;		
	    }
	 // Método para redirigir a la vista de creación de empleado con el ID del empleado
	    
	    // Método para redirigir a la página de edición de un departamento
	    public String redirectToEditDepartamento(Long empleadoId) {
	        // Lógica para obtener el departamento y realizar la redirección
	        Empleado Empleado= new Empleado();
			try {
				
				Empleado =  this.getbyid(empleadoId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        if (Empleado != null && Empleado.getId()!=null) {
	            // Coloca el departamento en un atributo de sesión para que esté disponible en la página de edición
	            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("editDepartamento", Empleado);
	            
	            // Redirige a la página de edición de departamentos
	            NavigationHandler navigationHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
	            navigationHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/nuevoDepartamento.xhtml?faces-redirect=true");
	        }
	        
	        return null;
	    }

}
