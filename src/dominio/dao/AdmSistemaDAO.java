package dominio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import controle.util.JpaDAO;
import dominio.AdmSistema;

public class AdmSistemaDAO extends JpaDAO<AdmSistema>
{

	public AdmSistemaDAO()
	{
		super();
	}

	public AdmSistemaDAO(EntityManager manager)
	{
		super(manager);
	}
	
	
	public boolean verificarLogin(String login, String senha) throws SQLException{
		
		Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","postgres");
		boolean aut = false;
		String verificar = "select login,senha from AdmSistema where login=? and senha=?";
		
		try{
			PreparedStatement stm = conexao.prepareStatement(verificar);
			stm.setString(1, login);
			stm.setString(2, senha);
			ResultSet rs;
			rs = stm.executeQuery();
			if(rs.next()){
				String loginbanco = rs.getString("login");
				String senhabanco = rs.getString("senha");
				aut = true;
				return aut;
			}
			
			
			rs.close();
			
		}catch(SQLException erro ){
			System.out.println("Erro ao recuperar login e senha" + erro.getMessage());
			
		}
		return aut;
		
		
	}


	
	public AdmSistema lerPorLogin(String login){
		AdmSistema resultado;

		Query consulta = this.getEntityManager().createQuery("from AdmSistema u where u.login = :login");
		consulta.setParameter("login", login);

		try
		{
			resultado = (AdmSistema) consulta.getSingleResult();
		}
		catch (NoResultException e)
		{
			resultado = null;
		}
			System.out.println(resultado.toString());
		return resultado;
	}
	
	
}
	
