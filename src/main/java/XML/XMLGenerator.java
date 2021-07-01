package XML;

import Visual.MainActivity.FrameHandler;

public class XMLGenerator {

    private static FrameHandler frameHandler;

    public static void main(String[] args) {
        frameHandler = new FrameHandler();
        frameHandler.setVisible(true);
    }

    public static FrameHandler getFrameHandler() {
        return frameHandler;
    }
}
