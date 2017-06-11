package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.PacienteDAO;
import modelo.dominio.Paciente;

/**
 * Servlet implementation class ServletSalvarPaciente
 */
@WebServlet("/salvarPaciente")
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
		
		// doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("codigo");
		String nomePaciente = request.getParameter("paciente"); 
		
		List<String> erros = new ArrayList<String>();
		
		Integer codigoInt = null;
		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (NumberFormatException e) {
			codigoInt = null;
		}
		
		if ((nomePaciente == null) || (nomePaciente.isEmpty()))
			erros.add("O campo nome é obrigatório.");
			
		Paciente Paciente = new Paciente();
		
		if (erros.isEmpty()) {
		
			PacienteDAO dao = new PacienteDAO();
			dao.salvar(Paciente);
			
			response.sendRedirect("listarPacientes");
		}
		else
		{
			request.setAttribute("Paciente", Paciente);
			request.setAttribute("erros", erros);
			request.getRequestDispatcher("editarPaciente.jsp").forward(request, response);;
		}
	}

}