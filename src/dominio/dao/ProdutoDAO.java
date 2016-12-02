package dominio.dao;

import javax.persistence.EntityManager;

import controle.util.JpaDAO;
import dominio.Produto;

public class ProdutoDAO extends JpaDAO<Produto>
{

	public ProdutoDAO()
	{
		super();
	}

	public ProdutoDAO(EntityManager manager)
	{
		super(manager);
	}

}
