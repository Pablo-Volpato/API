package br.org.serratec.backend.dto;

import java.time.LocalDate;

import br.org.serratec.backend.model.Cliente;
import br.org.serratec.backend.model.Endereco;

public class ClienteEmailDTO {
	private Long id;
	private String email;
	private String senha;
	private String cpf;
	private String telefone;
	private LocalDate dataNascimento;
	private Endereco endereco;
	private String nomeCompleto;
	private String nomeUsuario;
	private String produtoNome;
	private LocalDate pedidoEnvio;
	private LocalDate pedidoEntrega;
	private Integer itemPedidoQtd;

	public ClienteEmailDTO() {
		// TODO Auto-generated constructor stub
	}

	public ClienteEmailDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.email = cliente.getEmail();
		this.senha = cliente.getSenha();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
		this.dataNascimento = cliente.getDataNascimento();
		this.endereco = cliente.getEndereco();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.nomeUsuario = cliente.getNomeUsuario();
		this.produtoNome = produtoNome;
		this.pedidoEnvio = pedidoEnvio;
		this.pedidoEntrega = pedidoEntrega;
		this.itemPedidoQtd = itemPedidoQtd;
	}

	@Override
	public String toString() {
		return "ClienteEmailDTO [clienteNome=" + nomeCompleto + ", clienteNomeUsuario=" + nomeUsuario
				+ ", produtoNome=" + produtoNome + ", pedidoEnvio=" + pedidoEnvio + ", pedidoEntrega=" + pedidoEntrega
				+ ", itemPedidoQtd=" + itemPedidoQtd + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getProdutoNome() {
		return produtoNome;
	}

	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}

	public LocalDate getPedidoEnvio() {
		return pedidoEnvio;
	}

	public void setPedidoEnvio(LocalDate pedidoEnvio) {
		this.pedidoEnvio = pedidoEnvio;
	}

	public LocalDate getPedidoEntrega() {
		return pedidoEntrega;
	}

	public void setPedidoEntrega(LocalDate pedidoEntrega) {
		this.pedidoEntrega = pedidoEntrega;
	}

	public Integer getItemPedidoQtd() {
		return itemPedidoQtd;
	}

	public void setItemPedidoQtd(Integer itemPedidoQtd) {
		this.itemPedidoQtd = itemPedidoQtd;
	}

}
