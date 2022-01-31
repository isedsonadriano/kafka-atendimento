package br.com.isedsonadriano.core.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape=Shape.STRING)
public enum TipoAtendimento {

	EXAME,
	INTERNACAO
}
