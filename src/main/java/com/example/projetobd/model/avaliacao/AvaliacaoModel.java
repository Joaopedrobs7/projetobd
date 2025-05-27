package com.example.projetobd.model.avaliacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoModel {
    private int id;
    private int nota;
    private String titulo;
    private String descricao;
    private LocalDateTime data_avaliacao;
    private int num_compra;
}
