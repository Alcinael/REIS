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
package business;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//REIS para qual os dados serão enviados
/**
 * Classe que salva os dados de configura��o do reisComunicacaoSerial.
 * O login, a senha e a URL da p�gina do REIS(web) para onde os dados ser�o enviados.
 */
public class SalvarLogin {
	/** Caminho onde ser�o armazenadas(localmente) as informa��es do REIS para envio */
	String caminhoSave = "";
	/** nome da pasta de backup*/
	File pastaBackup;
	
	/**
	 * M�todo para salvar as informa��es do login do paciente
	 */
	public SalvarLogin() {	
		File file2 = new File(".");
		
		try {
			caminhoSave = file2.getCanonicalPath()+"/save/";
		} catch (IOException e1) {
			caminhoSave = System.getProperty("user.home")+"/Documents/save/";
		}
		
		pastaBackup= new File(caminhoSave);
		pastaBackup.mkdirs();
				
		 
	}
	
	/**
	 * M�todo para salvar as informa��es do login do paciente
	 * @param objeto Representa��o do objeto LoginDomain
	 * @return String Caminho(local) onde a informa��o do login ficou salva
	 */
	public String salvar(Object objeto){
		  try {
			  FileOutputStream saveFile = new FileOutputStream(caminhoSave+"/loginDomain.reis");
	          ObjectOutputStream stream = new ObjectOutputStream(saveFile);
	 
	          // salva o objeto
	          stream.writeObject(objeto);
	 
	          stream.close();
	      } catch (Exception exc) {
	    	  exc.printStackTrace();
	      }
		  return pastaBackup.getAbsolutePath();
	  }

}