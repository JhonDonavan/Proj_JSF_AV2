package dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="produto")
public class Produto implements IdSequencial, Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "PRODUTO_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "PRODUTO_ID", sequenceName = "SEQ_PRODUTO", allocationSize = 1)
	private Long id;
	
	@Column(name="nome")
	private String nomeProduto;
	
	@Column(name="marca")
	private String marcaProduto;
	
	
	@Column(name="dataFabricacao")
	@Temporal(TemporalType.DATE)
	private Date dataFabricacao;
	
	
	@Column(name="dataVencimento")
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	@Column(name="Quantidade_Estoque")
	private int qtdEstoque;
	
	@Column(name="preco")
	private double precoProduto;
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nomeProduto=" + nomeProduto + ", marcaProduto=" + marcaProduto
				+ ", dataFabricacao=" + dataFabricacao + ", dataVencimento=" + dataVencimento + ", qtdEstoque="
				+ qtdEstoque + ", precoProduto=" + precoProduto + ", descricao=" + descricao + "]";
	}

	

	
	
	
	
}
