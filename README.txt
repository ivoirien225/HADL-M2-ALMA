Instructions pour lancer l'application Client - Server 
------------------------------------------------------
Avant de commencer verifier que vous disposez d'un IDE eclipse avec JavaSE-1.7 install�

1) Importer les 3 projets (M2 - M1 - M0) sous le workspace de votre IDE.
2) Aller dans le repertoire src du projet M0.
3) Deplier le package hadl.main.
4) Ouvrir la class Launcher.java.
5) Faire un click droit sur la class => 
					Run As => 
						 Java Application

6) La console vous affiche la trace d'ex�cution de l'application d�puis 
   l'exp�dition de la requ�te par le client jusqu'� la reception de la reponse.

7) Vous trouverez dans le repertoire Repository du m�me projet le fichier de log (log.txt)
   qui contient la trace archiv�e de l'ex�cution ainsi que le fichier de donn�e (database_file.xml)
   utilis� pour les tests.