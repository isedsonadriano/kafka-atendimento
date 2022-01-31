package br.com.isedsonadriano.application.controller;

import java.util.List;

import br.com.isedsonadriano.core.domain.enums.TipoAtendimento;
import lombok.Getter;

@Getter
public class AtendimentoDTO {

	private String prestador;
	private String medico;
	private String paciente;
	private TipoAtendimento tipoAtendimento;

    private List<String> servicos;
}