package controle;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controle.util.JSFUtil;
import dominio.AdmSistema;
import dominio.dao.AdmSistemaDAO;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB {

	boolean autenticado = false;

	private AdmSistema AdmSistema = new AdmSistema();
	private AdmSistemaDAO admDAO = new AdmSistemaDAO();

	public AdmSistema getAdmSistema() {
		return AdmSistema;
	}

	public void setAdmSistema(AdmSistema admSistema) {
		AdmSistema = admSistema;
	}

	public AdmSistemaDAO getAdmDAO() {
		return admDAO;
	}

	public void setAdmDAO(AdmSistemaDAO admDAO) {
		this.admDAO = admDAO;
	}

	public boolean isAutenticado() {
		return autenticado;
	}

	public String autenticar() throws SQLException {

		admDAO.verificarLogin(AdmSistema.getLogin(), AdmSistema.getSenha());
		return "home.jsf";
	}

	public String acaoAutenticar() {

		AdmSistema admBanco = admDAO.lerPorLogin(this.AdmSistema.getLogin());

		if (admBanco == null) {
			JSFUtil.retornarMensagemErro("Login não encontrado", null, null);
			return "login.xhtml";
		} else if (admBanco.senhaCorreta(AdmSistema.getSenha())) {

			// vai guardar objeto na Sessao
			this.setAdmSistema(admBanco);
			this.autenticado = true;

		} else {
			JSFUtil.retornarMensagemErro("Senha invalida", null, null);
			return "login.xhtml";
		}

		return "home.jsf";
	}

	public String logout() {

		String p = null;

		this.autenticado = false;
		this.AdmSistema.setLogin(p);
		this.AdmSistema.setNome(p);
		this.AdmSistema.setSenha(p);

		return "login.jsf";
	}

}
