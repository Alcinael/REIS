package servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.uepb.business.LoginBusiness;
import com.br.uepb.business.MedicoesBusiness;

public class ReceberDadosIcg extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = "";
		String senha = "";
		String xml = "";
		
		login = request.getParameter("login");
		senha = request.getParameter("senha");
		xml = request.getParameter("xml");
		
		PrintWriter out = response.getWriter();
		
		LoginBusiness loginBusiness = new LoginBusiness();
		MedicoesBusiness medicoesBusiness = new MedicoesBusiness();
		
		out.print("Conectado/ ");
		if (loginBusiness.loginValido(login, senha)){
			out.print("Login valido ");
			
			if (medicoesBusiness.medicaoIcgServlet(xml, login, senha)) {
				out.print("Medição ICG cadastrada com sucesso! \0/");
			}
			else {
				out.print("Medição ICG cadastrada sem sucesso!");
			}	
		}
		else {
			out.print("Login invalido");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
}
