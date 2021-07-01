package Visual.MainActivity;

import javax.swing.*;
import java.awt.*;

public class FrameHandler extends JFrame {
    private final MainFrame mainFrame;

    public FrameHandler() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignored) {
        }

        setTitle("XMLGenerator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        mainFrame = new MainFrame();
        add(mainFrame);
        setResizable(false);
        setSize(600, 300);

    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }
}
