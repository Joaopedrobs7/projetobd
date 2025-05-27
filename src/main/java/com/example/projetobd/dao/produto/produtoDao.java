package com.example.projetobd.dao.produto;


import com.example.projetobd.model.produto.produtoModel;

import java.util.List;

public interface produtoDao {

    int save(produtoModel produto);

    int update(produtoModel produto,int cod);

    int delete(int cod);

    List<produtoModel> getAll();

    produtoModel getById(int cod);


}
