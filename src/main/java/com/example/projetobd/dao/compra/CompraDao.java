package com.example.projetobd.dao.compra;
import com.example.projetobd.model.compra.CompraModel;
import java.util.List;

public interface CompraDao {
    int save(CompraModel compraModel);
    CompraModel findById(int id);
    List<CompraModel> findall();
}
