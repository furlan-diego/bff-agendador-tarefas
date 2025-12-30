package com.project.bffagendadortarefas.business;

import com.project.bffagendadortarefas.business.dto.out.TarefasDtoResponse;
import com.project.bffagendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasDtoResponse dto) {
        emailClient.enviarEmail(dto);
    }

}
