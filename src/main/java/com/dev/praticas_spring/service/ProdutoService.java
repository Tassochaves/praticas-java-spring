package com.dev.praticas_spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.praticas_spring.exceptions.RecursoNaoEncontradoExeception;
import com.dev.praticas_spring.model.Produto;
import com.dev.praticas_spring.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoExeception("Produto com ID (" + id + ") não encontrado"));
    }

    public void deletarProduto(Long id){

        if (!produtoRepository.existsById(id)){
            throw new RecursoNaoEncontradoExeception("Produto com ID (" + id + ") não encontrado");
        }
        
        produtoRepository.deleteById(id);
    }
}
