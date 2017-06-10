<%@page import="modelo.dominio.Endereco"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.dominio.Paciente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="_estilos/estilo.css" type="text/css"/>
<title>Cadastro de Paciente</title>
<script type="text/javascript">
function excluir(codigo)
{
	if (confirm('Deseja realmente inativar este paciente?'))
		window.location = 'excluirPaciente?codigo=' + codigo;
}
</script>
</head>
<body>
<%
	List<Paciente> lista = (List<Paciente>)request.getAttribute("lista");
	if (lista == null)
		lista = new ArrayList<Paciente>();
%>

<%
	List<Endereco> lista1 = (List<Endereco>)request.getAttribute("lista1");
	if (lista1 == null)
		lista1 = new ArrayList<Endereco>();
%>

<div id="interface">
	<header>
		<div id="cabecalho">
				<img src="_imagens/topo-logado.jpg" alt="Cabeçalho do Sistema" title="margem superior logado" />
				<a href="#inome" id="cprincipal">Ir para o conteúdo principal</a>
			</div>
			<div id="sair">
				<a id="sair" href="index.html">Sair</a>
			</div>
			<nav id="menu">
				<ul>
					<li><a href="index.jsp">home</a></li>
					<li><a href="listarPacientes.jsp">cadastro paciente</a></li>
					<li><a href="anamnese.html">anamnese</a></li>
					<li><a href="odontograma.html">odontograma</a></li>
					<li><a href="orcamento.html">orçamento</a></li>
					<li><a href="pagamentos.html">pagamentos</a></li>
					<li><a href="agendamento.html">agendamento</a></li>
					<li><a href="relatorios.html">relatórios</a></li>
				</ul>
			</nav>
		</header>
		<br>
		<br>
		<br>
		<br>
		<br>
<article>
	<div id="tab-pacientes">
		<form id="form-novo" action="abrirInclusaoPaciente" method="get">
			<input type="submit" value="Novo Paciente" />
		</form>
		<br>
		<table border="1" cellpadding="5" cellspacing="0"> 
			<tr>
				<td>Código</td>
				<td>Paciente</td>
				<td>RG</td>
				<td>CPF</td>
				<td>Data Nascimento</td>
				<td>Email</td>
				<td>Telefone</td>
				<td>Logradouro</td>
				<td>Número</td>
				<td>Complemento</td>
				<td>Bairro</td>
				<td>Cidade</td>
				<td>CEP</td>
			</tr>
			<%
			for (Paciente paciente : lista) {
			%>
				<tr>
					<td><a href="editarPaciente?codigo=<%=paciente.getCodPaciente()%>">Alterar</a>
					    <a href="#" onclick="excluir('<%=paciente.getCodPaciente()%>');">Excluir</a>
					</td>
					<td><%=paciente.getCodPaciente()%></td>
					<td><%=paciente.getNomePaciente()%></td>
					<td><%=paciente.getRg()%></td>
					<td><%=paciente.getCpf()%></td>
					<td><%=paciente.getDtNasc()%></td>
					<td><%=paciente.getEmail()%></td>
					<td><%=paciente.getTelefone()%></td>
				</tr>
			<%	}
			%>
			
			<%
			for (Endereco endereco : lista1) {
			%>
				<tr>
					<td><%=endereco.getLogradouro()%></td>
					<td><%=endereco.getNumero()%></td>
					<td><%=endereco.getComplemento()%></td>
					<td><%=endereco.getBairro()%></td>
					<td><%=endereco.getCidade()%></td>
					<td><%=endereco.getCep()%></td>	
				</tr>
			<%	}
			%>
		</table>
	</div>
</article>
</body>
</html>