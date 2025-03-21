package prove;

import model.dao.PresenzaDAO;
import org.hibernate.Session;
import utility.HibernateUtil;

public class DaiVai
{
	public static void main(String[] args)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		PresenzaDAO dao = new PresenzaDAO(session);



	}
}
