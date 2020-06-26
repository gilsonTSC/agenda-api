package com.gilsontsc.agendaapi.model.api.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gilsontsc.agendaapi.model.entity.Contato;
import com.gilsontsc.agendaapi.model.repository.ContatoRepository;



@RestController
@RequestMapping("api/contatos")
public class ContatoController {

	@Autowired
	private ContatoRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Contato save(@RequestBody Contato contato) {
		return this.repository.save(contato);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		this.repository.deleteById(id);
	}
	
	@GetMapping
	public List<Contato> list(){
		return this.repository.findAll();
	}
	
	@PatchMapping("{id}/favorito")
	public void favorita(@PathVariable Integer id, @RequestBody Boolean favorito) {
		Optional<Contato> contato = this.repository.findById(id);
		contato.ifPresent(c -> {
			c.setFavorito(favorito);
			this.repository.save(c);
		});
	}
	
}