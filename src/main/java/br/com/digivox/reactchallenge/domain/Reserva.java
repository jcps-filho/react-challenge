package br.com.digivox.reactchallenge.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Reserva implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Livro> livros;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	private Date dataDeCriacao;
	
	private Date dataDeRetirada;
	
	private Date dateDeEntrega;
	
	public Reserva() {
		
	}

	public Reserva(List<Livro> livros, Cliente cliente, Date dataDeCriacao, Date dataDeRetirada, Date dataDeEntrega) {
		super();
		this.livros = livros;
		this.cliente = cliente;
		this.dataDeCriacao = dataDeCriacao;
		this.dataDeRetirada = dataDeRetirada;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(Date dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public Date getDataDeRetirada() {
		return dataDeRetirada;
	}

	public void setDataDeRetirada(Date dataDeRetirada) {
		this.dataDeRetirada = dataDeRetirada;
	}

	public Integer getId() {
		return id;
	}
	
	public Date getDateDeEntrega() {
		return dateDeEntrega;
	}

	public void setDateDeEntrega(Date dateDeEntrega) {
		this.dateDeEntrega = dateDeEntrega;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Reserva other = (Reserva) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
