package br.org.serratec.backend.dto;

import java.time.LocalDate;
import java.util.List;

import br.org.serratec.backend.model.Cliente;
import br.org.serratec.backend.model.Endereco;
import br.org.serratec.backend.model.Pedido;

public class ClientePedidoDTO {
	private Long id;
	private String nomeCompleto;
	private String nomeUsuario;
	private String email;
	private String senha;
	private String cpf;
	private String telefone;
	private LocalDate dataNascimento;
	private Endereco endereco;
	private List<Pedido> pedido;

	public ClientePedidoDTO() {
		// TODO Auto-generated constructor stub
	}

	public ClientePedidoDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.nomeUsuario = cliente.getNomeUsuario();
		this.email = cliente.getEmail();
		this.senha = cliente.getSenha();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
		this.dataNascimento = cliente.getDataNascimento();
		this.endereco = cliente.getEndereco();
		//this.pedido = cliente.getPedido();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

}
