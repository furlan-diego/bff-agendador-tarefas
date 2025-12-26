
package com.project.bffagendadortarefas.infrastructure.client;

import com.project.bffagendadortarefas.business.dto.out.TarefasDtoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    @PostMapping("/enviar")
    void enviarEmail(@RequestBody TarefasDtoResponse dto);

}