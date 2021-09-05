package br.org.serratec.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.org.serratec.backend.dto.EnderecoDTO;
import br.org.serratec.backend.model.Endereco;
import br.org.serratec.backend.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	
	public EnderecoDTO buscar(String cep) {
		
	Optional<Endereco>optional=Optional.ofNullable(enderecoRepository.findByCep(cep));
		if (optional.isPresent()) {
			return new EnderecoDTO(optional.get());
		}else {
			RestTemplate rs = new RestTemplate();
			String uri = "https://viacep.com.br/ws/"+cep+"/json/";
			Optional<Endereco>optionalViaCep = Optional.ofNullable(rs.getForObject(uri, Endereco.class));
			if(optionalViaCep.get().getCep() != null) {
				String cepSemTraco = optionalViaCep.get().getCep().replaceAll("-", "");
				optionalViaCep.get().setCep(cepSemTraco);
				return inserir(optionalViaCep.get());
			}else {
				return null;
			}
		}
		
	}
	
	public EnderecoDTO inserir(Endereco endereco) {
		return new EnderecoDTO(enderecoRepository.save(endereco));
	}
}