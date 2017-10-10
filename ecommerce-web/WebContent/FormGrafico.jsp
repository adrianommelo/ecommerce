<%@ page  import="org.jfree.chart.*, org.jfree.chart.entity.*, org.jfree.data.*, org.jfree.data.category.*, org.jfree.chart.plot.*, java.io.*, java.awt.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
	final DefaultCategoryDataset ds = new DefaultCategoryDataset();
	ds.addValue(500, "Vendas", "São Paulo");
	ds.addValue(300, "Vendas", "Paraná");
	ds.addValue(350, "Vendas", "Rio de Janeiro");
	ds.addValue(250, "Vendas", "Minas Gerais");
	ds.addValue(100, "Vendas", "Bahia");
	
	JFreeChart grafico = ChartFactory.createLineChart("Quantidade de Vendas x Estado", "Estado", "Valor", ds, PlotOrientation.VERTICAL, true, true, false);
	
	//response.setContentType("image/PNG");
	//OutputStream sa = response.getOutputStream();
	final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
	
	final File file1 = new File(getServletContext().getRealPath(".") + "/resources/grafico.png");
	//ChartUtilities.writeChartAsPNG(sa, grafico, 600, 400);
	ChartUtilities.saveChartAsPNG(file1, grafico, 600, 400);
	
	//sa.close();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800"
	rel="stylesheet" type="text/css">

<!-- Bootstrap and Font Awesome css -->
<link rel="stylesheet" href="resources/css/font-awesome.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">

<!-- Css animations  -->
<link href="resources/css/animate.css" rel="stylesheet">

<!-- Theme stylesheet, if possible do not edit this stylesheet -->
<link href="resources/css/style.default.css" rel="stylesheet"
	id="theme-stylesheet">

<!-- Custom stylesheet - for your changes -->
<link href="resources/css/custom.css" rel="stylesheet">
<!-- Javascript -->
<script type="text/javascript" src="resources/js/wsViaCep.js">
	
</script>

</head>
<body>
	<div class="container">
		
		<div class="col-md-12">
		
			<div class="row">
				<div class="col-md-9">
					<h2 class="text-uppercase">Gráfico de Análise</h2>
					<hr>
				</div>
			</div>
			<!-- row -->
			<div class="row">
				<form class="form-group" action="SalvarGrafico" method="post">
					<div class="col-md-9">
						<div class="col-md-6">
							<img src="resources/grafico.png" WIDTH="600" HEIGHT="400" BORDER="0" USEMAP="#chart">									 						
						</div>
					</div>
	
					<div class="col-md-9">
						<div class="col-md-6">
							<div class="text-center">
								<br />
								<button type="submit" class="btn btn-success" id="operacao"
									name="operacao" value="SALVAR">SALVAR</button>
								<a type="submit" class="btn  btn-danger"
									href="FormConsultarCliente.jsp">VOLTAR</a>
							</div>
						</div>
					</div>
	
				</form>
				<!-- form -->
			</div>
			<!-- row -->
		</div>
	</div>
	<!-- /.container -->
</body>
</html>