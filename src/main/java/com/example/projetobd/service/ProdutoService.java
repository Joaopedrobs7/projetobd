package com.example.projetobd.service;

import com.example.projetobd.dao.produto.produtoDao;
import com.example.projetobd.exception.RecursoNaoEncontradoException;
import com.example.projetobd.model.produto.produtoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private produtoDao pDao;

    public List<produtoModel> listarProdutos(){
        return pDao.getAll();

    }

    public produtoModel buscarProduto(int cod)
    {
        try{
            return pDao.getById(cod);
        }
        catch(EmptyResultDataAccessException e) {
            throw new RecursoNaoEncontradoException("Produto Nao existe");
        }

    }


    public Boolean inserirProduto(produtoModel produto){
        if (pDao.save(produto) == 1){
            return true;
        }
        else{
            return false;
        }
    }


    public Boolean deletarProduto(int cod){
        if (pDao.delete(cod) == 1){
            return true;
        }
        return false;
    }


    public Boolean atualizarProduto(produtoModel produto,int cod){
        if(pDao.update(produto,cod) == 1){
            return true;
        }
        return false;
    }



}
