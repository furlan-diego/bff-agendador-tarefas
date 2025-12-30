package com.project.bffagendadortarefas.business;

import com.project.bffagendadortarefas.business.dto.in.LoginRequestDto;
import com.project.bffagendadortarefas.business.dto.out.TarefasDtoResponse;
import com.project.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CronService {

    private final TarefasService tarefasService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;


    @Scheduled(cron = "${cron.horario}")
    public void buscaTarefasProximaHora() {
        String token = login(converterParaRequestDto());
        log.info("Iniciado a busca de Tarefas");
        LocalDateTime horaAtual = LocalDateTime.now(); //LocalDateTime.now (hora atual)
        LocalDateTime horaFutura = LocalDateTime.now().plusHours(1); //+1hr
        // Qualquer tarefa que fique entre hora atual e a hora futura +1 (que sera entre 22h e 23h, por exemplo)

        List<TarefasDtoResponse> listaTarefas = tarefasService.buscaTarefasAgendadasPorPeriodo(horaAtual, horaFutura, token);
        log.info("Tarefas encontradas: " + listaTarefas);
        listaTarefas.forEach(tarefa -> {
            emailService.enviaEmail(tarefa);
            log.info("Email enviado para usuario: " + tarefa.getEmailUsuario());
            tarefasService.alteraStatus(StatusNotificacaoEnum.NOTIFICADO, tarefa.getId(),
                    token);
        });
        log.info("Finalizado a busca de Tarefas");
    }

    public String login(LoginRequestDto dto) {
        return usuarioService.loginUsuario(dto);

    }

    public LoginRequestDto converterParaRequestDto() {
        return LoginRequestDto.builder()
                .email(email)
                .senha(senha)
                .build();
    }
}
