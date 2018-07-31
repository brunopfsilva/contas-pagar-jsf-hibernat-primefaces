package BEAN;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import DAO.contasPagarDAO;
import DAO.fornecedorDAO;
import VO.ContasPagar;
import VO.Fornecedor;

@ManagedBean(name="cpBean")
@SessionScoped
public class contasPagarBEAN {
	
	private ContasPagar cp = new ContasPagar();
	private DataModel<ContasPagar>contas;
	private int fornecedor_id;
	
	
	
	
	public int getFornecedor_id() {
		return fornecedor_id;
	}

	public void setFornecedor_id(int fornecedor_id) {
		this.fornecedor_id = fornecedor_id;
	}

	public DataModel<ContasPagar>getContas(){
		contasPagarDAO dao = new contasPagarDAO();
		
		try {
			List <ContasPagar>lista = dao.getAll();
			contas = new ListDataModel<ContasPagar>(lista);
		} catch (Exception e) {
			
			
			
		}finally {
			
		}
		return contas;
	}

	public void selecionarContas() {
		this.cp = contas.getRowData();
	}
	
	public void novaConta() {
		cp = new ContasPagar();
	}

	public String addContas() {

		String retorno = "erro";
	
		try {
			
			contasPagarDAO dao = new contasPagarDAO();
			
			fornecedorDAO fdao = new fornecedorDAO();
			
			cp.setFornecedor(fdao.getOne(fornecedor_id));
			
			dao.salvarConta(cp);
			retorno = "listar"; 
			
		} catch (Exception e) {

			
		}finally {
			
		}
		
		return retorno;
		
	}

	
	public ContasPagar getCp() {
		return cp;
		
	}

	
	public void setCp(ContasPagar cp) {
		this.cp = cp;
	}

	
	public void setContas(DataModel<ContasPagar> contas) {
		this.contas = contas;
	}
	
	public Collection<SelectItem>getCarregarFornecedores(){
		fornecedorDAO dao = new fornecedorDAO();
		Collection<SelectItem>lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem("-- SELECIONE --"));
		List<Fornecedor>listafornecedor = dao.getAll();
		
		for(int i = 0; i < listafornecedor.size(); i++) {
			lista.add(new SelectItem(listafornecedor.get(i).getId(),listafornecedor.get(i).getNome()));
		}
		
		return lista;

		
	}
	

	
	
}
