<%@page import="java.sql.Date"%>
<%@page import="modelo.dominio.Paciente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="_estilos/estilo.css" type="text/css"/>
<title>Clínica Odontológica</title>
</head>

<jsp:useBean id="paciente" class="modelo.dominio.Paciente" 
		scope="request"></jsp:useBean>

<jsp:useBean id="endereco" class="modelo.dominio.Endereco" 
		scope="request"></jsp:useBean>
		
<body>
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
					<li><a href="usuario-logado.html">HOME</a></li>
					<li><a href="clientes-cadastrados.html">cadastro paciente</a></li>
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
			<p id="ficha">FICHA CADASTRAL</p>
	<form id="form-cliente" action="salvarPaciente" method="post">
		<input type="hidden" name="codigo" value="<%=paciente.getCodPaciente() %>">
		<aside>
		<div id="lado-esquerdo">
		<ul>
		<p>
			<li><label for="lnome">Nome Completo*</label>
			<br>
				<input type="text" name="paciente" value="<%=paciente.getCodPaciente() %>" size=60 maxlength=80 />
			</li>
			<br>
			<li><label for="crg">RG (Somente os números)</label>
			<br>
				<input id="crg" name="rg" size=23 value="<%=paciente.getRg() %>" maxlength=9 />
			</li>
			<br>
			<li><label for="ccpf">CPF* </label>
			<br>
				<input id="ccpf" name="cpf" value="<%=paciente.getCpf() %>" size=27 maxlength=14 title="Digite o CPF no formato 111.111.111-11"/>
			</li>
			<br>		
			<li><label for="cnasc">Data de Nascimento</label>
			<br>	
				<input type=<%="Date" %> id="cnasc" name="dtnasc" value="<%=paciente.getDtNasc() %>" />
			</li>
			<br>
			<li><label for="cmail">Email</label>
				<br>
				<input type="text" id="cmail" name="email" value="<%=paciente.getEmail() %>" size=50 />
			</li>
			<br>
			<li>
				<label for="ctel">Telefone* </label>
				<br>
				<input type="text" id="ctel" name="telefone" value="<%=paciente.getTelefone() %>" />
			</li>
			<br>
		</p>	
		</ul>
		</div>
		</aside>
		<articcle>
		<div id="lado-direito">
			<ul>
		<p id="endereco">
				<li><label for="cend">Endereço* </label>
			<br>
					<input type="text" id="cend" name="logradouro" value="<%=endereco.getLogradouro() %>" size=40 maxlength=120 />
				</li>
			<br>
				<li><label for="cnum">Número*</label>
			<br>
				<input type="text" id="cnum" name="numero" value="<%=endereco.getNumero() %>"size=5 />
				</li>
				<br>
				<li><label for="ccid">Cidade* </label>
				<br>
				<input type="text" id="ccid" name="cidade" value="<%=endereco.getCidade() %>"size=40 />
				</li>
			<br>
				<li><label for="cbairro">Bairro* </label>
				<br>
					<input type="text" id="cbairro" name="bairro" value="<%=endereco.getBairro() %>"size=30 />
				</li>
			<br>
				<li><label for="ccep">CEP* </label>
				<br>
					<input type="text" id="ccep" name="cep" value="<%=endereco.getCep() %>"size=15 />
				</li>
			<br>
				<li id="ccomp"><label for="ccomp">Complemento </label>
				<br>
					<input type="text" id="dcomp" name="complemento" value="<%=endereco.getComplemento() %>"size=50 />
				</li>
			<br>
			<li id="salvar">
				<input type="submit" value="Salvar">
			</li>
			<br>
			<li id="alterar">
				<input type="submit" value="Alterar">
			</li>
			<br>
			<li id="cancelar">
			<input type="submit" value="Cancelar" onclick="window.location='listarPaciente'">
			</li>
		</p>
		</ul>
		</div>
		</form>
		</div>
</body>
</html>