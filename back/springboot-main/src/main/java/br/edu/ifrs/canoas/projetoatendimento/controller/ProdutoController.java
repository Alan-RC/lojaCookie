package br.edu.ifrs.canoas.projetoatendimento.controller;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.canoas.projetoatendimento.model.Produto;

@RestController
@CrossOrigin(origins="*")//resolve problema de CORS(libera tudo)
public class ProdutoController {
    @PostMapping("/produto")
    public Produto criarProduto(Produto produto){
        produto.create();
        return produto;
    }
    
    @PutMapping("/produto")
    public Produto atualizarProduto(Produto produto) {
        produto.update();
        return produto;
    }

    @DeleteMapping("/produto")
    public void deletarProduto(Produto produto) {
        produto.delete();

    }

    @GetMapping("/produtos")
    public ArrayList<Produto> listarProdutos() {
        return Produto.getAll();
    }

    @GetMapping("/produto/{id}")
    public Produto buscarProduto(@PathVariable int id) {
        Produto produto = new Produto();
        produto.setId(id);
        produto.load();
        return produto;
    }
}
