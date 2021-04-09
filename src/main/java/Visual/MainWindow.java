package Visual;

import TaskManager.Task;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainWindow extends JFrame implements ActionListener {
    private final JPanel window = new JPanel();

    private JButton fileNavigator = new JButton("...");
    private JButton process = new JButton("Start process");
    private JButton preview = new JButton("Preview");
    private JTextArea filePath = new JTextArea();
    private static JTextArea log = new JTextArea();
    private static JProgressBar bar = new JProgressBar();
    private Task task;


    public MainWindow() {
        this.setTitle("XMLConvertor");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel fileBox = new JPanel();
        fileBox.setLayout(new BoxLayout(fileBox, BoxLayout.LINE_AXIS));
        fileBox.add(new JLabel("Choose file :"));
        filePath.setEditable(false);
        filePath.setText("No file selected");
        fileBox.add(filePath);
        fileNavigator.addActionListener(this);
        fileBox.add(fileNavigator);
        this.getContentPane().add(fileBox, BorderLayout.NORTH);

        JPanel processBox = new JPanel();
        process.addActionListener(this);
        processBox.add(process);
        processBox.add(preview);
        this.getContentPane().add(processBox, BorderLayout.CENTER);

        JPanel progressBox = new JPanel();
        progressBox.setLayout(new BoxLayout(progressBox, BoxLayout.PAGE_AXIS));
        log.setEditable(false);
        progressBox.add(log);
        bar.setValue(0);
        bar.setVisible(false);
        progressBox.add(bar);
        this.getContentPane().add(progressBox, BorderLayout.SOUTH);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fileNavigator) {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            jfc.setCurrentDirectory(new File(System.getProperty("user.dir")));
            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                filePath.setText(selectedFile.getAbsolutePath());
            }
        }
        if (e.getSource() == process) {
            bar.setVisible(true);
            this.task = new Task(this.filePath.getText());
            bar.setMaximum( this.task.getSize());
            task.run();
        }
    }


    public static void addProgress() {
        bar.setValue(bar.getValue() + 1);
        bar.setVisible(true);
    }

    public static void log(String msg) {
        log.setText(log.getText() + "\n" + msg);
    }


}
