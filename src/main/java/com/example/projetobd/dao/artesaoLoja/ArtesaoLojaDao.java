package com.example.projetobd.dao.artesaoLoja;

import com.example.projetobd.model.artesaoLoja.ArtesaoLojaModel;

import java.util.List;

public interface ArtesaoLojaDao {
    int save(ArtesaoLojaModel lojaModel);

    int delete(int id);

    int update(int id,ArtesaoLojaModel artesao);

    ArtesaoLojaModel findById(int id);

    List<ArtesaoLojaModel> findall();
}
