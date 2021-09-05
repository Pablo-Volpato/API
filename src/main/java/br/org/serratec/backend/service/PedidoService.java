package br.org.serratec.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.backend.dto.PedidoDTO;
import br.org.serratec.backend.model.Pedido;
import br.org.serratec.backend.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<PedidoDTO> listar(){
		List<PedidoDTO> pedidoDTOs = new ArrayList<PedidoDTO>();
		List<Pedido> pedidos = pedidoRepository.findAll();
		for (Pedido pedido : pedidos) {
				pedido.CalcValorTotal();
				PedidoDTO dto = new PedidoDTO(pedido);
				pedidoDTOs.add(dto);
			}
		return pedidoDTOs;
	}
	
	public Optional<Pedido> listarPorId(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		return pedido;
	}
	
	public Pedido inserir(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public boolean atualizar(Long id, Pedido pedido) {
		if (!pedidoRepository.existsById(id)) {
			return false;
		} else {
			pedido.setId(id);
			pedido = pedidoRepository.save(pedido);
			return true;
		}
	}
	
	public boolean deletar(Long id) {
		if (!pedidoRepository.existsById(id)) {
			return false;
		}else {
			pedidoRepository.deleteById(id);
			return true;
		}
	}
	
}
