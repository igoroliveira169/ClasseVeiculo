package com.curso.automovel.services;


import com.curso.automovel.domains.Veiculo;
import com.curso.automovel.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public void initDB(){
        Veiculo veiculo1 = new Veiculo(null,"Nissan Kicks", LocalDate.now(),115000.00, "Ricardo", "12332145600");

    veiculoRepository.save(veiculo1);
    }




}
