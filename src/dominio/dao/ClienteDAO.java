package dominio.dao;

import javax.persistence.EntityManager;

import controle.util.JpaDAO;
import dominio.Cliente;

public class ClienteDAO extends JpaDAO<Cliente>
{

	public ClienteDAO()
	{
		super();
	}

	public ClienteDAO(EntityManager manager)
	{
		super(manager);
	}

}
