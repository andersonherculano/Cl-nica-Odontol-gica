package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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
	 static final long serialVersionUID = 1L;
       
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
		
		 String codPaciente = request.getParameter("codPaciente");
		 String nomePaciente = request.getParameter("paciente");
		 String cpf = request.getParameter("cpf");
		 String rg = request.getParameter("rg");
		 String dtNasc = request.getParameter("dtNasc");
		 String telefone = request.getParameter("telefone");
		 String email = request.getParameter("email");
		 
		 String logradouro = request.getParameter("logradouro");
		 String numero = request.getParameter("numero");
		 String complemento = request.getParameter("complemento");
		 String bairro = request.getParameter("bairro");
		 String cidade = request.getParameter("cidade");
		 String cep = request.getParameter("cep");
		 
		List<String> erros = new ArrayList<String>();
		
		Integer codInt = null;
		try {
			codInt = Integer.parseInt(codPaciente);
		} catch (NumberFormatException e) {
			codInt = null;
		}
		
		if ((nomePaciente == null) || (nomePaciente.isEmpty()))
			erros.add("O campo nome é obrigatório.");
		if ((rg == null) || (rg.isEmpty()))
			erros.add("O campo nome é obrigatório.");
		if ((cpf == null) || (cpf.isEmpty()))
			erros.add("O campo cpf é obrigatório.");
		if ((dtNasc == null) || (dtNasc.isEmpty()))
			erros.add("O campo data de nascimento é obrigatório.");
		if ((telefone == null) || (telefone.isEmpty()))
			erros.add("O campo telefone é obrigatório.");
		if ((logradouro == null) || (logradouro.isEmpty()))
			erros.add("O campo logradouro é obrigatório.");
		if ((numero == null) || (numero.isEmpty()))
			erros.add("O campo número é obrigatório.");
		if ((cidade == null) || (cidade.isEmpty()))
			erros.add("O campo cidade é obrigatório.");
		if ((bairro == null) || (bairro.isEmpty()))
			erros.add("O campo bairro é obrigatório.");
		if ((cep == null) || (cep.isEmpty()))
			erros.add("O campo CEP é obrigatório.");
		
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
