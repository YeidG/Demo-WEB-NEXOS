package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.demo.model.Empleado;
import com.demo.model.JPAUtil;

public class EmpleadoDao {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	// guardar cliente
		public void guardar(Empleado Empleado) {
			entity.getTransaction().begin();
			entity.persist(Empleado);
			entity.getTransaction().commit();
			//JPAUtil.shutdown();
		}

		// editar Empleado
		public void editar(Empleado Empleado) {
			entity.getTransaction().begin();
			entity.merge(Empleado);
			entity.getTransaction().commit();
			/// JPAUtil.shutdown();
		}

		// buscar Empleado
		public Empleado buscar(Long id) {
			Empleado c = new Empleado();
			c = entity.find(Empleado.class, id);
			// JPAUtil.shutdown();
			return c;
		}

		/// eliminar Empleado
		public void eliminar(Long id) {
			Empleado c = new Empleado();
			c = entity.find(Empleado.class, id);
			entity.getTransaction().begin();
			entity.remove(c);
			entity.getTransaction().commit();
		}

		// obtener todos los Empleado
		public List<Empleado> obtenerEmpleados() {
			List<Empleado> listaEmpleados = new ArrayList<>();
			Query q = entity.createQuery("SELECT c FROM Empleado c");
			listaEmpleados = q.getResultList();
			return listaEmpleados;
		}
}
