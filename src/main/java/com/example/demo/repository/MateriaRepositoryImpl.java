package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Materia seleccionarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
	
		TypedQuery<Materia>myQuery=this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.codigo=:datoCodigo", Materia.class);
		myQuery.setParameter("datoCodigo", codigo);
		
		return myQuery.getSingleResult();
	}
	
	@Override
	public Materia buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Materia.class, id);
	}
	
	@Override
	public List<Materia> buscarTodos(String tipo) {
		// TODO Auto-generated method stub
		
		TypedQuery<Materia>myQuery=this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.tipo=:datoTipo", Materia.class);
		myQuery.setParameter("datoTipo", tipo);
		
		return myQuery.getResultList();
	}

	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
		
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
	
		this.entityManager.merge(materia);
		
	}

	@Override
	public void actualizarParcial(String codigoActual,String codigoNueva) {
		// TODO Auto-generated method stub
		
		Query myQuery=this.entityManager.createNativeQuery("UPDATE Materia m SET m.nombre=:datoNombre WHERE m.nombre=:datoCondicion");
		myQuery.setParameter("datoNombre", codigoNueva);
		myQuery.setParameter("datoCondicion", codigoActual);
		myQuery.executeUpdate();
		
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorId(id));
	}

	

	

}
