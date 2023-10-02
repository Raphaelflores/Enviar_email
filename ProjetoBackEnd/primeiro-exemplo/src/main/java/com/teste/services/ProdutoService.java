package com.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.model.Produto;
import com.teste.repository.ProdutoRepositoryOld;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepositoryOld produtoRepository;

    /**
     * Metodo para retornar uma Lista de produtos.
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos(){
        return produtoRepository.obterTodos();
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu id
     * @param l do produto que será localizado.
     * @return retorna um produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(int id){
        return produtoRepository.obterPorId(id);
    }

    /**
     * Metodo para adicionar produto na lista.
     * @param produto que sera adicionado.
     * @return retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto){
        return produtoRepository.adicionar(produto);
    }

    /**
     * Metodo para deletar o produto por id.
     * @param id do produto a ser deletado.
     */
    public void deletar(long id){
        produtoRepository.deletar(id);
    }

    /**
     * Metodo para atualizar o produto na lista.
     * @param produto prioduto que sera atualizado.
     * @param id do produto.
     * @return retorna o produto apois atulizar a lista.
     */
    public Produto atualizar(int id,Produto produto){
        produto.setId(id);
        return produtoRepository.atualizar(produto);
    }
}
