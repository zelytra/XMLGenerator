package Visual.Preview;

import XML.XML;

import javax.swing.*;
import java.awt.*;

public class PreviewWindows extends JFrame {

    private XML xml;
    private JTextArea display;
    private JPanel panel;

    public PreviewWindows(XML xml) {
        this.xml = xml;

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignored) {
        }

        setTitle(xml.getMRNumber() + " Preview");
        setSize(1000, 1000);
        setResizable(false);
        setLayout(new BorderLayout());
        initGUI();
        setVisible(true);
        add(panel);
        fillTestArea();
        panel.updateUI();


    }

    private void initGUI() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.ipady = 1000;
        gbc.gridheight = 3;
        gbc.gridwidth = 3;

        display = new JTextArea(100, 100);
        display.setEditable(false);


        panel.add(display, gbc);
        panel.add(new JScrollPane(display), gbc);
    }

    private void fillTestArea() {

        display.setText(formattedXML());

    }

    private String formattedXML() {
        int tabCount = 0;
        int lineCount = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : xml.getLine().split("(?=(<|>))")) {
            lineCount++;

            if (s.startsWith("> "))
                continue;

            if (lineCount < 2) {
                stringBuilder.append(s).append(">").append("\n");
                continue;
            }

            if (s.startsWith("</")) {

                for (int x = 0; x < tabCount; x++)
                    stringBuilder.append("\t");
                tabCount--;
                stringBuilder.append(s).append(">").append("\n");

            } else if (s.startsWith("<")) {

                for (int x = 0; x <= tabCount; x++) {
                    if (tabCount != 0)
                        stringBuilder.append("\t");
                }

                tabCount++;
                stringBuilder.append(s).append(">").append("\n");


            } else {

                s = s.replace(">", "");
                for (int x = 0; x <= tabCount; x++)
                    stringBuilder.append("\t");
                stringBuilder.append(s).append("\n");

            }

        }
        return stringBuilder.toString();


    }

}
