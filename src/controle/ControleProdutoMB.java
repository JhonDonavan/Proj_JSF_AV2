package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import controle.util.JSFUtil;
import dominio.AdmSistema;
import dominio.Produto;
import dominio.dao.AdmSistemaDAO;
import dominio.dao.ProdutoDAO;

@ManagedBean(name = "controleProdutoMB")
@RequestScoped
public class ControleProdutoMB {

	Produto produto = new Produto();
	AdmSistema adm = new AdmSistema();

	ProdutoDAO produtoDAO = new ProdutoDAO();
	AdmSistemaDAO admDAO = new AdmSistemaDAO();

	private List<Produto> produtos = null;

	public List<Produto> getProdutos() {
		if (this.produtos == null) {
			this.produtos = this.produtoDAO.lerTodos();
		}
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public AdmSistema getAdm() {
		return adm;
	}

	public void setAdm(AdmSistema adm) {
		this.adm = adm;
	}

	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

	public AdmSistemaDAO getAdmDAO() {
		return admDAO;
	}

	public void setAdmDAO(AdmSistemaDAO admDAO) {
		this.admDAO = admDAO;
	}

	public String cadastrarProduto() {

		produto.getNomeProduto();
		produto.getMarcaProduto();
		produto.getPrecoProduto();
		produto.getQtdEstoque();
		produto.getDescricao();
		produto.getDataFabricacao();
		produto.getDataVencimento();
		produtoDAO.abrirTransacao();
		produtoDAO.salvar(this.produto);
		produtoDAO.gravarTransacao();

		return "listarProdutos.jsf";
	}

	public String alterarProduto() {
		Long id = JSFUtil.getParametroLong("itemId");
		Produto altprod = this.produtoDAO.lerPorId(id);
		this.setProduto(altprod);
		this.produtoDAO.salvar(altprod);

		return "editarProdutos.jsf";
	}

	public String acaoExcluir() {
		long id = JSFUtil.getParametroLong("itemId");
		Produto produtoDoBanco = this.produtoDAO.lerPorId(id);
		produtoDAO.excluir(produtoDoBanco);

		this.setProduto(new Produto());
		this.produto = null;

		return "listarProdutos.jsf";

	}

	public String salvarProduto() {

		// Sempre limpar o ID com o valor zero, pois o JSF converte o campo
		// vazio para LONG =0
		if ((this.getProduto().getId() != null) && (this.getProduto().getId().longValue() == 0))
			this.getProduto().setId(null);

		this.produtoDAO.salvar(this.getProduto());
		this.produto = null;
		this.setProduto(new Produto());

		return "listarProdutos.jsf";
	}

}
