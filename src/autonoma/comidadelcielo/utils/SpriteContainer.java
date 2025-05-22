package autonoma.comidadelcielo.utils;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class SpriteContainer extends Sprite implements GraphicContainer {

    protected ArrayList<Sprite> sprites;   

    public SpriteContainer(String path, int x, int y, int height, int width) {
        super(path, x, y, height, width);
        sprites = new ArrayList<>();
    }   

    public boolean add(Sprite sprite) {
        return sprites.add(sprite);
    }

    public void remove(int index) {
        sprites.remove(index);
    }

    public void remove(Sprite sprite) {
        sprites.remove(sprite);
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Rectangle getBoundaries() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public ArrayList<Sprite> getSprites() {
        return sprites;
    }
}