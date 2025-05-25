package com.example.projetobd.model.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class usuarioModel {
    private String nome;
    private String cpf;
    private String tel_fixo;
    private String celular;
    private String dt_nascimento;


}
