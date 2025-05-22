package autonoma.comidadelcielo.utils;

import java.awt.Graphics;

public class MobileSprite extends Sprite {

    protected int step;

    public MobileSprite(String path, int x, int y, int height, int width) {
        super(path, x, y, height, width);
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}