package br.com.isedsonadriano.core.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import br.com.isedsonadriano.core.domain.enums.TipoAtendimento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Atendimento {

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid",  strategy = "uuid2")
	private String id;
	private String prestador;
	private String medico;
	private String paciente;
	private TipoAtendimento tipoAtendimento;
	
	@OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL)
	private List<Servico> servicos;
	
	public Boolean isGeraCotacao() {
		return this.tipoAtendimento.equals(TipoAtendimento.INTERNACAO);
	}

	
}
