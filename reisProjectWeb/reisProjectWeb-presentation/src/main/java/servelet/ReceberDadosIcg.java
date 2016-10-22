package servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.uepb.business.LoginBusiness;
import com.br.uepb.dao.MedicaoIcgDAO;
import com.br.uepb.dao.MedicaoOximetroDAO;
import com.br.uepb.model.MedicaoIcgDomain;
import com.br.uepb.model.MedicaoOximetroDomain;

public class ReceberDadosIcg extends HttpServlet{
	
	public ReceberDadosIcg(){
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = "";
		String senha = "";
		String hora = "";
		String debCardiaco = "";
		String indCardiaco = "";
		String freqRespiratoria = "";
		String freqCardiaca = "";
		login = request.getParameter("login");
		senha = request.getParameter("senha");
		hora = request.getParameter("hora");
		debCardiaco = request.getParameter("debCardiaco");
		indCardiaco = request.getParameter("indCardiaco");
		freqRespiratoria = request.getParameter("freqRespiratoria");
		freqCardiaca = request.getParameter("freqCardiaca");
		PrintWriter out = response.getWriter();
		LoginBusiness loginBusiness = new LoginBusiness();
		if(loginBusiness.loginValido(login, senha)){
			MedicaoIcgDomain icgDomain = new MedicaoIcgDomain();
			MedicaoIcgDAO icgDAO = new MedicaoIcgDAO();
			icgDomain.setDataHora(new Date());
			icgDomain.setPaciente(loginBusiness.getPaciente(login, senha));
			icgDomain.setFrequenciaCardiaca(Double.parseDouble(freqCardiaca));
			icgDomain.setFrequenciaCardiacaUnidade("bpm");
			icgDomain.setFrequenciaRespiratoria(Double.parseDouble(freqRespiratoria));
			icgDomain.setFrequenciaRespiratoriaUnidade("ipm");
			icgDomain.setIndiceCardiaco(Double.parseDouble(indCardiaco));
			icgDomain.setIndiceCardiacoUnidade("L/min.m²");
			icgDomain.setDebitoCardiaco(Double.parseDouble(debCardiaco));
			icgDomain.setDebitoCardiacoUnidade("L/min");
			icgDAO.salvaMedicaoIcg(icgDomain);
			out.print("sucesso");//É usuário cadastrado
		 }else{
			out.print("erro");//Não é usuário cadastrado
		 }
	}
	
}
