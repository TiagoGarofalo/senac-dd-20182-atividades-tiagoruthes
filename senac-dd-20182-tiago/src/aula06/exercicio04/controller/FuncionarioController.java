package aula06.exercicio04.controller;

import aula06.exercicio04.BO.FuncionarioBO;

public class FuncionarioController {
	
	private FuncionarioBO bo = new FuncionarioBO();
	
	public String excluir(String idFuncionarioDigitado) {
		
		String mensagemRetorno = "";
		try {
			int id = Integer.parseInt(idFuncionarioDigitado);
			
			if(bo.excluir(id)) {
				mensagemRetorno = "Funcionário foi excluído!";
			}else {
				mensagemRetorno = "Funcionário não foi excluído!";
			}
		}catch (NumberFormatException ex) {
			mensagemRetorno = "id informado DEVE ser um número";
		}
		
		return mensagemRetorno;
	}

}
