package com.example.projetobd.model.artesaoLoja;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtesaoLojaModel {
    private int id;
    private String habilidades;
    private String especialidade;
    private int avaliacao;
    private int artesao_conta;
}
