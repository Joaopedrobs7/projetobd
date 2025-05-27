package com.example.projetobd.model.compra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraModel {
    private int numero_compra;
    private int cliente_conta;
    private String tipo_compra;
    private LocalDateTime data_compra;
    private Integer encomenda_id;
}
