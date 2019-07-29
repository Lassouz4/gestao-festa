package com.algaworks.festa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.festa.exception.ConvidadoException;
import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.service.ConvidadoService;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {

	@Autowired
	private ConvidadoService convidados;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
	
		modelAndView.addObject("convidado", new Convidado());
		modelAndView.addObject("ListaConvidado", convidados.findAll());
		return modelAndView;
	}

	@PostMapping
	public ModelAndView salvar(Convidado convidado) {
		ModelAndView mv = new ModelAndView("ListaConvidados");
		mv.addObject("convidado", convidado);
		mv.addObject("ListaConvidado", convidados.findAll());
		
		try {
			this.convidados.salvar(convidado);
		}catch(ConvidadoException ce) {
			return this.listar().addObject("msgErroAdd", ce.getMessage() );
		}
		return this.listar().addObject("msgSucessoAdd", "Convidado salvo.");
	}

}
