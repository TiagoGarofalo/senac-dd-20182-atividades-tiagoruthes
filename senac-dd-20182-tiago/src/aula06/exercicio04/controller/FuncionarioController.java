package aula06.exercicio04.controller;

import aula06.exercicio04.BO.FuncionarioBO;

public class FuncionarioController {
	
	private FuncionarioBO bo = new FuncionarioBO();
	
	public String excluir(String idFuncionarioDigitado) {
		
		String mensagemRetorno = "";
		try {
			int id = Integer.parseInt(idFuncionarioDigitado);
			
			if(bo.excluir(id)) {
				mensagemRetorno = "Funcion�rio foi exclu�do!";
			}else {
				mensagemRetorno = "Funcion�rio n�o foi exclu�do!";
			}
		}catch (NumberFormatException ex) {
			mensagemRetorno = "id informado DEVE ser um n�mero";
		}
		
		return mensagemRetorno;
	}

}
