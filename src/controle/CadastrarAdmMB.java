package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dominio.AdmSistema;
import dominio.dao.AdmSistemaDAO;

@ManagedBean(name = "cadastrarAdmMB")
@RequestScoped
public class CadastrarAdmMB {

	private AdmSistema AdmSistema = new AdmSistema();
	private AdmSistemaDAO admDAO = new AdmSistemaDAO();

	public AdmSistema getAdmSistema() {
		return AdmSistema;
	}

	public AdmSistemaDAO getAdmDAO() {
		return admDAO;
	}

	public AdmSistema getAdmSistema(AdmSistema AdmSistema) {
		return AdmSistema;
	}

	public void setAdmSistema(AdmSistema admSistema) {
		AdmSistema = admSistema;
	}

	public AdmSistemaDAO getAdmDAO(AdmSistema AdmSistema) {
		return admDAO;
	}

	public void setAdmDAO(AdmSistemaDAO admDAO) {
		this.admDAO = admDAO;
	}

	public String cadastrarAdm() {

		if (AdmSistema.getSenha().equals(AdmSistema.getSenha2())) {
			admDAO.salvar(AdmSistema);

			return "login.jsf";
		} else {
			return "login.jsf";
		}

	}

}
