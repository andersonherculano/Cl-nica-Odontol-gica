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
		@SuppressWarnings("unused")
		String rg = request.getParameter("rg");
		@SuppressWarnings("unused")
		String cpf = request.getParameter("cpf");
		@SuppressWarnings("unused")
		String dtNasc = request.getParameter("dtnasc");
		@SuppressWarnings("unused")
		String telefone = request.getParameter("telefone");
		@SuppressWarnings("unused")
		String email = request.getParameter("email");
		@SuppressWarnings("unused")
		String logradouro = request.getParameter("logradouro");
		@SuppressWarnings("unused")
		String numero = request.getParameter("numero");
		@SuppressWarnings("unused")
		String complemento = request.getParameter("complemento");
		@SuppressWarnings("unused")
		String bairro = request.getParameter("bairro");
		@SuppressWarnings("unused")
		String cidade = request.getParameter("cidade");
		@SuppressWarnings("unused")
		String cep = request.getParameter("cep");
		String idAgenda = request.getParameter("idAgenda"); 
		
		List<String> erros = new ArrayList<String>();
		
		Integer codigoInt = null;
		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (NumberFormatException e) {
			codigoInt = null;
		}
		
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
			
		Paciente paciente = new Paciente();
		
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
