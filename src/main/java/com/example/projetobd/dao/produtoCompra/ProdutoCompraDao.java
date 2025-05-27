package com.example.projetobd.dao.produtoCompra;

import com.example.projetobd.model.produtoCompra.ProdutoCompraModel;

import java.util.List;

public interface ProdutoCompraDao {
    int save(ProdutoCompraModel produtoCompraModel);
    List<ProdutoCompraModel> findByCompraId(int compra_id);
    List<ProdutoCompraModel> findall();
}
