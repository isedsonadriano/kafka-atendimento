package br.com.isedsonadriano.core.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Servico {

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid",  strategy = "uuid2")
	private String id;
	private String descricao;
	
	@ManyToOne
	private Atendimento atendimento;

	public Servico(String descricao) {
		super();
		this.descricao = descricao;
	}
	
	
}
