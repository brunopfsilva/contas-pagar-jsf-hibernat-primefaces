package VO;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="contas")
public class ContasPagar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //id auto incremento
	@Column(name="id")
	private int id;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="datavenciemnto")
	private Date datavencimento;
	
	@Column(name="valor")
	private double valor;
	
	@ManyToOne 
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedor; //muitos para um relacionamento fornecedor pode ter varias contas

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDatavencimento() {
		return datavencimento;
	}

	public void setDatavencimento(Date datavencimento) {
		this.datavencimento = datavencimento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}


	
	
	
	
}
