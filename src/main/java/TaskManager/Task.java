package TaskManager;

import XML.FileReader;
import XML.XMLGenerator;

import javax.swing.*;


public class Task {

    private final Thread thread;
    private final FileReader fr;

    public Task(String path) {
        this.thread = new Thread(new Process());
        this.fr = new FileReader(path);
    }

    public void run() {
        this.thread.start();

    }

    private void taskTerminated() {
        JOptionPane.showMessageDialog(null, "Generation complete ! " + this.getSize() + " files have been righted.", "Finish", JOptionPane.INFORMATION_MESSAGE);

    }

    public int getSize() {
        return this.fr.getXmlList().size();
    }

    class Process implements Runnable {
        public void run() {
            long time = System.currentTimeMillis();
            fr.rightFiles();
            int remainingSec = (int) ((System.currentTimeMillis() - time) / 1000);
            int timeInSec = (remainingSec % 60);
            int timeInMin = (remainingSec % 3600) / 60;
            XMLGenerator.getFrameHandler().getMainFrame().log("Process terminated in " + timeInMin + "m" + timeInSec + "s" + " !");
            taskTerminated();
            XMLGenerator.getFrameHandler().getMainFrame().resetFrame();
        }

    }
}
