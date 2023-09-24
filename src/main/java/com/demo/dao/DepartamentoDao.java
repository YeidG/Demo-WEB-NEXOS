package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.demo.model.Departamento;
import com.demo.model.JPAUtil;

public class DepartamentoDao {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	// guardar Departamento
	public void guardar(Departamento Departamento) {
		entity.getTransaction().begin();
		entity.persist(Departamento);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}

	// editar Departamento
	public void editar(Departamento Departamento) {
		entity.getTransaction().begin();
		entity.merge(Departamento);
		entity.getTransaction().commit();
		/// JPAUtil.shutdown();
	}

	// buscar Departamento
	public Departamento buscar(Long id) {
		Departamento c = new Departamento();
		c = entity.find(Departamento.class, id);
		// JPAUtil.shutdown();
		return c;
	}

	/// eliminar Departamento
	public void eliminar(Long id) {
		Departamento c = new Departamento();
		c = entity.find(Departamento.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}

	// obtener todos los Departamento
	public List<Departamento> obtenerDepartamentos() {
		List<Departamento> listaDepartamentos = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Departamento c");
		listaDepartamentos = q.getResultList();
		return listaDepartamentos;
	}
}
