package br.com.encom.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import br.com.encom.domain.Cliente;
import br.com.encom.domain.TipoCliente;
import br.com.encom.repository.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {	  
	
		@Autowired
		public ClienteRepository clienteRepository;

		@RequestMapping("/novo")
		public ModelAndView novo() {
			ModelAndView mv= new ModelAndView("CadCliente");
			mv.addObject(new Cliente());
			return  mv;
		}
		
		@RequestMapping(method = RequestMethod.POST)
		public ModelAndView salvar(@Validated Cliente cliente, Errors errors) {
			ModelAndView mv= new ModelAndView("CadCliente");
			if(errors.hasErrors()) {
				mv.addObject("mensagem", "Erro ao salvar cliente, confira os dados.");
				return mv;
			}
			
			clienteRepository.save(cliente);
			
			mv.addObject("mensagem", "Cliente Salvo com Sucesso!!!");
			return mv;
		}
		
		@RequestMapping
		public ModelAndView pesquisar() {
			
			List<Cliente> todosClientes = clienteRepository.findAll();
			ModelAndView mv = new ModelAndView("PesquisaCliente");
			mv.addObject("clientes",  todosClientes);
			return mv;
		}
		
		@ModelAttribute("todostipos")
		public List<TipoCliente> todosTipos(){
			return Arrays.asList(TipoCliente.values());
		}
		
		
		
}
