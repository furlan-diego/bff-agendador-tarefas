package com.project.bffagendadortarefas.infrastructure.client;

import com.project.bffagendadortarefas.business.dto.in.TarefasDtoRequest;
import com.project.bffagendadortarefas.business.dto.out.TarefasDtoResponse;
import com.project.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface TarefasClient {

    @PostMapping
    TarefasDtoResponse gravarTarefas(@RequestBody TarefasDtoRequest dto,
                                     @RequestHeader("Authorization") String token);


    @GetMapping("/eventos")
    List<TarefasDtoResponse> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token);

    @GetMapping
    List<TarefasDtoResponse> buscaTarefasPorEmail(@RequestHeader("Authorization") String token);

    @DeleteMapping
    void deletaTarefaPorId(@RequestParam("id") String id,
                           @RequestHeader("Authorization") String token);

    @PatchMapping
    TarefasDtoResponse alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                               @RequestParam("id") String id,
                                               @RequestHeader("Authorization") String token);

    @PutMapping
    TarefasDtoResponse updateTarefas(@RequestBody TarefasDtoRequest dto,
                                     @RequestParam("id") String id,
                                     @RequestHeader("Authorization") String token);

}
