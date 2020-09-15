import processing.core.PApplet;
import processing.core.PConstants;

public class Button {
    private PApplet a;
    private int x, y, w, h;
    private String txt;

    public Button(PApplet a, int x, int y, int w, int h, String txt) {
        this.a = a;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.txt = txt;
    }

    public void draw(boolean pressing) {
        a.strokeWeight(3);
        a.stroke(0);
        a.fill(255);
        if(hovering()) {
            a.fill(200);
            if(pressing) {
                a.fill(150);
            } else {
            }
        }
        a.rect(this.x, this.y, this.w, this.h);
        
        a.textAlign(PConstants.CENTER);
        a.fill(0);
        a.text(this.txt, this.x + this.w/2, this.y + this.h/2);
    }
    
    public boolean pressing(boolean e) { // if button being pressed
        return hovering() && e;
    }

    public boolean released(boolean e) { // button was released
        return hovering() && e;
    }
    
    private boolean hovering() { // check if mouse inbounds
        return a.mouseX > this.x && a.mouseX < this.x + this.w && a.mouseY > this.y && a.mouseY < this.y + this.h;
    }
    
    public void setText(String txt) { // set text of button
        this.txt = txt;
    }
}