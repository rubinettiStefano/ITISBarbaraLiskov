package model.dao;

import model.entities.Presenza;
import org.hibernate.Session;
import utility.exceptions.ObjectNotFoundException;

import java.time.LocalDate;
import java.util.List;

public class PresenzaDAO
{
	private Session session;

	public PresenzaDAO(Session session)
	{
		this.session = session;
	}

	public Presenza findById(Long id)
	{
		session.beginTransaction();
		Presenza res = session.get(Presenza.class,id);
		session.getTransaction().commit();
		return res;
	}

	public List<Presenza> findAll()
	{
		session.beginTransaction();
		List<Presenza> res = session.createQuery("SELECT p FROM Presenza p", Presenza.class).getResultList();
//		List<Presenza> res = session.createNamedQuery("findAll", Presenza.class).getResultList();
		session.getTransaction().commit();
		return  res;
	}

	public List<Presenza> findByGiorno(LocalDate giornoDaCercare)
	{
		session.beginTransaction();
		List<Presenza> res = session
							.createQuery("SELECT p FROM Presenza p WHERE p.giorno = :parametro", Presenza.class)
							.setParameter("parametro",giornoDaCercare)
							.getResultList();
		session.getTransaction().commit();
		return  res;
	}

	//lui fa sia update che insert
	public void save(Presenza p)
	{
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	}

	public void delete(Long id)
	{
		session.beginTransaction();
		Presenza toDelete =findById(id);
		if(toDelete==null)
			throw new ObjectNotFoundException("Non posso cancellare qualcosa che non esiste");

		session.delete(toDelete);
		session.getTransaction().commit();
	}
}
