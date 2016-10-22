<%@ include file="/WEB-INF/views/includeTags.jsp"%>
	
<div class="mdl-grid">
<div class="row">
	<div class="mdl-cell mdl-cell--12-col"  style="position: absolute;">	
		<div class="col-md-2 col-xs-12 text-center">
			<div class="row">
				<div class="col-md-12 col-xs-4">  				
		  			<div class="panel-body reis-img reis-verde-NUTES h4-small text-center">
		  				<a class="reis-cor-azulEscuro" href="#div_icg" data-toggle="tab" aria-expanded="false" onclick="img_monitorClick()">
		  					<br>  
				  			<img class='img-responsive' id="img-monitor" width="90px" height="90px"
								src='../images/disp_monitor_cor.png' style="margin: auto;"/>
								ICG Monitor
						</a>
					</div>
				</div>
				
				<div class="col-md-12 col-xs-4">  				
		  			<div class="panel-body reis-img reis-verde-NUTES h4-small text-center">
		  				<a class="reis-cor-azulEscuro" href="#div_balanca" data-toggle="tab" aria-expanded="false" onclick="img_balancaClick()">
		  					<br>  
				  			<img class='img-responsive' id="img-balanca" width="90px" height="90px"
								src='../images/disp_balanca.png' style="margin: auto;"/>
								Balança
						</a>
					</div>
				</div>
				<div class="col-md-12 col-xs-4">			  				
		  			<div class="panel-body reis-img reis-verde-NUTES h4-small text-center">
		  				<a class="reis-cor-azulEscuro" href="#div_oximetro" data-toggle="tab" aria-expanded="false" onclick="img_oximetroClick()">  
				  			<img class='img-responsive' id="img-oximetro" width="65px" height="65px"
								src='../images/disp_oximetro.png' style="margin: auto;"/>
								Oximetro
						</a>
					</div>
				</div>
				<div class="col-md-12 col-xs-4">	  				
		  			<div class="panel-body reis-img reis-verde-NUTES h4-small text-center">
		  				<a class="reis-cor-azulEscuro" href="#div_pressao" data-toggle="tab" aria-expanded="false" onclick="img_pressaoClick()">
		  					<br>  
				  			<img class='img-responsive' id="img-pressao" width="90px" height="90px"
								src='../images/disp_pressao.png' style="margin: auto;"/>
								Pressão
						</a>
					</div>
				</div>
			</div>
		</div>
		
		<div class="col-md-10">
			<div class="col-md-12">
				<div id="myTabContent" class="tab-content">
					<!-- Tabela Monitor -->
					<div class="tab-pane fade active in" id="div_icg">
		    			<div class="h6 reis-div-top"> Histórico de medições - ICG Monitor </div> <hr>
		    			<div class="col-md-10">		
							<table class="mdl-data-table mdl-js-data-table">		
								<thead>
									<tr style="background-color:#81CFE0; color:#fff">
										<th style=" color:#fff">Data e Hora</th>
										<th style=" color:#fff">Frequencia Cardiaca</th>
										<th style=" color:#fff">Frequencia Respiratoria</th>
										<th style=" color:#fff">Debito Cardiaco</th>
										<th style=" color:#fff">Indice Cardiaco</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="icg" varStatus="status" items="${historicoIcg}">
										<tr>
											<td>${icg.dataHoraFormatada}</td>
											<td>${icg.frequenciaCardiaca} ${icg.frequenciaCardiacaUnidade}</td>
											<td>${icg.frequenciaRespiratoria} ${icg.frequenciaRespiratoriaUnidade}</td>
											<td>${icg.debitoCardiaco} ${icg.debitoCardiacoUnidade}</td>
											<td>${icg.indiceCardiaco} ${icg.indiceCardiacoUnidade}</td> 
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
		  			</div>
					
		  			<!-- Tabela balança -->
					<div class="tab-pane fade" id="div_balanca">
		    			<div class="h6 reis-div-top"> Histórico de medições - Balança </div> <hr>
		    			<div class="col-md-10">		
							<table class="mdl-data-table mdl-js-data-table">		
								<thead>
									<tr style="background-color:#37BC9B; color:#fff">
										<th style=" color:#fff">Data e Hora</th>
										<th style=" color:#fff">Peso</th>
										<th style=" color:#fff">Altura</th>
										<th style=" color:#fff">IMC</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="balanca" varStatus="status" items="${historicoBalanca}">
										<tr>
											<td>${balanca.dataHoraFormatada}</td>
											<td>${balanca.peso} ${balanca.pesoUnidade}</td>
											<td>${balanca.altura} ${balanca.alturaUnidade}</td>
											<td>${balanca.massa} ${balanca.massaUnidade}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
		  			</div>
		  			
		  			<!-- Tabela oximetro -->
		  			<div class="tab-pane fade" id="div_oximetro">
		    			<div class="h6 reis-div-top"> Histórico de medições - Oxímetro de Pulso </div> <hr>
		    			<div class="col-md-10">		
							<table class="mdl-data-table mdl-js-data-table">
								<thead>
									<tr style="background-color:#F6BB42; color:#fff">
										<th style=" color:#fff">Data e Hora</th>
										<th style=" color:#fff">SPO2</th>
										<th style=" color:#fff">Taxa de Pulso</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="oximetro" varStatus="status" items="${historicoOximetro}">
										<tr>
											<td>${oximetro.dataHoraFormatada}</td>
											<td>${oximetro.spo2} ${oximetro.spo2Unidade}</td>
											<td>${oximetro.taxaPulso} ${oximetro.taxaPulsoUnidade}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>							
						</div>
		  			</div>  			
		  			
		  			<!-- Tabela pressao -->		
		  			<div class="tab-pane fade" id="div_pressao">
		    			<div class="h6 reis-div-top"> Histórico de medições - Medidor de Pressão Arterial </div> <hr>
		    			<div class="col-md-10">		
							<table class="mdl-data-table mdl-js-data-table">
								<thead>
									<tr style="background-color:#DA4453; color:#fff">
										<th style=" color:#fff">Data e Hora</th>
										<th style=" color:#fff">Pressão Sistólica</th>
										<th style=" color:#fff">Pressão Diastólica</th>
										<th style=" color:#fff">Pressão Média</th>
										<th style=" color:#fff">Taxa de Pulso</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="pressao" varStatus="status" items="${historicoPressao}">
										<tr>
											<td>${pressao.dataHoraFormatada}</td>
											<td>${pressao.pressaoSistolica} ${pressao.pressaoSistolicaUnidade}</td>
											<td>${pressao.pressaoDiastolica} ${pressao.pressaoDiastolicaUnidade}</td>
											<td>${pressao.pressaoMedia} ${pressao.pressaoMediaUnidade}</td>
											<td>${pressao.taxaPulso} ${pressao.taxaPulsoUnidade}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>							
						</div>
		  			</div>
					
				</div>
			</div>
		</div>
				
	</div>
</div>
</div>
 
<script src="../js/flat-ui-reis/flat-ui-reis.js"></script>

<script>
	function img_monitorClick() {
		document.getElementById("img-monitor").src="../images/disp_monitor_cor.png";
		document.getElementById("img-balanca").src="../images/disp_balanca.png";
		document.getElementById("img-oximetro").src="../images/disp_oximetro.png";
		document.getElementById("img-pressao").src="../images/disp_pressao.png";
	}

	function img_balancaClick() {
		document.getElementById("img-monitor").src="../images/disp_monitor.png";
		document.getElementById("img-balanca").src="../images/disp_balanca_cor.png";
		document.getElementById("img-oximetro").src="../images/disp_oximetro.png";
		document.getElementById("img-pressao").src="../images/disp_pressao.png";
	}
	
	function img_oximetroClick() {
		document.getElementById("img-monitor").src="../images/disp_monitor.png";
		document.getElementById("img-balanca").src="../images/disp_balanca.png";
		document.getElementById("img-oximetro").src="../images/disp_oximetro_cor.png";
		document.getElementById("img-pressao").src="../images/disp_pressao.png";
	}
	
	function img_pressaoClick() {
		document.getElementById("img-monitor").src="../images/disp_monitor.png";
		document.getElementById("img-balanca").src="../images/disp_balanca.png";
		document.getElementById("img-oximetro").src="../images/disp_oximetro.png";
		document.getElementById("img-pressao").src="../images/disp_pressao_cor.png";
	}
</script>
