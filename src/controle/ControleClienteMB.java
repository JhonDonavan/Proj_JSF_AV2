package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import controle.util.JSFUtil;
import dominio.Cliente;
import dominio.dao.ClienteDAO;

@ManagedBean(name = "controleClienteMB")
@RequestScoped
public class ControleClienteMB {

	Cliente cliente = new Cliente();
	ClienteDAO clienteDAO = new ClienteDAO();

	private List<Cliente> clientes = null;

	public List<Cliente> getClientes() {
		if (this.clientes == null) {
			this.clientes = this.clienteDAO.lerTodos();
		}
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public String RetornarPagina(String Retornar) {
		return "controlePromocao.jsf";
	}

	public String cadastrarCliente() {

		cliente.getCpf();
		cliente.getEmail();
		cliente.getNome();
		cliente.getTelefone();
		
		
		
		clienteDAO.salvar(this.cliente);

		return "listarClientes.jsf";
	}

	public String alterarCliente() {
		Long id = JSFUtil.getParametroLong("itemId");
		Cliente altpr = this.clienteDAO.lerPorId(id);
		this.setCliente(altpr);
		this.clienteDAO.salvar(altpr);

		return "editarCliente.jsf";
	}

	public String acaoExcluir() {
		long id = JSFUtil.getParametroLong("itemId");
		Cliente clienteDoBanco = this.clienteDAO.lerPorId(id);
		clienteDAO.excluir(clienteDoBanco);

		this.setCliente(new Cliente());
		this.cliente = null;

		return "listarClientes.jsf";

	}

	public String salvarCliente() {

		// Sempre limpar o ID com o valor zero, pois o JSF converte o campo
		// vazio para LONG =0
		if ((this.getCliente().getId() != null) && (this.getCliente().getId().longValue() == 0))
			this.getCliente().setId(null);

		this.clienteDAO.salvar(this.getCliente());
		this.cliente = null;
		this.setCliente(new Cliente());

		return "listarPromocao.jsf";
	}

}
