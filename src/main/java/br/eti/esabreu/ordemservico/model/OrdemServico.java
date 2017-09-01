package br.eti.esabreu.ordemservico.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(mappedBy = "ordemServico")
	private List<ItemOrdemServico> itensOrdemServico;
	
	private String equipamento;
	
	private String defeito;
	
	private String laudo;
	
	private LocalDate entrada;
	
	private LocalDate saida;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public enum Status {
		ORCAMENTO("ORÇAMENTO"), ABERTA("ABERTA"), ATENDIMENTO("EM ATENDIMENTO"), FECHADA("FECHADA");
		
		private String status;
		
		private Status(String status) {
			this.status = status;
		}
		
		public String getStatus() {
			return status;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemOrdemServico> getItens() {
		return itensOrdemServico;
	}

	public void setItens(List<ItemOrdemServico> itensOrdemServico) {
		this.itensOrdemServico = itensOrdemServico;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public String getDefeito() {
		return defeito;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}

	public String getLaudo() {
		return laudo;
	}

	public void setLaudo(String laudo) {
		this.laudo = laudo;
	}

	public LocalDate getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDate entrada) {
		this.entrada = entrada;
	}

	public LocalDate getSaida() {
		return saida;
	}

	public void setSaida(LocalDate saida) {
		this.saida = saida;
	}
	
	public void addItemOrdemServico(ItemOrdemServico itemOrdemServico) {
		if(itensOrdemServico == null)
			itensOrdemServico = new ArrayList<ItemOrdemServico>();
		itensOrdemServico.add(itemOrdemServico);
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
		OrdemServico other = (OrdemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
