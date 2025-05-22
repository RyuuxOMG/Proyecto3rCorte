package autonoma.comidadelcielo.utils;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Sprite extends Canvas {

    protected int x;
    protected int y;
    protected int height;
    protected int width;
    protected Color color;
    protected GraphicContainer gameContainer;
    private BufferedImage image;

    public Sprite(String path, int x, int y, int height, int width) {
        try {
            this.image = ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public boolean isOutOfGraphicContainer() {
        return isOutOfGraphicContainer(x, y, width, height);
    }

    public boolean isOutOfGraphicContainer(int x, int y, int width, int height) {
        if (gameContainer == null) return false;

        int range = 40;
        Rectangle bounds = gameContainer.getBoundaries();

        return !(x + range >= bounds.getX() &&
                 y + range >= bounds.getY() &&
                 x + range + width <= bounds.getX() + bounds.getWidth() &&
                 y + range + height <= bounds.getY() + bounds.getHeight());
    }

    public boolean checkCollision(Sprite other) {
        boolean collisionX = this.getX() + this.getWidth() >= other.getX() &&
                             this.getX() < other.getX() + other.getWidth();

        boolean collisionY = this.getY() + this.getHeight() >= other.getY() &&
                             this.getY() < other.getY() + other.getHeight();

        return collisionX && collisionY;
    }

    public abstract void paint(Graphics g);

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public void setGraphicContainer(GraphicContainer gContainer) { this.gameContainer = gContainer; }
    public GraphicContainer getGameContainer() { return gameContainer; }

    public void setColor(Color color) { this.color = color; }
}