package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub

		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e Where e.cedula= :datoCedula", Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);

		return myQuery.getSingleResult();
	}

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);

	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
	}

	@Override
	public void actualizarParcial(String cedulaActual, String cedulaNueva) {
		// TODO Auto-generated method stub

		Query myQuery = this.entityManager
				.createQuery("UPDATE Estudiante e SET e.cedula=:datoCedula WHERE e.cedula=:datoCondicion");
		myQuery.setParameter("datoCedula", cedulaNueva);
		myQuery.setParameter("datoCondicion", cedulaActual);
		myQuery.executeUpdate();

	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		// Recibe

		this.entityManager.remove(this.buscarPorId(id));

	}

	@Override
	public Estudiante buscarPorId(Integer id) {
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public List<Estudiante> buscarTodos(String provincia) {
		// TODO Auto-generated method stub

		TypedQuery<Estudiante> miQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.provincia=:datoProvincia", Estudiante.class);
		miQuery.setParameter("datoProvincia", provincia);

		return miQuery.getResultList();

	}

	@Override
	public Estudiante insertarModificado(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
		this.entityManager.find(Estudiante.class, estudiante.getId());
		
		return this.entityManager.find(Estudiante.class, estudiante.getId());
	}

	@Override
	public List<Estudiante> buscarTodosNormal() {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> miQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e ", Estudiante.class);

		return miQuery.getResultList();
	}

	

}
