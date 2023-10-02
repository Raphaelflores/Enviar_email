package com.teste.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.model.Produto;
import com.teste.services.ProdutoService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "obterTodos")
    public List<Produto> obterTodos(){
        return produtoService.obterTodos();
    }

    
    @GetMapping("/{id}")
    public Optional<Produto> obterPorId(@PathVariable int id){
        return produtoService.obterPorId(id);
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        return produtoService.adicionar(produto);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable int id){
        produtoService.deletar(id);
            return "Produto com id " + id + " foi deletado com sucesso";
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable int id, @RequestBody Produto produto) {
        return produtoService.atualizar(id, produto);
    }
}
