package br.org.serratec.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.backend.dto.ProdutoDTO;
import br.org.serratec.backend.model.Produto;
import br.org.serratec.backend.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public List<ProdutoDTO> listar() {
		List<ProdutoDTO> produtoDTOs = new ArrayList<ProdutoDTO>();
		List<Produto> produtos = produtoRepository.findAll();
		for (Produto produto : produtos) {
			ProdutoDTO dto = new ProdutoDTO(produto);
			produtoDTOs.add(dto);
		}
		return produtoDTOs;
	}

	public ProdutoDTO buscar(String nome) {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		Produto produto = produtoRepository.findByNome(nome);
		produtoDTO.setId(produto.getId());
		produtoDTO.setNome(produto.getNome());
		produtoDTO.setDescricao(produto.getDescricao());
		produtoDTO.setQtd_estoque(produto.getQtd_estoque());
		produtoDTO.setValorUnitario(produto.getValorUnitario());
		produtoDTO.setCategoria(produto.getCategoria());
		produtoDTO.setUrlImagem(produto.getUrlImagem());
		return produtoDTO;
	}

	public Produto inserir(Produto produto) {
		return produtoRepository.save(produto);

	}

	public boolean atualizar(Long id, Produto produto) {
		if (!produtoRepository.existsById(id)) {
			return false;
		} else {
			produto.setId(id);
			produto = produtoRepository.save(produto);
			return true;
		}
	}

	public boolean deletar(Long id) {
		if (!produtoRepository.existsById(id)) {
			return false;
		} else {
			produtoRepository.deleteById(id);
			return true;
		}
	}
}
