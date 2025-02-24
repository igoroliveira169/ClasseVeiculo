package com.curso.automovel.resources;


import com.curso.automovel.domains.Veiculo;
import com.curso.automovel.domains.dtos.VeiculoDTO;
import com.curso.automovel.services.VeiculoService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoResource {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> findAll(){
        return ResponseEntity.ok().body(veiculoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id){
        Veiculo obj = this.veiculoService.findbyId(id);
        return  ResponseEntity.ok().body(new VeiculoDTO(obj));
    }

    @GetMapping(value = "/cpfPropietario/{cpfPropietario}")
     public  ResponseEntity<VeiculoDTO> findByCpfPropietario(@PathVariable String cpfPropietario){
        Veiculo obj = this.veiculoService.findbyCpfPropietario(cpfPropietario);
        return ResponseEntity.ok().body(new VeiculoDTO(obj));
    }

    @GetMapping(value = "/nomePropietario/{nomePropietario}")
    public ResponseEntity<VeiculoDTO> findByNomePropietario(@PathVariable String nomePropietario){
        Veiculo obj = this.veiculoService.findbyNomePropietario(nomePropietario);
        return  ResponseEntity.ok().body(new VeiculoDTO(obj));
    }

    @PostMapping
    public  ResponseEntity<VeiculoDTO> create(@Valid @RequestBody VeiculoDTO dto){
        Veiculo veiculo = veiculoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(veiculo.getIdVeiculo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> update(@PathVariable Long id, @Valid @RequestBody VeiculoDTO objDto){
        Veiculo Obj  = veiculoService.update(id, objDto);
        return  ResponseEntity.ok().body(new VeiculoDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> delete(@PathVariable Long id){
        veiculoService.delete(id);
        return  ResponseEntity.noContent().build();
    }

}
