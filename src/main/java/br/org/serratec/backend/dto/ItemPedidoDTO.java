package br.org.serratec.backend.dto;

import br.org.serratec.backend.model.ItemPedido;

public class ItemPedidoDTO {
	private Long id;
	private Long idPedido;
	private Long idProduto;
	private String nomeProduto;
	private Integer quantidade;
	private Double precoVenda;
	private Double subValor;

	public ItemPedidoDTO() {
		// TODO Auto-generated constructor stub
	}

	public ItemPedidoDTO(ItemPedido itemPedido) {
		super();
		this.id = itemPedido.getId();
		this.idProduto = itemPedido.getProduto().getId();
		this.idPedido = itemPedido.getPedido().getId();
		this.nomeProduto = itemPedido.getProduto().getNome();
		this.quantidade = itemPedido.getQuantidade();
		this.precoVenda = itemPedido.getPrecoVenda();
		this.subValor = itemPedido.getSubValor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Double getSubValor() {
		return subValor;
	}

	public void setSubValor(Double subValor) {
		this.subValor = subValor;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

}
