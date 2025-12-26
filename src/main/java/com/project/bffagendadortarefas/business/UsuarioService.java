package com.project.bffagendadortarefas.business;

import com.project.bffagendadortarefas.business.dto.in.EnderecoDtoRequest;
import com.project.bffagendadortarefas.business.dto.in.LoginRequestDto;
import com.project.bffagendadortarefas.business.dto.in.TelefoneDtoRequest;
import com.project.bffagendadortarefas.business.dto.in.UsuarioDtoRequest;
import com.project.bffagendadortarefas.business.dto.out.EnderecoDtoResponse;
import com.project.bffagendadortarefas.business.dto.out.TelefoneDtoResponse;
import com.project.bffagendadortarefas.business.dto.out.UsuarioDtoResponse;
import com.project.bffagendadortarefas.infrastructure.client.UsuarioClient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDtoResponse salvaUsuario(UsuarioDtoRequest usuarioDto) {
        return client.salvaUsuario(usuarioDto);
    }

    public String loginUsuario(LoginRequestDto dto) {
        return client.login(dto);
    }

    public UsuarioDtoResponse buscarUsuarioPorEmail(String email, String token) {
        return client.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token) {
        client.deletaUsuarioPorEmail(email, token); //por ser void não retorna nada.
    }

    public UsuarioDtoResponse atualizaDadosUsuario(String token, UsuarioDtoRequest dto) {
        return client.atualizaDadosUsuario(dto, token);
    }

    public EnderecoDtoResponse atualizaEndereco(Long idEndereco, EnderecoDtoRequest enderecoDto, String token) {
        return client.atualizaEndereco(enderecoDto, idEndereco, token);
    }

    public TelefoneDtoResponse atualizaTelefone(Long idTelefone, TelefoneDtoRequest dto, String token) {
        return client.atualizaTelefone(dto, idTelefone, token);
    }

    public EnderecoDtoResponse cadastraEndereco(String token, EnderecoDtoRequest dto) {
        return client.cadastraEndereco(dto, token);
    }

    public TelefoneDtoResponse cadastraTelefone(String token, TelefoneDtoRequest dto) {
        return client.cadastraTelefone(dto, token);
    }
}