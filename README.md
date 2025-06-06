# SerenaApi
Progetto per accedere alle API di Serena

per accedere alle librerie javascript:

file:///C:/Program%20Files%20(x86)/Micro%20Focus/Dimensions%2014.6/CM/java_api/index.html

per poterlo compilare servono le librerie, librerie che si trovano nel pacchetto: dimensions_cm_14.6.0_eclipse.zip

Pacchetto che si scarica da Tportal, alla voce utility, documentazione.

Le librerie sono:

	<classpathentry kind="lib" path="C:/ZZ-SoftwareFactory-0-Sviluppo/SERENA/serena/darius.jar"/>
	<classpathentry kind="lib" path="C:/ZZ-SoftwareFactory-0-Sviluppo/SERENA/serena/dmclient.jar"/>
	<classpathentry kind="lib" path="C:/ZZ-SoftwareFactory-0-Sviluppo/SERENA/serena/dmcore.jar"/>
	<classpathentry kind="lib" path="C:/ZZ-SoftwareFactory-0-Sviluppo/SERENA/serena/dmfile.jar"/>
	<classpathentry kind="lib" path="C:/ZZ-SoftwareFactory-0-Sviluppo/SERENA/serena/dmnet.jar"/>
	<classpathentry kind="lib" path="C:/ZZ-SoftwareFactory-0-Sviluppo/SERENA/serena/dmzstd.jar"/>
	<classpathentry kind="lib" path="C:/ZZ-SoftwareFactory-0-Sviluppo/SERENA/serena/slf4j-api-1.7.25.jar"/>

il progetto crea, a partire da un report delle schede, un csv contenete le associazioni e un file contenete i comandi da eseguire da client 

il client si lancia con:

dmcli -user TL001023 -pass pwd -host pvcsnew.telecomitalia.local:1055 -dbname UNICA -dsn pcms	

al prompt si esegue:

CMD c:\Temp\report.txt

il file contiene la lista di comandi:

BC UNICAC_CS_1486 /FILENAME=UNICAC_CS_1486.doc 