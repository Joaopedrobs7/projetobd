package com.example.projetobd.service;

import com.example.projetobd.dao.produtoCompra.ProdutoCompraDao;
import com.example.projetobd.exception.RecursoNaoEncontradoException;
import com.example.projetobd.model.produtoCompra.ProdutoCompraModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoCompraService {
    @Autowired
    ProdutoCompraDao pDao;

    public List<ProdutoCompraModel> listarProdutoCompra() {
        return pDao.findall();
    }

    public List<ProdutoCompraModel> buscarProdutosPorCompra(int compra_id) {
        return pDao.findByCompraId(compra_id);
    }

    public boolean inserirProdutoCompra(ProdutoCompraModel produtoCompraModel) {
        try{
            return pDao.save(produtoCompraModel) == 1;
        }
        catch (DataIntegrityViolationException e){
            //throw new RecursoNaoEncontradoException("Compra/Produto Nao existe");
            return false;
        }
    }
}
