package br.org.serratec.backend.dto;

import br.org.serratec.backend.model.ItemPedido;

public class NotaFiscalDTO {
	private Long id;
	private Integer quantidade;
	private Double precoVenda;
	private String nomeProduto;
	private Double valorUnitario;

	public NotaFiscalDTO() {
		// TODO Auto-generated constructor stub
	}

	public NotaFiscalDTO(ItemPedido itemPedido) {
		super();
		this.id = itemPedido.getId();
		this.quantidade = itemPedido.getQuantidade();
		this.precoVenda = itemPedido.getPrecoVenda();
		this.valorUnitario = itemPedido.getProduto().getValorUnitario();
		this.nomeProduto = itemPedido.getProduto().getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	/*public Double calcPrecoVenda() {
		return precoVenda = quantidade * valorUnitario;
	}*/
}
