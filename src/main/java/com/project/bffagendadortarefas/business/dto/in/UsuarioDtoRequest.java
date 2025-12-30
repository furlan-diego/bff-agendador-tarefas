package com.project.bffagendadortarefas.business.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDtoRequest {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDtoRequest> enderecos;
    private List<TelefoneDtoRequest> telefones;

}
