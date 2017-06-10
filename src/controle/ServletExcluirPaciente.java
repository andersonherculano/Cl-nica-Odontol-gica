package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.PacienteDAO;
import modelo.dominio.Paciente;

/**
 * Servlet implementation class ServletExcluirProduto
 */
@WebServlet("/excluirPaciente")
public class ServletExcluirPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirPaciente() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String codigo = request.getParameter("codigo");
		Integer chave = Integer.parseInt(codigo);
		
		String email = null;
		String telefone = null;
		String dtNasc = null;
		String rg = null;
		String cpf = null;
		String nomePaciente = null;
		Integer codInt = null;
		PacienteDAO dao = new PacienteDAO(codInt, nomePaciente, cpf, rg, dtNasc, telefone, email);
		Paciente paciente = dao.lerPorId(chave);
		
		dao.excluir(paciente);
		request.getRequestDispatcher("listarPacientes").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
