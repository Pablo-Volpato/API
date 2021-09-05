package br.org.serratec.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.backend.model.Categoria;
import br.org.serratec.backend.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> listar() {
		List<Categoria> categorias = categoriaRepository.findAll();
		return categorias;
	}

	public Categoria listarNome(String nome) {
		Categoria categoria = categoriaRepository.findByNome(nome);
		return categoria;
	}

	public Categoria inserir(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public boolean atualizar(Long id, Categoria categoria) {
		if (!categoriaRepository.existsById(id)) {
			return false;
		} else {
			categoria.setId(id);
			categoria = categoriaRepository.save(categoria);
			return true;
		}
	}

	public boolean deletar(Long id) {
		if (!categoriaRepository.existsById(id)) {
			return false;
		} else {
			categoriaRepository.deleteById(id);
			return true;
		}
	}

}
