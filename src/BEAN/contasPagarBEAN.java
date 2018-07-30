package BEAN;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import DAO.contasPagarDAO;
import DAO.fornecedorDAO;
import VO.ContasPagar;

@ManagedBean(name="cpBean")
@SessionScoped
public class contasPagarBEAN {
	
	private ContasPagar cp = new ContasPagar();
	private DataModel<ContasPagar>contas;
	
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
			dao.salvarConta(cp);
			retorno = "listar"; 
			
		} catch (Exception e) {

			
		}finally {
			
		}
		
		return retorno;
		
	}

	
}
