Extens�o do REIS para leitura de dados do Ox�metro atrav�s da porta serial

Para o funcionamento adequado desta extens�o do REIS o computador deve estar configurado de forma adequada.
As restri��es para o devido funcionamento s�o:

O computador deve estar com a M�quina virtual java instalada.
A vers�o Java utilizada foi 1.8.0_101
A m�quina virtual deve ser a vers�o de 32bits devido a limita��o da API de comunica��o Serial da Oracle � Javacomm, 
visto que uma DLL est� dispon�vel apenas para a referida vers�o.

A API Javacomm deve estar corretamente configurada, para configurar siga os passos:
 - Baixe e Copie o arquivo comm.jar para C:\Program Files (x86)\Java\jre1.8.0_101\lib\ext
 - Configure o classpath para que reconhe�a o arquivo comm.jar 
 - Baixe e Copie o arquivo javax.comm.properties para C:\Program Files (x86)\Java\jre1.8.0_101\lib
 - Baixe e Copie o arquivo win32com.dll para C:\Program Files (x86)\Java\jre1.8.0_101\bin
 - Caso necess�rio, configure o projeto para reconhecer a biblioteca comm.jar

Verifique se o projeto executa normalmente no eclipse