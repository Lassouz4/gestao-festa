package com.algaworks.festa.service;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.festa.exception.ConvidadoException;
import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.model.Convidados.Convidados;
@Service
public class ConvidadoService {

	@Autowired
	private Convidados convidadoRep;
	
	public List<Convidado> findAll(){
		return this.convidadoRep.findAll();
	}
	
	public void salvar(Convidado convidado) throws ConvidadoException {
		convidado.setNome(convidado.getNome().trim());
		if(Strings.isEmpty(convidado.getNome())) {
			throw new ConvidadoException("Insira nome");
		}
		
		this.convidadoRep.save(convidado);
	}
	
	
}
