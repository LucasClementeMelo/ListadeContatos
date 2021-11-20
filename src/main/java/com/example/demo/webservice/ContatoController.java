package com.example.demo.webservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Contato;
import com.example.demo.repository.ContatoRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin(origins="*")
public class ContatoController {

	@Autowired
	ContatoRepository contatoRepository;
	
	@GetMapping("/contatos")
	public List<Contato> getAllContatos() {
		return contatoRepository.findAll();
	}
	
	@PostMapping("/contatos")
	public Contato saveContato(@RequestBody Contato contato){
		return contatoRepository.save(contato);
	}
	
	@PutMapping("/contatos/{id}")
	public ResponseEntity<Object> updateContato(@PathVariable int id, @RequestBody Contato contato){
		Optional<Contato> contatoOptional = contatoRepository.findById(id);
		if(!contatoOptional.isPresent())
			return ResponseEntity.notFound().build();
		contato.setId(id);
		contatoRepository.save(contato);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/contatos/{id}")
	public Optional<Contato> showContato(@PathVariable int id) {
		return contatoRepository.findById(id);
	}
	
	@DeleteMapping("/contatos/{id}")
	public ResponseEntity<Object> deleteContatoById(@PathVariable int id) {
		contatoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
