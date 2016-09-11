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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.comm.CommPortIdentifier;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;

public class PortaSerial implements SerialPortEventListener {
	// Declara��o de variaveis global
	static CommPortIdentifier portId; // Classe para identificar a porta serial
	static Enumeration portList; // Lista com todas as portas seriais
	static OutputStream outputStream; // escreve
	static InputStream inputStream; // l�
	static SerialPort serialPort;
	public static String lendoDados = "";
	private boolean ehPortaSerial = false;

	public PortaSerial() {
		
	}
	@Override
	/**
	 * M�todo extendido da Classe SerialPortEvent Listener.
	 * Ao ser chamado, este m�todo ir� carregar todas as informa��es do ox�metro atrav�s da porta serial
	 * para uma vari�vel local.
	 */
	public void serialEvent(SerialPortEvent evento) {
		switch (evento.getEventType()) {
		case SerialPortEvent.BI:
		case SerialPortEvent.OE:
		case SerialPortEvent.FE:
		case SerialPortEvent.PE:
		case SerialPortEvent.CD:
		case SerialPortEvent.CTS:
		case SerialPortEvent.DSR:
		case SerialPortEvent.RI:
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			break;
		case SerialPortEvent.DATA_AVAILABLE: //Quando dados estiverem dispon�veis para leitura
			  try {
					byte[] bufferLeitura = new byte[30];//Buffer que ser� usado para armazenar os dados recebidos do ox�metro. 
					inputStream.read(bufferLeitura);
					while (inputStream.available()>0) {
						int n = inputStream.read(bufferLeitura);
						
					}
					for (int i = 0; i < bufferLeitura.length; i++) {
						if(bufferLeitura[i]!=bufferLeitura[bufferLeitura.length-1])
							this.lendoDados += (char) bufferLeitura[i];
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}
		
		
	}
	
	/**
	 * M�todo que fecha a conex�o da porta serial, e limpa as vari�veis.
	 */	
	public void fecharPorta(){
		ehPortaSerial = false;
		lendoDados = "";
		Aplicacao.limparDados();
		Aplicacao.portaSerial = new PortaSerial();
		if(serialPort!=null)
		serialPort.close();
	}
	
	/**
 	 * M�todo qe busca uma porta serial na qual o Ox�metro esteja conectado.
	 */
	public boolean abrirPorta(){
		try {
			portList = CommPortIdentifier.getPortIdentifiers();//Lista todas as portas seriais do computador
			while (portList.hasMoreElements()) {
				portId = (CommPortIdentifier) portList.nextElement();
				if (portId.getName().substring(0, 3).equals("COM") && portaFunciona()) {//Verifica se a porta serial x encontrada funciona. Caso tenha mais de uma porta serial conectada, altere aqui para garantir que a porta desejada seja aberta.
					ehPortaSerial = true;
					break;
				}
			}
			// Declara��o gen�rica
		} catch (Exception ex1) {
			return false;
		}

		
		 return ehPortaSerial;
	}
	
	/**
 	 * M�todo que verifica se a transmiss�o de dados pela porta serial funciona.
	 */
	public boolean portaFunciona(){
		try {
			serialPort = (SerialPort) portId.open("serial12App", 3000);
		} catch (PortInUseException e) {
			return false;
		}

		try {
			serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
		} catch (Exception e) {
			return false;
		}

		try {
			inputStream = serialPort.getInputStream();
		} catch (Exception e) {
			return false;
		}
		try {
			serialPort.addEventListener(this);
		} catch (Exception e) {
			return false;
		}

		serialPort.notifyOnDataAvailable(true);
		 try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {}
		 return true;
	}
}
