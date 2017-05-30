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
 * Servlet implementation class ServeletSalvarCliente
 */
@WebServlet("/salvarCliente")
public class ServletSalvarPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSalvarPaciente() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(403, "Não é permitido enviar requisição via GET.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codPaciente = request.getParameter("codigo");
		String nomePaciente = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String rg = request.getParameter("rg");
		String dtnasc = request.getParameter("datanascimento");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		
		Integer codigoInt = null;
		try {
			codigoInt = Integer.parseInt(codPaciente);
		} catch (NumberFormatException e) {
			codigoInt = null;
		}
		
		//Float precoCusto = Float.parseFloat(custo);
		//Float precoVenda = Float.parseFloat(venda);
		
		Paciente paciente = new Paciente(codigoInt, nomePaciente, cpf, rg, dtnasc, telefone, email);
		
		PacienteDAO dao = new PacienteDAO();
		dao.alterar(paciente);
		
		// RequestDispatcher desp = request.getRequestDispatcher("index.jsp");
		// desp.forward(request, response);
		
		response.sendRedirect("listarPacientes");
	}

}
