package br.edu.ifrs.canoas.projetoatendimento.controller;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.canoas.projetoatendimento.model.Categoria;


@RestController
@CrossOrigin(origins="*")//resolve problema de CORS(libera tudo)
public class CategoriaController {
    @PostMapping("/categoria")
    public Categoria criarCategoria(Categoria categoria){
        categoria.create();
        return categoria;
    }
    
    @PutMapping("/categoria")
    public Categoria atualizarProduto(Categoria categoria) {
        categoria.update();
        return categoria;
    }

    @DeleteMapping("/categoria")
    public void deletarCategoria(Categoria categoria) {
        categoria.delete();

    }

    @GetMapping("/categoria")
    public ArrayList<Categoria> listarCategoria() {
        return Categoria.getAll();
    }

    @GetMapping("/categoria/{id}")
    public Categoria buscarCategoria(@PathVariable int id) {
        Categoria categoria = new Categoria();
        categoria.setId(id);
        categoria.load();
        return categoria;
    }
}
