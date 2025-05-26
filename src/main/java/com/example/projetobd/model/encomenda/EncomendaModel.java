package com.example.projetobd.model.encomenda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EncomendaModel {
    private int id;
    private String descricao;
    private String imagem_modelo;
    private int artesao_conta;
    private int cliente_conta;
}
