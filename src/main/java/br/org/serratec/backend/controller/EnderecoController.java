package br.org.serratec.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.backend.dto.EnderecoDTO;
import br.org.serratec.backend.service.EnderecoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping("{cep}")
	@ApiOperation(value = "Listar todos os enderecos", notes = "Listagem de enderecos")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna todos os enderecos"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado")})
	public ResponseEntity<EnderecoDTO> buscar(@PathVariable String cep){
	 EnderecoDTO enderecoDTO =	enderecoService.buscar(cep);
	 if (enderecoDTO == null) {
		return ResponseEntity.notFound().build();
	}else {
		return ResponseEntity.ok(enderecoDTO);
	}
	}
}