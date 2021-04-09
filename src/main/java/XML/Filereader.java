package XML;

import Visual.MainWindow;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class Filereader {
    private BufferedReader br;
    private ArrayList<String> args;
    private ArrayList<XML> xmlList;

    public Filereader(String path) {
        try {
            File file = new File(path);
            this.br = Files.newBufferedReader(Path.of(file.getPath()), StandardCharsets.UTF_8);
            this.args = new ArrayList<>(Arrays.asList(br.readLine().split(";")));
            String line = br.readLine();
            xmlList = new ArrayList<>();
            while (line != null) {
                xmlList.add(new XML(line,this.args));
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Failed to read the file");
        }

    }

    public void rightFiles() {
        File currentDirFile = new File(System.getProperty("user.dir"));
        File folder = new File(currentDirFile + File.separator + "Output");
        if (!folder.exists()) {
            folder.mkdir();
            MainWindow.log("Output folder created");
        }

        for (XML xml : xmlList) {
            File file = new File(currentDirFile + File.separator + "Output" + File.separator + xml.getMRNumber() + ".xml");

            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
                writer.write(xml.getLine());
                writer.close();
                MainWindow.addProgress();
                MainWindow.log(xml.getMRNumber() + " has been created");
            } catch (IOException ioe) {
                ioe.printStackTrace();
                return;
            }
        }
    }



    public ArrayList<XML> getXmlList() {
        return xmlList;
    }
}
