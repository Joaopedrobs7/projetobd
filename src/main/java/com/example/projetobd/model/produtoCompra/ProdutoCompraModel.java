package com.example.projetobd.model.produtoCompra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProdutoCompraModel {
    private int num_compra;
    private int cod_produto;
    private int qtd;
}
