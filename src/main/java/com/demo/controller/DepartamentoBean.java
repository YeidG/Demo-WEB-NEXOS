package com.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.NavigationHandler;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.demo.model.Departamento;

@ManagedBean(name = "departamentoBean")
@RequestScoped


public class DepartamentoBean {

	
	  @PersistenceContext(unitName = "yourPersistenceUnitName")
	    private EntityManager entityManager;

	    private Departamento selectedDepartamento;
	    private List<Departamento> Departamentos;

	    @PostConstruct
	    public void init() {
	        selectedDepartamento = new Departamento();
	        loadDepartamentos();
	    }

	    public void loadDepartamentos() {
	        Departamentos = entityManager.createQuery("SELECT d FROM Departamento d", Departamento.class).getResultList();
	    }
	    
	    
	    public Departamento getbyid(Long id) {
	    	
	    	Departamento dep = new Departamento();
	    	dep =  entityManager.createQuery("SELECT d FROM Departamento d where d.id=" + id, Departamento.class).getSingleResult();
	    	return 	dep;		
	    }
	    @Transactional
	    public void saveDepartamento() {
	        if (selectedDepartamento.getId() == null) {
	            // Nuevo departamento
	            entityManager.persist(selectedDepartamento);
	        } else {
	            // Actualizar departamento existente
	            entityManager.merge(selectedDepartamento);
	        }
	        selectedDepartamento = new Departamento(); // Limpiar el formulario
	        loadDepartamentos(); // Recargar la lista de departamentos
	    }

	    @Transactional
	    public void deleteDepartamento(Departamento Departamento) {
	        entityManager.remove(entityManager.merge(Departamento));
	        loadDepartamentos(); // Recargar la lista de departamentos
	    }

	    // Getters y setters

	    public Departamento getSelectedDepartamento() {
	        return selectedDepartamento;
	    }

	    public void setSelectedDepartamento(Departamento selectedDepartamento) {
	        this.selectedDepartamento = selectedDepartamento;
	    }

	    public List<Departamento> getDepartamentos() {
	        return Departamentos;
	    }
	    
	    
	    
	    // Método para redirigir a la página de edición de un departamento
	    public String redirectToEditDepartamento(Long DepartamentoId) {
	        // Lógica para obtener el departamento y realizar la redirección
	        Departamento Departamento= new Departamento();
			try {
				
				Departamento =  this.getbyid(DepartamentoId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        if (Departamento != null && Departamento.getId()!=null) {
	            // Coloca el departamento en un atributo de sesión para que esté disponible en la página de edición
	            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("editDepartamento", Departamento);
	            
	            // Redirige a la página de edición de departamentos
	            NavigationHandler navigationHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
	            navigationHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/editDepartamento.xhtml?faces-redirect=true");
	        }
	        
	        return null;
	    }
}
