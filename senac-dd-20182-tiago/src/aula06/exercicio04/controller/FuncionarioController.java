package aula06.exercicio04.controller;

import aula06.exercicio04.BO.FuncionarioBO;
import aula06.exercicio04.VO.FuncionarioVO;

public class FuncionarioController {
	
	private FuncionarioBO bo = new FuncionarioBO();
	
	public String excluir(String cpfFuncionarioDigitado) {
		
		String mensagemRetorno = "";
		try {
			int cpf = Integer.parseInt(cpfFuncionarioDigitado);
			
			if(bo.excluir(cpf)) {
				mensagemRetorno = "Funcion�rio foi exclu�do!";
			}else {
				mensagemRetorno = "Funcion�rio n�o foi exclu�do!";
			}
		}catch (NumberFormatException ex) {
			mensagemRetorno = "CPF informado DEVE ser um n�mero";
		}
		
		return mensagemRetorno;
	}

	public String salvar(FuncionarioVO funcionario) {
		String validacao = validarFuncionario(funcionario);

		if(validacao == "") {
			if(funcionario.getIdFuncionario() > 0) {
				//INSERT
				if(bo.atualizar(funcionario)) {
					validacao = "funcionario atualizado com sucesso!";
				}else {
					validacao = "Erro ao atualizar funcionario";
				}
			}else {
				//INSERT
				if(bo.inserir(funcionario)) {
					validacao = "funcionario salvo com sucesso!";
				}else {
					validacao = "Erro ao salvar funcionario";
				}
			}
		}

		return validacao;
	}

	private String validarFuncionario(FuncionarioVO funcionario) {
		String validacao = "";

		if(funcionario == null) {
			validacao = "Funcionario est� NULO!";
		}else {
			//Validar o preenchimento
			if(funcionario.getNome().trim().equals("")) {
				validacao += "- Nome � obrigat�rio \n";
			}
			if(funcionario.getCpf().trim().equals("")) {
				validacao += "- CPF � obrigat�rio \n";
			}
		}
		return validacao;
	}

	public String atualizar(FuncionarioVO funcionario) {
		String validacao = validarFuncionario(funcionario);

		if(validacao == "") {
			if(funcionario.getCpf() != "") {
				//INSERT
				if(bo.atualizar(funcionario)) {
					validacao = "funcionario atualizado com sucesso!";
				}else {
					validacao = "Erro ao atualizar funcionario";
				
				}
			}
		}

		return validacao;
	}
	
}
