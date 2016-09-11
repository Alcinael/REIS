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
package application;

/**
 * Classe que armazena as informa��es que ser�o enviadas para a aplica��o reis-web
 */
public class Aplicacao {

	/** Representa��o do objeto PortaSerial */
	public static PortaSerial portaSerial = new PortaSerial();
	/** Informa��es obtidas do dispositivo */
	public static String dados = "";
	/** Armazena a ultima leitura realizada para que o usu�rio possa enviar os dado mais recentes */
	public static String ultimosDadosRecebidos = ""; 
	/** Armazena todas as leituras  realizadas no ox�metro durante o momento de utiliza��o */
	public static String historicoDeLeitura = ""; 

	/** Login do paciente */
	public static String login = "";
	/** Senha do paciente */
	public static String senha = "";
	/** Hor�rio atual da medi��o */
	public static String hora;
	/** Informa��o referente a porcentagem de spO2  */
	public static String porcentagem;
	/** Informa��o referente a taxa de pulso */
	public static String saturacao;

	public Aplicacao() { }

	/**
	 * M�todo que limpa o conte�do das vari�veis
	 */
	public static void limparDados() {
		dados = "";
		ultimosDadosRecebidos = "";
		historicoDeLeitura="";
		login="";
		senha="";
		hora = "";
		porcentagem="";
		saturacao="";		
	}
}
