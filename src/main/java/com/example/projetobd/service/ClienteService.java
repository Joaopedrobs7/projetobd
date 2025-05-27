package com.example.projetobd.service;

import com.example.projetobd.dao.cliente.ClienteDao;
import com.example.projetobd.dao.usuario.usuarioDao;
import com.example.projetobd.exception.FalhaDeIntegridade;
import com.example.projetobd.exception.RecursoNaoEncontradoException;
import com.example.projetobd.model.cliente.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteDao cDao;

    @Autowired
    private usuarioDao usuario;


    public List<ClienteModel> listarClientes(){
        return cDao.getAll();

    }

    public ClienteModel buscarCliente(int id){
        try {
            return cDao.getById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new RecursoNaoEncontradoException("Cliente Nao Existe");
        }
    }


    public boolean InserirCliente(ClienteModel cliente){
        try{
            if(usuario.getByCpf(cliente.getUsuario_cpf()) != null) {
                cDao.save(cliente);
                return true;
            }
            else{
                return false;
            }
        }
        catch(EmptyResultDataAccessException e){
            throw new RecursoNaoEncontradoException("CPF nao existe");
        }
        catch (DuplicateKeyException e){
            throw new FalhaDeIntegridade("CPF em uso");
        }
    }
}
