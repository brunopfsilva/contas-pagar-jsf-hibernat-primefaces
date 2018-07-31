package BEAN;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import DAO.fornecedorDAO;
import VO.Fornecedor;

@ManagedBean(name="forBean")
@SessionScoped
public class fornecedorBEAN {
	
	private Fornecedor vo = new Fornecedor();
	private DataModel<Fornecedor>fornecedores;
	
	public DataModel<Fornecedor>getFornecedores(){
		fornecedorDAO dao = new fornecedorDAO();
		
		try {
			List <Fornecedor>lista = dao.getAll();
			fornecedores = new ListDataModel<Fornecedor>(lista);
		} catch (Exception e) {
			
			
			
		}finally {
			
		}
		return fornecedores;
	}

	public void selecionarFornecedor() {
		this.vo = fornecedores.getRowData(); //seleciona linha do data model
	}
	
	public void setFornecedores(DataModel<Fornecedor>fornecedores) {

		this.fornecedores = fornecedores;
	}
	
	//usat o get and set da classe para que o bean consiga pega os dados do formulario e tambem trazer quando for preciso
	
	
	
	public Fornecedor getVo() {
			return vo;
		}




	public void setVo(Fornecedor vo) {
		this.vo = vo;
	}



	public void novo() { //cria novo fornecedor
		vo = new Fornecedor();
	}
	
	//	public String addFornecedor(Fornecedor fornecedor) {
	public String addFornecedor() {

		String retorno = "erro";
	
		try {
			
			fornecedorDAO dao = new fornecedorDAO();
			dao.save(vo);
			retorno = "listar"; 
			
		} catch (Exception e) {

			
		}finally {
			
		}
		
		return retorno;
		
	}

	public String delFornecedor() {

		this.vo = fornecedores.getRowData();
		String retorno = "erro";
	
		try {
			
			fornecedorDAO dao = new fornecedorDAO();
		
			dao.delete(vo);
			retorno = "listar"; 
			
		} catch (Exception e) {

			
		}finally {
			
		}
		
		return retorno;
		
	}

	public String updateFornecedor() {

		String retorno = "erro";
	
		try {
			
			fornecedorDAO dao = new fornecedorDAO();
		
			dao.update(vo);
			retorno = "listar"; 
			
		} catch (Exception e) {

			
		}finally {
			
		}
		
		return retorno;
		
	}

	
}
