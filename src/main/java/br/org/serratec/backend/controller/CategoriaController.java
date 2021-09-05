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

import br.org.serratec.backend.model.Categoria;
import br.org.serratec.backend.service.CategoriaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	@ApiOperation(value = "Listar todas as categorias", notes = "Listagem de Categorias")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna todas as categorias"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado")})
	public ResponseEntity<List<Categoria>> listar() {
		List<Categoria> categorias = categoriaService.listar();
		return ResponseEntity.ok(categorias);
	}

	@GetMapping("{nome}")
	@ApiOperation(value = "Buscar categoria por nome", notes = "Categoria buscada")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna categoria buscada"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado")})
	public ResponseEntity<Categoria> buscarPorNome(@PathVariable String nome) {
		Categoria categoria = categoriaService.listarNome(nome);
		return ResponseEntity.ok(categoria);
	}

	@PostMapping
	@ApiOperation(value = "Inserir categoria", notes = "Inserção de categoria")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Categoria inserida"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado")})
	public ResponseEntity<Categoria> inserir(@Valid @RequestBody Categoria categoria) {
		Categoria c = categoriaService.inserir(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getId()).toUri();
		return ResponseEntity.created(uri).body(c);

	}

	@PutMapping("{id}")
	@ApiOperation(value = "Atualizar categoria", notes = "Atualização de categoria")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Categoria atualizada"),
			@ApiResponse(code = 201, message = "Categoria inserida"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado")})
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody Categoria categoria) {
		if (!categoriaService.atualizar(id, categoria)) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(null);
		}
	}

	@DeleteMapping("{id}")
	@ApiOperation(value = "Excluir categoria", notes = "Exclusão de categoria")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Categoria excluida"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado")})
	public ResponseEntity<Void> deletar(@PathVariable Long id) {

		if (!categoriaService.deletar(id)) {
			return ResponseEntity.notFound().build();

		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
