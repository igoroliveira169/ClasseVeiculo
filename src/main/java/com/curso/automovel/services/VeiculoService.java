package com.curso.automovel.services;

import com.curso.automovel.domains.Veiculo;
import com.curso.automovel.domains.dtos.VeiculoDTO;
import com.curso.automovel.repositories.VeiculoRepository;

import com.curso.automovel.services.exceptions.DataIntegrityViolationException;
import com.curso.automovel.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepo;

    public List<VeiculoDTO> findAll(){
        return  veiculoRepo.findAll().stream().map(obj -> new VeiculoDTO(obj)). collect(Collectors.toUnmodifiableList());
    }

    public Veiculo findbyId(Long id){
        Optional<Veiculo> obj = veiculoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Veiculo não encontrado Id :" + id));
    }

    public Veiculo findbyCpfPropietario(String cpfPropietario){
        Optional<Veiculo> obj = veiculoRepo.findByCpfPropietario(cpfPropietario);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cpf do Propietario não encontrado :" + cpfPropietario));
    }

    public Veiculo findbyNomePropietario(String nomePropieatrio){
        Optional<Veiculo> obj = veiculoRepo.findByNomePropietario(nomePropieatrio);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Nome do Propietario não encontrado :" + nomePropieatrio));
    }

    public Veiculo create(VeiculoDTO dto){
        dto.setIdVeiculo(null);
        validaVeiculo(dto);

        Veiculo obj = new Veiculo(dto);
        return  veiculoRepo.save(obj);
    }

    private  void validaVeiculo(VeiculoDTO dto){
        Optional<Veiculo> obj = veiculoRepo.findByCpfPropietario(dto.getCpfPropietario());
        if (obj.isPresent() && obj.get().getIdVeiculo() != dto.getIdVeiculo()){
            throw new DataIntegrityViolationException(" CPF ja cadastrado");
        }
    }




    public Veiculo update(Long id, VeiculoDTO objDto){
        objDto.setIdVeiculo(id);
        Veiculo oldObj = findbyId(id);
        oldObj = new Veiculo(objDto);
        validaVeiculo(objDto);
        return  veiculoRepo.save(oldObj);
    }

    public  void  delete(Long id){
        Veiculo obj = findbyId(id);
        veiculoRepo.deleteById(id);
    }


}
