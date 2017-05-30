<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clínica Odontológica</title>
</head>
<body>
<div id="interface">
			<div id="cabecalho">
				<img src="_imagens/topo-logado.JPG" alt="Cabeçalho do Sistema" title="margem superior logado"/>
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
			<p id="ficha">FICHA CADASTRAL</p>
	<form id="form-cliente" action="salvarCliente" method="post">
		<div id="lado-esquerdo">
		<ul>
		<p>
			<li><label for="lnome">Nome Completo*</label>
			<br>
				<input required type="text" id="inome" size=60 maxlength=80 placeholder="Digite o nome completo" title="Digite um nome"/>
			</li>
			<br>
			<li><label for="crg">RG (Somente os números)</label>
			<br>
				<input id="crg" size=23 maxlength=9 placeholder="9 dígitos"></input>
			</li>
			<br>
			<li id="ccpf"><label for="ccpf">CPF* </label>
			<br>
				<input required="" id="dcpf" size=27 maxlength=14 placeholder="11 dígitos" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" title="Digite o CPF no formato 111.111.111-11"/>
			</li>
			<br>
			<li><label for="csexo">Sexo*</label>
			<br>
				<input type="radio" id="cmasc" value="M" checked><label for="cmasc"> Masculino</label></input>
			</li>
			<li>
				<input type="radio" id="cfem" value="F"><label for="cfem"> Feminino</label></input>
			</li>
			<br>		
			<li><label for="cnasc">Data de Nascimento</label>
			<br>	
				<input type="date" id="cnasc"></input>
			</li>
			<br>
			<li><label for="cresponsavel">Responsável* (Necessário para menores de idade)</label>
			<br>	
				<input type="text" id="cresponsavel" size=60 maxlength=60 placeholder="Digite o nome completo"></input>
			</li>
			<br>
			<li>Tipo de Plano* <select id="cplano">
				<option value="cv">Convênio</option>
				<option value="pc">Particular</option>
			</select>
			</li>
		</p>	
		</ul>
		</div>
		<div id="lado-direito">
			<ul>
		<p>
				<li><label for="cend">Endereço* </label>
			<br>
					<input type="text" id="cend" size=50 maxlength=120 placeholder="Rua, Travessa, Av."></input>
				</li>
			<br>
				<li id="cnum"><label for="cnum">Número* </label>
			<br>
					<input type="number" id="dnum" size=5 min="0" max="99999"></input>
				</li>
			<br>
				<li><label for="ccid">Cidade* </label>
				<br>
				<input type="text" id="ccid" size=40 placeholder="Sua cidade" list="cidades"></input>
				</li>
			<br>
				<li id="cbairro"><label for="cbairro">Bairro* </label>
				<br>
					<input type="text" id="dbairro" size=30 placeholder="Seu bairro" list="bairro"></input>
				</li>
			<br>
				<li><label for="ccep">CEP* </label>
				<br>
					<input type="text" required="" id="ccep" size=15 maxlenght=8 placeholder="8 números" pattern="\d{5}-?\d{3}" title="Digite o CEP neste formato: 11111-111"></input>
				</li>
			<br>
				<li id="ccomp"><label for="ccomp">Complemento </label>
				<br>
					<input type="text" id="dcomp" size=51 placeholder="Casa, apto, quadra, lote" list="complemento"></input>
				</li>
			<br>
			<li>
				<label for="cmail">Email</label>
				<br>
				<input type="email" id="cmail" size=50></input>
			</li>
			<br>
			<li>
				<label for="ctel">Telefone* </label>
				<br>
				<input required type="tel" id="ctel" pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{5}" title="Digite o telefone no seguinte formato: (xx) xxxx-xxxx"></input>
			</li>
			<br>
			<li id="ctel-cel">
				<label for="ctel-cel">Celular </label>
				<br>
				<input required type="tel" id="dtel-cel" pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{5}" title="Digite o telefone no seguinte formato: (xx)xxxx-xxxx"></input>
			</li>
			<br>
			<li>
				<input type=submit value=Salvar>
			</li>
			<br>
			<li id="Limpar">
				<input type=submit value=Alterar>
			</li>
		</p>
		</ul>
		</div>
		</form>
		</div>
</body>
</html>