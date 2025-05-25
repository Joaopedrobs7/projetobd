package com.example.projetobd.dao.cliente;
import com.example.projetobd.model.cliente.ClienteModel;

import java.util.List;

public interface ClienteDao {
    int save(ClienteModel cliente);

    List<ClienteModel> getAll();

    ClienteModel getById(int numero_conta);
}
