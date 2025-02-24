package com.curso.automovel.domains;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.curso.automovel.domains.dtos.VeiculoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "veiculo")

public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_veiculo")
    private Long idVeiculo;

    @NotNull
    @NotBlank
    private String descricao;


    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAquisicao = LocalDate.now();

    @NotNull
    private Double valorAquisicao;

    @NotNull
    @NotBlank
    private String nomePropietario;

    @NotNull @NotBlank
    @Column(unique = true)
    private String cpfPropietario;

    public Veiculo() {

    }


    public Veiculo(Long idVeiculo,  String descricao,  LocalDate dataAquisicao,  Double valorAquisicao, String nomePropietario, String cpfPropietario){
        this.idVeiculo = idVeiculo;
        this.descricao = descricao;
        this.dataAquisicao = dataAquisicao;
        this.valorAquisicao = valorAquisicao;
        this.nomePropietario = nomePropietario;
        this.cpfPropietario = cpfPropietario;
    }

    public Veiculo(VeiculoDTO dto){
        this.idVeiculo = dto.getIdVeiculo();
        this.descricao = dto.getDescricao();
        this.dataAquisicao = dto.getDataAquisicao();
        this.valorAquisicao = dto.getValorAquisicao();
        this.nomePropietario = dto.getNomePropietario();
        this.cpfPropietario = dto.getCpfPropietario();
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public @NotNull @NotBlank String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull @NotBlank String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public @NotNull Double getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(@NotNull Double valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public @NotNull @NotBlank String getNomePropietario() {
        return nomePropietario;
    }

    public void setNomePropietario(@NotNull @NotBlank String nomePropietario) {
        this.nomePropietario = nomePropietario;
    }

    public @NotNull @NotBlank String getCpfPropietario() {
        return cpfPropietario;
    }

    public void setCpfPropietario(@NotNull @NotBlank String cpfPropietario) {
        this.cpfPropietario = cpfPropietario;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(idVeiculo, veiculo.idVeiculo) && Objects.equals(descricao, veiculo.descricao) && Objects.equals(dataAquisicao, veiculo.dataAquisicao) && Objects.equals(valorAquisicao, veiculo.valorAquisicao) && Objects.equals(nomePropietario, veiculo.nomePropietario) && Objects.equals(cpfPropietario, veiculo.cpfPropietario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVeiculo, descricao, dataAquisicao, valorAquisicao, nomePropietario, cpfPropietario);
    }
}
