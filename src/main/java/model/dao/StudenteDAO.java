package model.dao;

import model.entities.Studente;
import org.hibernate.Session;
import utility.exceptions.ObjectNotFoundException;

import java.util.List;

public class StudenteDAO
{
	private Session session;

	public StudenteDAO(Session session)
	{
		this.session = session;
	}

	public Studente findById(Long id)
	{
		session.beginTransaction();
		Studente res = session.get(Studente.class,id);
		session.getTransaction().commit();
		return res;
	}

	public List<Studente> findAll()
	{
		session.beginTransaction();
		List<Studente> res = session.createQuery("SELECT s FROM Studente s", Studente.class).getResultList();
		session.getTransaction().commit();
		return  res;
	}

	//lui fa sia update che insert
	public void save(Studente s)
	{
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
	}

	public void delete(Long id)
	{
		session.beginTransaction();
		Studente toDelete =findById(id);
		if(toDelete==null)
			throw new ObjectNotFoundException("Non posso cancellare qualcosa che non esiste");

		session.delete(toDelete);
		session.getTransaction().commit();
	}
}
