package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Horario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HorarioRepositoryImpl implements IHorarioRepository {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public Horario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Horario.class, id);
	}

	@Override
	public Horario seleccionarPorParalelo(String paralelo) {
		// TODO Auto-generated method stub
		
		TypedQuery<Horario> myQuery=this.entityManager.createNamedQuery("SELECT h FROM Horario h WHERE h.paralelo=:datoParalelo",Horario.class);
		myQuery.setParameter("datoParalelo", paralelo);
		
		return myQuery.getSingleResult();
	}

	@Override
	public List<Horario> buscarTodos(String carrera) {
		// TODO Auto-generated method stub
		
		TypedQuery<Horario>myQuery=this.entityManager.createQuery("SELECT h FROM Horario h WHERE h.carrera=:datoCarrera", Horario.class);
		myQuery.setParameter("datoCarrera", carrera);
		
		return myQuery.getResultList();
	}

	@Override
	public void insertar(Horario horario) {
		// TODO Auto-generated method stub
		
		this.entityManager.persist(horario);
	}

	@Override
	public void actualizar(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(horario);
	}

	@Override
	public void actualizarParcial(String paraleloActual, String paraleloNuevo) {
		// TODO Auto-generated method stub
		
		TypedQuery<Horario>myQuery=this.entityManager.createQuery("UPDATE Horario h SET h.paralelo=:datoParalelo WHERE h.horario=:datoCondicion", Horario.class);
		myQuery.setParameter("datoCondicion", paraleloActual);
		myQuery.setParameter("datoParalelo", paraleloNuevo);
		myQuery.executeUpdate();
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		
		this.entityManager.remove(this.buscarPorId(id));
		
	}
	
	

}
