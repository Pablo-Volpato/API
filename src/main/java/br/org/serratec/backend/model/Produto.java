package br.org.serratec.backend.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;
	@NotBlank(message = "O campo nome não pode estar nulo")
	@Size(message = "Limite de caracteres da nome ultrapassado")
	private String nome;
	@NotBlank(message = "O campo descrição não pode estar nulo")
	@Size(message = "Limite de caracteres da descrição ultrapassado")
	private String descricao;
	@NotNull(message = "O campo quantidadeEstoque não pode estar nulo")
	private Double qtd_estoque;
	@Past(message = "Data inválida")
	@Column(name = "data_cadastro")
	private LocalDate dataCadastro;
	@NotNull(message = "O campo valorUnitario não pode estar nulo")
	private Double valorUnitario;
	
	private String urlImagem;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(Long id, String nome, String descricao, Double qtd_estoque, LocalDate dataCadastro,
			Double valorUnitario, String urlImagem, Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.qtd_estoque = qtd_estoque;
		this.dataCadastro = dataCadastro;
		this.valorUnitario = valorUnitario;
		this.urlImagem = urlImagem;
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getQtd_estoque() {
		return qtd_estoque;
	}

	public void setQtd_estoque(Double qtd_estoque) {
		this.qtd_estoque = qtd_estoque;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
