package br.com.benefrancis.fabrica.chocolate.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
//@formatter:off
@Table(name = "tb_empregado",
		uniqueConstraints = @UniqueConstraint(
				name = "UK_EMP_MATRICULA", 
				columnNames = { "MATRICULA"}
				))
// @formatter:on
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Empregado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPREGADO")
	@SequenceGenerator(name = "SEQ_EMPREGADO", sequenceName = "SEQ_EMPREGADO", allocationSize = 1, initialValue = 1)
	private Long id;

	@NonNull
	@Column(length = 255, nullable = false)
	private String matricula;

	@NonNull
	@Column(length = 255, nullable = false)
	private String email;

	@Getter
	@Setter
	@ManyToOne
	private Fabrica fabrica;
	
	
	@Getter
	@Setter
	@ManyToOne
	private Pessoa pessoa;

}