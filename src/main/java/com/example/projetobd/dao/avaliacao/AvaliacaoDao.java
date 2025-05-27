package com.example.projetobd.dao.avaliacao;
import com.example.projetobd.model.avaliacao.AvaliacaoModel;

import java.util.List;

public interface AvaliacaoDao {
    public int save(AvaliacaoModel avaliacaoModel);//vamo so salvar memo
    public AvaliacaoModel findById(int avaliacao_id);
    public List<AvaliacaoModel> findall();
}
