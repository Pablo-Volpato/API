package br.org.serratec.backend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.backend.dto.PedidoDTO;
import br.org.serratec.backend.model.Pedido;
import br.org.serratec.backend.service.PedidoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	@ApiOperation(value = "Listar todos os pedidos", notes = "Listagem de pedidos")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna todos os pedidos"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado")})
	public ResponseEntity<List<PedidoDTO>> listarPedidos () {
		List<PedidoDTO> pedidosDTO = pedidoService.listar();
		return ResponseEntity.ok(pedidosDTO);
	}
	
	@GetMapping("{id}")
	@ApiOperation(value = "Buscar pedido por id", notes = "Pedido buscado")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna pedido buscado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado")})
	public ResponseEntity<Optional<Pedido>> listarPorId(@PathVariable Long id) {
	Optional<Pedido> pedido = pedidoService.listarPorId(id);
	return ResponseEntity.ok(pedido);
	}
	
	@PostMapping
	@ApiOperation(value = "Inserir pedido", notes = "Inserção de pedido")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Pedido inserido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado")})
	public ResponseEntity<Pedido> inserirPedidos(@Valid @RequestBody Pedido pedido) {
		Pedido p = pedidoService.inserir(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(uri).body(p);
	}
	
	@PutMapping("{id}")
	@ApiOperation(value = "Atualizar pedido", notes = "Atualização de pedido")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Pedido atualizado"),
			@ApiResponse(code = 201, message = "Pedido inserido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado")})
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody Pedido pedido) {
		if (!pedidoService.atualizar(id, pedido)) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(null);
		}
	}
	
	
	@DeleteMapping("{id}")
	@ApiOperation(value = "Excluir pedido", notes = "Exclusão de pedido")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Pedido excluido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado")})
	public ResponseEntity< Void> remover(@PathVariable Long id) {
		if (!pedidoService.deletar(id)) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
