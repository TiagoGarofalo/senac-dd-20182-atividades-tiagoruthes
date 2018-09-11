package aula06.exercicio04.BO;

import java.sql.SQLException;

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
	
	public boolean excluir(int idEntidade) {
		boolean sucesso = false;
		try {
			sucesso = dao.excluir(idEntidade);
		} catch (SQLException e) {
			// TODO tratar melhor a mensagem
			e.printStackTrace();
		}
		return sucesso;
	}
	
	/*public List<FuncionarioVO> listarFuncionario() {
		ArrayList<FuncionarioVO> funcionarioVO = dao.listarTodos();
		return funcionarioVO;
	}*/
		
}
