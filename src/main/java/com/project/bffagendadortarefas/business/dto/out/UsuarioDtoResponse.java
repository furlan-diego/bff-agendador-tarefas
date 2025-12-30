package com.project.bffagendadortarefas.business.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDtoResponse {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDtoResponse> enderecos;
    private List<TelefoneDtoResponse> telefones;

}
