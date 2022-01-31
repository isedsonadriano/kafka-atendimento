package br.com.isedsonadriano.application.controller;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isedsonadriano.core.domain.entity.Atendimento;
import br.com.isedsonadriano.core.domain.entity.Servico;
import br.com.isedsonadriano.core.domain.service.AtendimentoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/atendimentos")
@AllArgsConstructor
public class AtendimentoController {

	private AtendimentoService atendimentoService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendMessage(@RequestBody AtendimentoDTO atendimentodto) {
    	 try {
			Atendimento atendimento = Atendimento.builder()
					 .medico(atendimentodto.getMedico())
					 .prestador(atendimentodto.getPrestador())
					 .tipoAtendimento(atendimentodto.getTipoAtendimento())
					 .servicos( atendimentodto.getServicos().stream().map(s -> new Servico(s)).collect(Collectors.toList())).build();
			
			this.atendimentoService.save(atendimento);

			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    }
	
}
