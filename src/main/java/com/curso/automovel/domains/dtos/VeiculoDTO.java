package com.curso.automovel.domains.dtos;


import com.curso.automovel.domains.Veiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.curso.automovel.domains.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class VeiculoDTO {

    private Long idVeiculo;

    @NotNull(message = "O campo descricao não pode ser nulo")
    @NotBlank(message = "O campo descircao não pode ser vazio")
    private  String descricao;

    @NotNull(message = "O campo Data não pode ser nulo")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAquisicao;

    @NotNull(message = "O campo valorAquisicao não pode ser nulo")
    private Double valorAquisicao;

    @NotNull(message = "O campo nomePropietario não pode ser nulo")
    @NotBlank(message = "O campo nomePropietario não pode ser vazio")
    private  String nomePropietario;

    @NotNull(message = "O campo cpfPropietario não pode ser nulo")
    @NotBlank(message = "O campo cpfPropietario não pode ser vazio")
    private  String cpfPropietario;


    public VeiculoDTO(){}

    public VeiculoDTO(Veiculo veiculo){
        this.idVeiculo = veiculo.getIdVeiculo();
        this.descricao = veiculo.getDescricao();
        this.dataAquisicao = veiculo.getDataAquisicao();
        this.valorAquisicao = veiculo.getValorAquisicao();
        this.nomePropietario = veiculo.getNomePropietario();
        this.cpfPropietario = veiculo.getCpfPropietario();
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public @NotNull(message = "O campo descricao não pode ser nulo") @NotBlank(message = "O campo descircao não pode ser vazio") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descricao não pode ser nulo") @NotBlank(message = "O campo descircao não pode ser vazio") String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public @NotNull(message = "O campo valorAquisicao não pode ser nulo") Double getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(@NotNull(message = "O campo valorAquisicao não pode ser nulo") Double valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public @NotNull(message = "O campo nomePropietario não pode ser nulo") @NotBlank(message = "O campo nomePropietario não pode ser vazio") String getNomePropietario() {
        return nomePropietario;
    }

    public void setNomePropietario(@NotNull(message = "O campo nomePropietario não pode ser nulo") @NotBlank(message = "O campo nomePropietario não pode ser vazio") String nomePropietario) {
        this.nomePropietario = nomePropietario;
    }

    public @NotNull(message = "O campo cpfPropietario não pode ser nulo") @NotBlank(message = "O campo cpfPropietario não pode ser vazio") String getCpfPropietario() {
        return cpfPropietario;
    }

    public void setCpfPropietario(@NotNull(message = "O campo cpfPropietario não pode ser nulo") @NotBlank(message = "O campo cpfPropietario não pode ser vazio") String cpfPropietario) {
        this.cpfPropietario = cpfPropietario;
    }
}
