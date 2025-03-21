package model.dao;

import model.entities.Docente;
import org.hibernate.Session;
import utility.exceptions.ObjectNotFoundException;

import java.time.LocalDate;
import java.util.List;

public class DocenteDAO
{
	private Session session;

	public DocenteDAO(Session session)
	{
		this.session = session;
	}

	public Docente findById(Long id)
	{
		session.beginTransaction();
		Docente res = session.get(Docente.class,id);
		session.getTransaction().commit();
		return res;
	}

	public List<Docente> findAll()
	{
		session.beginTransaction();
		List<Docente> res = session.createQuery("SELECT d FROM Docente d", Docente.class).getResultList();
		session.getTransaction().commit();
		return  res;
	}

	//lui fa sia update che insert
	public void save(Docente d)
	{
		session.beginTransaction();
		session.save(d);
		session.getTransaction().commit();
	}

	public void delete(Long id)
	{
		session.beginTransaction();
		Docente toDelete =findById(id);
		if(toDelete==null)
			throw new ObjectNotFoundException("Non posso cancellare qualcosa che non esiste");

		session.delete(toDelete);
		session.getTransaction().commit();
	}
}
