# XMLGenerator
Ce logiciel à pour seul but de convertir et décomposé un fichier CSV (séparateur point virgule) en multiple fichier XML (un fichier par ligne) encodé en UTF-8.

## Step 1
Afin d'installer le logiciel, il suffit de télécharger la dernière **release** et de le mettre dans un dossier crée spécialement pour son utilisation.

## Step 2
Afin de l'éxécuter, déplacer votre CMD (Linux/Windows) dans le dossier ou se trouve le *.jar*. Puis éxécuter le logiciel avec cette commande :
```java
java -jar XMLGenerator.jar
```

## Step 3
Une fois éxécuter le logiciel vas venir détecter les fichier se trouvant au même endroit que lui.
**IMPORTANT :** Toujours mettre les csv avec lesquelles vous travailler dans le même répertoire que le logiciel.
```
|------------JMSCreator------------|
Detected file: JMSCreator.jar
Detected file: Output
Detected file: Part1.csv
Detected file: Part2.csv
Detected file: Part3.csv

Please enter file path:
```

Il vous suffit d'écrire le nom du csv avec lequel le logiciel doit travailler et le programme se lancera :  
```Part1.csv```  
et le programme commencera le traitement :
```
test0 has been created
test1 has been created
test2 has been created
test3 has been created
test4 has been created
test5 has been created
test6 has been created
test7 has been created
test8 has been created
test9 has been created
...
```

## Step 4
Une fois l'éxécution terminé, un nouveau dossier sera apparu (si il n'est pas déja crée) sous le nom *Output* et contiendra tous les fichiers générés.
