package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.AgendaDAO;
import modelo.dao.PacienteDAO;
import modelo.dominio.Agenda;
import modelo.dominio.Paciente;

/**
 * Servlet implementation class ServletSalvarProduto
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
		String rg = request.getParameter("rg");
		String cpf = request.getParameter("cpf");
		String dtNasc = request.getParameter("dtnasc");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String idAgenda = request.getParameter("idAgenda"); 
		
		List<String> erros = new ArrayList<String>();
		
		Integer codigoInt = null;
		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (NumberFormatException e) {
			codigoInt = null;
		}
		
		//Float precoCusto;
		//Float precoVenda;
		
		Agenda agenda = null;
		AgendaDAO daoAgenda = new AgendaDAO();
		try {
			agenda = daoAgenda.lerPorId(Integer.parseInt(idAgenda));
		} catch (NumberFormatException e) {
			agenda = null;
		}

		if (agenda == null)
			erros.add("O campo Agenda é obrigatório.");

		if ((nomePaciente == null) || (nomePaciente.isEmpty()))
			erros.add("O campo nome é obrigatório.");

		//try {
			//precoCusto = Float.parseFloat(custo);
		//} catch (NumberFormatException e) {
			//precoCusto = null;
			//erros.add("O valor do Preço de Custo é inválido.");
		//}

		//try {
			//precoVenda = Float.parseFloat(venda);
		//} catch (NumberFormatException e) {
			//precoVenda = null;
			//erros.add("O valor do Preço de Venda é inválido.");
		//}
			
		Paciente paciente = new Paciente(codigoInt, idAgenda, idAgenda, idAgenda, idAgenda, idAgenda, idAgenda);
		paciente.setAgenda(agenda);
		
		if (erros.isEmpty()) {
		
			PacienteDAO dao = new PacienteDAO();
			dao.salvar(paciente);
			
			response.sendRedirect("listarPacientes");
		}
		else
		{
			request.setAttribute("paciente", paciente);
			request.setAttribute("erros", erros);
			request.getRequestDispatcher("editarPaciente.jsp").forward(request, response);;
		}
	}
}
