package TaskManager;

import Visual.MainWindow;
import XML.Filereader;

import javax.swing.*;

public class Task {
    private Thread thread;
    private Filereader fr;
    private boolean done;

    public Task(String path) {
        this.thread = new Thread(new Process());
        this.fr = new Filereader(path);
        this.done = false;
    }

    public void run() {
        this.thread.start();

    }

    private void taskTerminated() {
        JOptionPane jop1;
        jop1 = new JOptionPane();
        jop1.showMessageDialog(null, "Generation complete ! " + this.getSize() + " files have been righted.", "Finish", JOptionPane.INFORMATION_MESSAGE);

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
            MainWindow.log("Process terminated in " + timeInMin + "m" + timeInSec + "s" + " !");
            taskTerminated();
        }

    }
}
