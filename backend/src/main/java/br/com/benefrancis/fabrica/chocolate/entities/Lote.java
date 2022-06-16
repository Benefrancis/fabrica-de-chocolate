package br.com.benefrancis.fabrica.chocolate.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@Table(name = "tb_lote")
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Lote implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Setter
	@Getter
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOTE")
	@SequenceGenerator(name = "SEQ_LOTE", sequenceName = "SEQ_LOTE", allocationSize = 1, initialValue = 1)
	private Long id;

	@Getter
	@Setter
	@ManyToOne
	private Fabrica fabrica;

	@NonNull
	@Setter
	@Getter
	private LocalDateTime data;

	public String getCodigo() {
		String d = "";

		// @formatter:off
 		if (validaCodigo()) {
			d = this.getId() + "." + 
				this.getFabrica().getId() + "." + 
				this.data.getYear() + "." + 
				this.data.getMonthValue() + "." + 
				this.data.getDayOfMonth();
		}
 		// @formatter:on

		return d;

	}

	private boolean validaCodigo() {
		return (this.getId() != null && this.getData() != null && this.getFabrica() != null);
	}
}