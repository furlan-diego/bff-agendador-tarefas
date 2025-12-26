package com.project.bffagendadortarefas.infrastructure.client;

import com.project.bffagendadortarefas.business.dto.in.EnderecoDtoRequest;
import com.project.bffagendadortarefas.business.dto.in.LoginRequestDto;
import com.project.bffagendadortarefas.business.dto.in.TelefoneDtoRequest;
import com.project.bffagendadortarefas.business.dto.in.UsuarioDtoRequest;
import com.project.bffagendadortarefas.business.dto.out.EnderecoDtoResponse;
import com.project.bffagendadortarefas.business.dto.out.TelefoneDtoResponse;
import com.project.bffagendadortarefas.business.dto.out.UsuarioDtoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDtoResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDtoResponse salvaUsuario(@RequestBody UsuarioDtoRequest usuarioDto);

    @PostMapping("/login")
    String login(@RequestBody LoginRequestDto usuarioDto);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDtoResponse atualizaDadosUsuario(@RequestBody UsuarioDtoRequest dto,
                                            @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDtoResponse atualizaEndereco(@RequestBody EnderecoDtoRequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDtoResponse atualizaTelefone(@RequestBody TelefoneDtoRequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDtoResponse cadastraEndereco(@RequestBody EnderecoDtoRequest dto,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDtoResponse cadastraTelefone(@RequestBody TelefoneDtoRequest dto,
                                         @RequestHeader("Authorization") String token);

}
