package com.example.projetobd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class produtoModel {

    private int loja_id;
    private String nome;
    private int preco;
    private String foto;
    private int estoque;
    private int cod;
}
