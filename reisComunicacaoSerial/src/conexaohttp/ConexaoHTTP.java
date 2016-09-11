/*
The MIT License (MIT)
Copyright (c) 2016 N�cleo de Tecnologias Estrat�gicas em Sa�de (NUTES)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions 
of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED 
TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
DEALINGS IN THE SOFTWARE. 
*/
package conexaohttp;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import application.Aplicacao;
import business.RecuperarLogin;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.LoginDomain;

/**
 * Classe para realizar a conex�o com o servidor REIS
 */
public class ConexaoHTTP {
	
	/**
	 * M�todo para enviar os dados para o sistema REIS.
	 * @param login Nome de usu�rio cadastrado no REIS
	 * @param senha Senha do usu�rio definida no REIS
	 * @param hora Hora que a leitura dos dados foi feita no Ox�metro
	 * @param porcentagem Valor da satura��o que foi lida do Ox�metro
	 * @param saturacao Taxa de pulso que foi lida do Ox�metro
	 * @return Retorna true se conseguir enviar a leitura do dispositivo para o sistema REIS
	 * e false caso contr�rio.
	 */
	public boolean enviar(String login, String senha, String hora, String porcentagem, String saturacao){
		
		try {
			LoginDomain loginDomain = new RecuperarLogin().getSave();
			String link = loginDomain.getLink()+"?"
					+"login="+login
					+"&senha="+senha
					+"&hora="+hora
					+"&porcentagem="+porcentagem
					+"&saturacao="+saturacao;
			System.out.println(link);
			URL url = new URL(link);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

			String line = in.readLine();
			in.close();
			httpURLConnection.disconnect();
			if(line.equals("sucesso")){
				return true;
			}
		} catch (IOException e) {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setContentText("Falha ao enviar as informa��es. N�o foi poss�vel se conectar ao REIS!");
			alert.setTitle("REIS");
			alert.setHeaderText(null);
			alert.showAndWait();
			return false;
		}

		Alert alert = new Alert(AlertType.WARNING);
		alert.setContentText("O login ou a senha informado � inv�lido!");
		alert.setTitle("REIS");
		alert.setHeaderText(null);
		alert.showAndWait();
		return false;
	}
}
