package TaskManager;

import XML.Filereader;

public class Task {
    private Thread thread;
    private int progress;
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

    public Thread getThread() {
        return thread;
    }

    public int getProgress() {
        return progress;
    }

    public int getSize() {
        return this.fr.getXmlList().size();
    }

    class Process implements Runnable {
        public void run() {
            fr.rightFiles();
        }
    }
}
