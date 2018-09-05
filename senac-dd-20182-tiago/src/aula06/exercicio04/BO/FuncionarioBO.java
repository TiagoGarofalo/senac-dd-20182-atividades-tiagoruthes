package aula06.exercicio04.BO;

import aula06.exercicio04.DAO.FuncionarioDAO;
import aula06.exercicio04.VO.FuncionarioVO;

public class FuncionarioBO {

	FuncionarioDAO dao = new FuncionarioDAO();
	public boolean inserir(FuncionarioVO funcionarioVO) {
		int idGerado = dao.inserir(funcionarioVO);
		return idGerado > 0;
	}
	public FuncionarioVO buscarFuncionarioVOPorId(String textoId) {
		FuncionarioVO funcionarioVOBuscado = dao.obterPorId(Integer.parseInt(textoId));
		return funcionarioVOBuscado;
	}
	public boolean atualizar(FuncionarioVO funcionarioVO) {
		boolean sucesso = dao.atualizar(funcionarioVO);
		return sucesso;
	}
	
}
