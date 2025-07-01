package cep.cep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cep.cep.client.ViaCepClient;
import cep.cep.dto.Endereco;

@Service
public class ViaCepService {
    @Autowired
    private ViaCepClient viaCepClient;

    public Endereco buscarPorCep(String cep) {
        return viaCepClient.consultarCep(cep);
    }

}
