package br.org.serratec.backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.backend.dto.ProdutoDTO;
import br.org.serratec.backend.model.Produto;
import br.org.serratec.backend.service.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	@ApiOperation(value = "Listar todos os produtos", notes = "Listagem de produtos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os produtos"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado") })
	public ResponseEntity<List<ProdutoDTO>> listar() {
		List<ProdutoDTO> produtosDTO = produtoService.listar();
		return ResponseEntity.ok(produtosDTO);
	}

	@GetMapping("{nome}")
	@ApiOperation(value = "Buscar produto por nome", notes = "Produto buscado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna produto buscado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado") })
	public ResponseEntity<ProdutoDTO> buscar(@PathVariable String nome) {
		ProdutoDTO produtoDTO = produtoService.buscar(nome);
		return ResponseEntity.ok(produtoDTO);

	}

	@PostMapping
	@ApiOperation(value = "Inserir produto", notes = "Inserção de produto")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Produto inserido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado") })
	@ResponseStatus(HttpStatus.CREATED)
	public Produto inserir(@RequestBody Produto produto) {
		return produtoService.inserir(produto);
	}

	@PutMapping("{id}")
	@ApiOperation(value = "Atualizar produto", notes = "Atualização de produto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Produto atualizado"),
			@ApiResponse(code = 201, message = "produto inserido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado") })
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
		if (!produtoService.atualizar(id, produto)) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(null);
		}
	}

	@DeleteMapping("{id}")
	@ApiOperation(value = "Excluir produto", notes = "Exclusão de produto")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Produto excluido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Apague o itemPedido referente a chaveEstrangeira primeiro") })
	public ResponseEntity<Void> deletar(@PathVariable Long id) {

		if (!produtoService.deletar(id)) {
			return ResponseEntity.notFound().build();

		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
