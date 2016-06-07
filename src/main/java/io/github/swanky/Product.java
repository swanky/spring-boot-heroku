package io.github.swanky;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = { "id" })
@ToString(exclude = {})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	private Integer price;

	private String category;

	private String description;

}