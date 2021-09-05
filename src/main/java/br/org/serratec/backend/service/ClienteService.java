package br.org.serratec.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.backend.dto.ClienteDTO;
import br.org.serratec.backend.model.Cliente;
import br.org.serratec.backend.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<ClienteDTO> listarCliente() {
		List<ClienteDTO> clienteDTOs = new ArrayList<ClienteDTO>();
		List<Cliente> clientes = clienteRepository.findAll();
		for (Cliente cliente : clientes) {
			ClienteDTO dto = new ClienteDTO(cliente);
			clienteDTOs.add(dto);
		}
		return clienteDTOs;
	}

	public Optional<ClienteDTO> buscarClienteId(Long id) {
		ClienteDTO clientePedidoDTO = new ClienteDTO();
		Optional<Cliente> cliente = clienteRepository.findById(id);

		clientePedidoDTO.setId(cliente.get().getId());
		clientePedidoDTO.setNomeCompleto(cliente.get().getNomeCompleto());
		clientePedidoDTO.setNomeUsuario(cliente.get().getNomeUsuario());
		clientePedidoDTO.setDataNascimento(cliente.get().getDataNascimento());
		clientePedidoDTO.setEmail(cliente.get().getEmail());
		clientePedidoDTO.setSenha(cliente.get().getSenha());
		clientePedidoDTO.setCpf(cliente.get().getCpf());
		clientePedidoDTO.setEndereco(cliente.get().getEndereco());
		clientePedidoDTO.setTelefone(cliente.get().getTelefone());

		return Optional.ofNullable(clientePedidoDTO);

	}

	public Cliente inserir(Cliente cliente)  {
			cliente.setId(cliente.getId());
			cliente.setNomeUsuario(cliente.getNomeUsuario());
			cliente.setSenha(cliente.getSenha());
			clienteRepository.save(cliente);
			return cliente;
		}

	public boolean atualizar(Long id, Cliente cliente) {
		if (!clienteRepository.existsById(id)) {
			return false;
		} else {
			cliente.setId(id);
			cliente = clienteRepository.save(cliente);
			return true;
		}
	}

	public boolean remover(Long id) {
		if (!clienteRepository.existsById(id)) {
			return false;
		} else {
			clienteRepository.deleteById(id);
			return true;
		}
	}
}
