package br.com.benefrancis.fabrica.chocolate.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

//@formatter:off
@Table(name = "tb_fabrica",
		uniqueConstraints = @UniqueConstraint(
				name = "UK_FAB_NAME", 
				columnNames = { "NAME"}
				))
// @formatter:on
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Fabrica implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Setter
	@Getter
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FABRICA")
	@SequenceGenerator(name = "SEQ_FABRICA", sequenceName = "SEQ_FABRICA", allocationSize = 1, initialValue = 1)
	private Long id;

	@Setter
	@Getter
	@NonNull
	@Column(length = 255, nullable = false)
	private String name;

	@JsonIgnore
	@Transient
	@Setter
	@Getter
	@NonNull
	private Locale locale;

 
	@JsonIgnore
	@Transient
	@Setter
	@Getter
	@OneToMany(mappedBy="empregado.fabrica")
	List<Empregado> empregados = new ArrayList<>();

 
	@JsonIgnore
	@Transient
	@Setter
	@Getter
	@OneToMany(mappedBy="lote.fabrica")
	List<Lote> lotes = new ArrayList<>();

}
