package br.com.digivox.reactchallenge.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.digivox.reactchallenge.enums.LivroStatus;

@Entity
public class Livro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String titulo;
	private String subtitulo;
	@Column(columnDefinition = "int default 1")
	private Integer status;
	
	public Livro () {
		
	}
	public Livro(String titulo, String subtitulo, LivroStatus status) {
		super();
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.status = status.getCodigo();
	}
	public long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getSubtitulo() {
		return subtitulo;
	}
	
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public LivroStatus getStatus() {
		return LivroStatus.toEnum(status);
	}

	public void setStatus(LivroStatus status) {
		this.status = status.getCodigo();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
