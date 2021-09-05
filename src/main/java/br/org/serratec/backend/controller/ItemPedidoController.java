package br.org.serratec.backend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.backend.dto.ItemPedidoDTO;
import br.org.serratec.backend.model.ItemPedido;
import br.org.serratec.backend.service.ItemPedidoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/itens")
public class ItemPedidoController {

	@Autowired
	private ItemPedidoService itemPedidoService;

	@GetMapping
	@ApiOperation(value = "Listar todos os item pedidos", notes = "Listagem de item pedidos")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna todos os item pedidos"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado")})
	public ResponseEntity<List<ItemPedidoDTO>> listar() {
		List<ItemPedidoDTO> itemPedidoDTOs = itemPedidoService.listar();
		return ResponseEntity.ok(itemPedidoDTOs);
	}
	
	@GetMapping("{id}")
	@ApiOperation(value = "Listar um item pedido", notes = "Listagem de item pedidos")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna um item pedidos"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado")})
	public ResponseEntity<Optional<ItemPedidoDTO>> buscarPorId(@PathVariable Long id){
		Optional<ItemPedidoDTO> itemPedido = itemPedidoService.buscarItemPedidoId(id);
		return ResponseEntity.ok(itemPedido);
	}

	@PostMapping
	@ApiOperation(value = "Inserir item pedido", notes = "Inserção de item pedido")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Item pedido inserido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado")})
	public ResponseEntity<Object> inserir(@RequestBody ItemPedido itemPedido ) {
		ItemPedido i = itemPedidoService.inserir(itemPedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(i.getId()).toUri();
		return ResponseEntity.created(uri).body(i);

	}
	
	@DeleteMapping("{id}")
	public ResponseEntity< Void> remover(@PathVariable Long id) {
		if (!itemPedidoService.deletar(id)) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
