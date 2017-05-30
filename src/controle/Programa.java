package controle;

import modelo.dao.PacienteDAO;
import modelo.dominio.Paciente;

public class Programa {

	public static void main(String[] args) {
		
		Paciente paciente = new Paciente();
		
		paciente.setCodPaciente(1);
		paciente.setNomePaciente("Anderson Herculano");
		
		PacienteDAO dao1 = new PacienteDAO();
		
		dao1.incluir(paciente);
	}

}
