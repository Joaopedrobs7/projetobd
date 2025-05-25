package com.example.projetobd.model.cliente;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteModel {
    private int numero_conta;
    private String usuario_cpf;
}
