package testeBanco;

import dominio.AdmSistema;
import dominio.dao.AdmSistemaDAO;

public class TesteBanco {

	public static void main(String[] args) {
	AdmSistema as =  new AdmSistema();
	AdmSistemaDAO dao = new AdmSistemaDAO();
	
	as.setLogin("admin");
	as.setNome("Administrador");
	as.setSenha("admin");
	as.setSenha2("admin");
	
	dao.abrirTransacao();
	dao.salvar(as);
	dao.gravarTransacao();
	
	System.out.println("Usuario "+as.getNome()+" cadastrado com sucesso");

	}

}
