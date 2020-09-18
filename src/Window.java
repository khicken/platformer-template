import processing.core.PApplet;

import java.util.Arrays;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Window extends PApplet {
    private static int WINDOW_WIDTH = 1280, WINDOW_HEIGHT = 720;
    private boolean mouseIsPressed, mouseIsReleased;
    private boolean[] keys;

    private String scene;
    private SceneManager sm;

	public Window() { // init variables
        mouseIsPressed = false;
        mouseIsReleased = false;
        keys = new boolean[128];

        scene = "title";
        sm = new SceneManager(this);
    }
    
    public void setup() { // init window variables and papplet inits
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        surface.setTitle("Jake's Adventure");
        surface.setFrameRate(60);
        surface.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        surface.setLocation(((int)screenSize.getWidth()-WINDOW_WIDTH)/2, ((int)screenSize.getHeight()-WINDOW_HEIGHT)/2);

        Arrays.fill(keys, false); // init every element in keys array to not pressed

        surface.setVisible(true);
        sm.initTitleScreen();
        sm.initSettings();
    }

	public void draw() {
        beginRender();
        
        switch(scene) {
            case "title":
                sm.drawTitleScreen();
            break;
            case "settings":
                sm.drawSettings();
            break;
        }

        endRender();
        pollEvents();
    }

    /******************* RENDERING FUNCTIONS ********************/
    private void beginRender() {
        background(255); // flush background
        cursor(ARROW);
    }

    private void endRender() {
        
    }

    private void pollEvents() {
        mouseIsReleased = false;
    }

    /******************* INPUT HANDLERS ********************/

	@Override
	public void mousePressed() {
		if(mouseButton == LEFT) {
            mouseIsPressed = true;
        }
    }

    @Override
    public void mouseReleased() {
        if(mouseButton == LEFT){
            mouseIsReleased = true;
            mouseIsPressed = false;
        }
    }

    @Override
    public void keyPressed() {
        if(keyCode <= 128) keys[keyCode] = true;
    }
    
    @Override
    public void keyReleased() {
        if(keyCode <= 128) keys[keyCode] = false;
    }


    /******************* GETTERS AND SETTERS ********************/
    public boolean isMousePressed() {
        return mouseIsPressed;
    }

    public boolean isMouseReleased() {
        return mouseIsReleased;
    }

    public int getWindowWidth() {
        return WINDOW_WIDTH;
    }

    public int getWindowHeight() {
        return WINDOW_HEIGHT;
    }

    public void switchScene(String s) {
        scene = s;
    }

    public void setWindowSize(int width, int height) {
        WINDOW_WIDTH = width;
        WINDOW_HEIGHT = height;
        surface.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}