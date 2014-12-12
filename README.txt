Instructions pour lancer l'application Client - Server 
------------------------------------------------------
Avant de commencer verifier que vous disposez d'un IDE eclipse avec JavaSE-1.7 installé

1) Importer les 3 projets (M2 - M1 - M0) sous le workspace de votre IDE.
2) Aller dans le repertoire src du projet M0.
3) Deplier le package hadl.main.
4) Ouvrir la class Launcher.java.
5) Faire un click droit sur la class => 
					Run As => 
						 Java Application

6) La console vous affiche la trace d'exécution de l'application dépuis 
   l'expédition de la requête par le client jusqu'à la reception de la reponse.

7) Vous trouverez dans le repertoire Repository du même projet le fichier de log (log.txt)
   qui contient la trace archivée de l'exécution ainsi que le fichier de donnée (database_file.xml)
   utilisé pour les tests.