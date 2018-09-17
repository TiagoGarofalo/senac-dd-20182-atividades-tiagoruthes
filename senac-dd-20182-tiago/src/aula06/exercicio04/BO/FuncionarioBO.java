package aula06.exercicio04.BO;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import aula06.exercicio04.DAO.FuncionarioDAO;
import aula06.exercicio04.VO.FuncionarioVO;

public class FuncionarioBO {

	FuncionarioDAO dao = new FuncionarioDAO();
	/*
	 * public boolean inserir(FuncionarioVO funcionarioVO) { int idGerado =
	 * dao.inserir(funcionarioVO); return idGerado > 0; } public FuncionarioVO
	 * buscarFuncionarioVOPorId(String textoId) { FuncionarioVO funcionarioVOBuscado
	 * = null; try { funcionarioVOBuscado =
	 * dao.pesquisarPorId(Integer.parseInt(textoId)); } catch (NumberFormatException
	 * | SQLException e) { e.printStackTrace(); } return funcionarioVOBuscado; }
	 */

	public boolean inserir(FuncionarioVO novoFunc) {
		boolean sucesso = false;
		// Verificar se já existe funcionário com o CPF de novoFunc
		// Caso não -> salvar!
		if (!dao.temCPFCadastrado(novoFunc.getCpf())) {
			int novaChave = dao.inserir(novoFunc);

			if (novaChave > 0) {
				sucesso = true;
			}
		}

		return sucesso;
	}

	public boolean atualizar(FuncionarioVO novoFunc) {
		boolean sucesso = false;
		sucesso = dao.atualizar(novoFunc);

		return sucesso;
	}

	public boolean excluir(int cpfEntidade) {
		boolean sucesso = false;
		sucesso = dao.excluir(cpfEntidade);

		return sucesso;
	}

	public FuncionarioVO pesquisarPorCPF(String funcionario) {
		FuncionarioVO funcBuscado = dao.pesquisarPorCPF(Integer.parseInt(funcionario));
		return funcBuscado;
	}



	/*
	 * public List<FuncionarioVO> listarFuncionario() { ArrayList<FuncionarioVO>
	 * funcionarioVO = dao.listarTodos(); return funcionarioVO; }
	 */

}
