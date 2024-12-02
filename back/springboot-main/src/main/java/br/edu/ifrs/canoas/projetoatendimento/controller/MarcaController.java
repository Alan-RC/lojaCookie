package br.edu.ifrs.canoas.projetoatendimento.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.canoas.projetoatendimento.model.Marca;
import br.edu.ifrs.canoas.projetoatendimento.model.MarcaRepository;

@RestController
public class MarcaController {

    @Autowired
    private MarcaRepository repository;

    @PostMapping("/marca")
    public Marca inserir(Marca marca) {
        //marca.setId(null); Forçar a inserssão sem atualizar
        repository.save(marca);
        
        return marca;
    }

    @GetMapping("/marca/{id}")
    public Marca getOne(@PathVariable long id) {
        return repository.findById(id).get();
    }


    @GetMapping("/marcas/nome")
    public List<Marca> todos() {
        return (List<Marca>) repository.findAll();
    }

    @DeleteMapping("/marca/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }


    
    
    
}

