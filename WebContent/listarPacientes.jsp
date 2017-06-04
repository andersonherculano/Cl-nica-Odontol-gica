<%@page import="java.util.ArrayList"%>
<%@page import="modelo.dominio.Paciente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Produtos</title>
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

<h1>Cadastro de Pacientes</h1>

<a href="abrirInclusaoPaciente">Novo Produto</a>

<table border="1" cellpadding="5" cellspacing="0"> 
	<tr>
		<td>Opções</td>
		<td>Código</td>
		<td>Descrição</td>
		<td>Preço de Custo</td>
		<td>Preço de Venda</td>
	</tr>
<%
for (Produto produto : lista) {
%>
	<tr>
		<td><a href="editarProduto?codigo=<%=produto.getCodigo()%>">Alterar</a>
		    <a href="#" onclick="excluir('<%=produto.getCodigo()%>');">Excluir</a>
		</td>
		<td><%=produto.getCodigo()%></td>
		<td><%=produto.getDescricao()%></td>
		<td><%=produto.getPrecoCustoStr()%></td>
		<td><%=produto.getPrecoVendaStr()%></td>
	</tr>
<%	}
%>
</table>

</body>
</html>