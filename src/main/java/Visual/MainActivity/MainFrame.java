package Visual.MainActivity;

import TaskManager.Task;
import Visual.Preview.PreviewWindows;
import XML.FileReader;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainFrame extends JPanel implements ActionListener, ChangeListener {

    private Task task;

    private JProgressBar progressBar;
    private JButton start;
    private JButton preview;
    private JTextArea info;

    private JButton fileChooser;
    private JTextArea file;

    private JTextArea console;

    public MainFrame() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        createUIComponent();


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        gbc.gridwidth = 3;
        add(info, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.ipadx = 30;
        gbc.weightx = 0.9;
        add(file, gbc);

        gbc.gridx += 2;
        gbc.ipadx = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        add(fileChooser, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        add(preview, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(start, gbc);

        gbc.gridy++;
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.ipady = 80;
        add(console, gbc);
        add(new JScrollPane(console), gbc);

        gbc.ipady = 0;
        gbc.gridy++;
        add(progressBar, gbc);


    }

    private void createUIComponent() {
        info = new JTextArea("Choose a file: ");
        info.setEditable(false);
        info.setSelectionColor(null);
        info.setSelectedTextColor(null);
        info.setBackground(null);

        start = new JButton("Start process");
        start.addActionListener(this);

        preview = new JButton("Preview...");
        preview.setEnabled(false);
        preview.addActionListener(this);

        fileChooser = new JButton("...");
        fileChooser.addActionListener(this);

        file = new JTextArea("No file selected...");
        file.setEditable(false);
        file.setSelectionColor(null);
        file.setSelectedTextColor(null);

        console = new JTextArea(50, 10);
        console.setEditable(false);
        console.setAutoscrolls(true);
        console.setMaximumSize(new Dimension(600, 100));

        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.addChangeListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fileChooser) {

            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            jfc.setCurrentDirectory(new File(System.getProperty("user.dir")));
            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                file.setText(selectedFile.getAbsolutePath());
                this.updateUI();
            }
            if(new File(this.file.getText()).exists())
                preview.setEnabled(true);
            else
                preview.setEnabled(false);

        } else if (e.getSource() == start) {

            try {
                this.task = new Task(this.file.getText());
                progressBar.setMaximum(this.task.getSize());
                fileChooser.setEnabled(false);
                start.setEnabled(false);
                task.run();
            } catch (Exception exception) {
                noFileFound();
            }

        } else if (e.getSource() == preview) {

            FileReader fileReader = new FileReader(this.file.getText());
            new PreviewWindows(fileReader.getXmlList().get(0));

        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

    public void log(String msg) {
        console.setText(console.getText() + "\n" + msg);
        console.setCaretPosition(console.getDocument().getLength());
    }

    private void noFileFound() {
        JOptionPane jop1;
        jop1 = new JOptionPane();
        jop1.showMessageDialog(null, "No file selected", "ERROR", JOptionPane.ERROR_MESSAGE);

    }

    public void addProgress() {
        progressBar.setValue(progressBar.getValue() + 1);
    }

    public void resetFrame() {
        start.setEnabled(true);
        fileChooser.setEnabled(true);
        progressBar.setValue(0);

    }
}
