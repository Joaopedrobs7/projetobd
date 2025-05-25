package com.example.projetobd.dao.artesao;
import com.example.projetobd.model.artesao.ArtesaoModel;

import java.util.List;

public interface ArtesaoDao {
    int save(ArtesaoModel artesaoModel);

    List<ArtesaoModel> getAll();

    ArtesaoModel getById(int numero_conta);
}
