package br.org.serratec.backend.controller;

import java.net.URI;
import java.util.List;

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

import br.org.serratec.backend.dto.ClienteDTO;
import br.org.serratec.backend.model.Cliente;
import br.org.serratec.backend.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	@ApiOperation(value = "Listar todos os clientes", notes = "Listagem de clientes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os clientes"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado") })
	public ResponseEntity<List<ClienteDTO>> listar() {
		List<ClienteDTO> clientes = clienteService.listarCliente();
		return ResponseEntity.ok(clientes);
	}

	@PostMapping
	@ApiOperation(value = "Inserir cliente", notes = "Inserção de cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente inserido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado") })
	public ResponseEntity<Object> inserir(@Valid @RequestBody Cliente cliente) {

		Cliente c = clienteService.inserir(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getId()).toUri();
		return ResponseEntity.created(uri).body(c);
	}

	@PutMapping("{id}")
	@ApiOperation(value = "Atualizar cliente", notes = "Atualização de cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cliente atualizado"),
			@ApiResponse(code = 201, message = "Cliente inserido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado") })
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		if (!clienteService.atualizar(id, cliente)) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(null);
		}
	}

	@DeleteMapping("{id}")
	@ApiOperation(value = "Excluir cliente", notes = "Exclusão de cliente")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Cliente excluido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado") })
	public ResponseEntity<Void> deletar(@PathVariable Long id) {

		if (!clienteService.remover(id)) {
			return ResponseEntity.notFound().build();

		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
