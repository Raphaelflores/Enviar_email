package com.teste.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.teste.primeiroexemplo.model.Produto;

@Repository
public class ProdutoRepository {
    
    private ArrayList<Produto> produtos = new ArrayList<Produto>(); 
    private Integer ultimoId = 0;

    /**
     * Metodo para retornar uma Lista de produtos.
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos(){
        return produtos;
    }
/**
 * Metodo que retorna o produto encontrado pelo seu id
 * @param l do produto que será localizado.
 * @return retorna um produto caso seja encontrado.
 */
    public Optional<Produto> obterPorId(long l){
        return produtos.stream().filter(produto -> produto.getId() == l)
            .findFirst();
    }

    /**
     * Metodo para adicionar produto na lista.
     * @param produto que sera adicionado.
     * @return retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto){
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

    /**
     * Metodo para deletar o produto por id.
     * @param l do produto a ser deletado.
     */
    public void deletar(long l){
        produtos.removeIf(produto -> produto.getId() == l);
    }
/**
 * Metodo para atualizar o produto na lista.
 * @param produto prioduto que sera atualizado.
 * @return retorna o produto apois atulizar a lista.
 */
    public Produto atualizar(Produto produto){
       Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        
       if (produtoEncontrado.isEmpty()){
        throw new InputMismatchException("Produto não encontrado");
       } 
       deletar(produto.getId());


       produtos.add(produto);

       return produto;
    }
}
