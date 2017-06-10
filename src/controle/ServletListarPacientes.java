package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.PacienteDAO;
import modelo.dominio.Paciente;

/**
 * Servlet implementation class ServletListarProdutos
 */
@WebServlet("/listarPacientes")
public class ServletListarPacientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarPacientes() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rg = null;
		String cpf = null;
		String nomePaciente = null;
		Integer codInt = null;
		String dtNasc = null;
		String telefone = null;
		String email = null;
		PacienteDAO dao = new PacienteDAO(codInt, nomePaciente, cpf, rg, dtNasc, telefone, email);
		List<Paciente> lista = dao.lerTodos();
		
		request.setAttribute("lista", lista);
		
		request.getRequestDispatcher("listarPacientes.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}