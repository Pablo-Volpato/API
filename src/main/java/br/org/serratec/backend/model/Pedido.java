package br.org.serratec.backend.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long id;
	@NotBlank(message = "O campo status não pode estar nulo")
	@Size(message = "Limite de caracteres do status ultrpassado")
	private String status;
	@Column(name = "data_pedido")
	@Past(message = "Data inválida")
	private LocalDate dataPedido;
	@Past(message = "Data inválida")
	@Column(name = "data_entrega")
	private LocalDate dataEntrega;
	@Past(message = "Data inválida")
	@Column(name = "data_envio")
	private LocalDate dataEnvio;
	@Transient
	private Double valorTotal;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@JsonManagedReference
	@OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ItemPedido> itemPedidos;

	public Pedido() {
		this.itemPedidos = new ArrayList<ItemPedido>();
		this.valorTotal = new Double(0);

	}

	public Pedido(Long id, String status, LocalDate dataPedido, LocalDate dataEntrega, LocalDate dataEnvio,
			Cliente cliente, List<ItemPedido> itemPedidos) {
		super();
		this.id = id;
		this.status = status;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.cliente = cliente;
		this.itemPedidos = new ArrayList<ItemPedido>();
		this.valorTotal = new Double(0);
	}

	@Override
	public String toString() {
		return "Pedido [dataEntrega=" + dataEntrega + ", dataEnvio=" + dataEnvio + ", valorTotal=" + valorTotal + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void CalcValorTotal() {
		for (ItemPedido itemPedido : itemPedidos) {
			valorTotal += itemPedido.getSubValor();
		}
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
