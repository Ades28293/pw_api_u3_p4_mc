package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CursoRepositoryImpl implements ICursoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Curso curso) {
		// TODO Auto-generated method stub
		this.entityManager.persist(curso);
	}

	@Override
	public Curso buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Curso.class, id);
	}

	@Override
	public Curso buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		
		TypedQuery<Curso> myQuery=this.entityManager.createQuery("SELECT c FROM Curso c WHERE c.codigo=:datoCurso", Curso.class);
		myQuery.setParameter("datoCurso", codigo);
				
		return myQuery.getSingleResult();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorId(id));
	}

	@Override
	public void actualizar(Curso curso) {
		// TODO Auto-generated method stub
		
		this.entityManager.merge(curso);
	}

	@Override
	public List<Curso> buscarTodos(String nivelCurso) {
		// TODO Auto-generated method stub
		TypedQuery<Curso> miQuery = this.entityManager
				.createQuery("SELECT c FROM Curso c WHERE c.nivelCurso=:datoCurso", Curso.class);
		miQuery.setParameter("datoCurso", nivelCurso);

		return miQuery.getResultList();

	}

	@Override
	public void actualizarParcial(String codigoActual, String codigoNuevo) {
		// TODO Auto-generated method stub
		

		Query myQuery = this.entityManager
				.createQuery("UPDATE Curso c SET c.codigo=:datoCurso WHERE c.codigo=:datoCondicion");
		myQuery.setParameter("datoCurso", codigoNuevo);
		myQuery.setParameter("datoCondicion", codigoActual);
		myQuery.executeUpdate();
		
	}

}
