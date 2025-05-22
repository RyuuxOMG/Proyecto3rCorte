package autonoma.comidadelcielo.elements;

import autonoma.comidadelcielo.utils.GraphicContainer;
import autonoma.comidadelcielo.utils.Sprite;
import autonoma.comidadelcielo.utils.SpriteContainer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Sky extends SpriteContainer implements GraphicContainer {

    private Food food;
    private boolean finished = false;
    private Poison poison;
    private PlainTextFileWriter writer;
    private PlainTextFileReader reader;
    private int score;
    private int foodAmount = 0;
    private int poisonAmount = 0;
    private BufferedImage image;

    public Sky(String path, int x, int y, int height, int width) {
        super(path, x, y, height, width);

        try {
            this.image = ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        food = new Food("/autonoma/comidadelcielo/images/Burger.png", (this.width - Food.INITIAL_WIDTH),
                (this.height - Food.INITIAL_HEIGHT),
                Food.INITIAL_WIDTH, Food.INITIAL_HEIGHT);
        food.setGraphicContainer(this);

        poison = new Poison("/autonoma/comidadelcielo/images/Cigarette.png", (this.width - Poison.INITIAL_WIDTH),
                (this.height - Poison.INITIAL_HEIGHT),
                Poison.INITIAL_WIDTH, Poison.INITIAL_HEIGHT);
        poison.setGraphicContainer(this);

        this.score = 0;
    }

    public void addSprites(int missingFoods, int missingPoisons) {
        for (int i = 0; i < missingFoods; i++) {
            this.sprites.add(this.addFood());
            this.refresh();
        }

        for (int i = 0; i < missingPoisons; i++) {
            this.sprites.add(this.addPoison());
            this.refresh();
        }
    }

    public Food addFood() {
        int w = 50;
        int h = 50;
        boolean collision;

        do {
            collision = false;
            x = (int) (Math.random() * (this.width - 50));
            y = 60;

            for (Sprite sprite : sprites) {
                int distanceX = Math.abs(x - sprite.getX());
                int distanceY = Math.abs(y - sprite.getY());

                if (distanceX < w && distanceY < h) {
                    collision = true;
                    break;
                }
            }
        } while (collision);

        this.foodAmount++;
        Food food = new Food("/autonoma/comidadelcielo/images/Burger.png",
                x, y, 50, 60);
        food.setGraphicContainer(this);
        food.startMovement();
        return food;
    }

    public Poison addPoison() {
        int w = 50;
        int h = 50;
        boolean collision;

        do {
            collision = false;
            x = (int) (Math.random() * (this.width - 50));
            y = 60;

            for (Sprite sprite : sprites) {
                int distanceX = Math.abs(x - sprite.getX());
                int distanceY = Math.abs(y - sprite.getY());

                if (distanceX < w && distanceY < h) {
                    collision = true;
                    break;
                }
            }
        } while (collision);

        Poison poison = new Poison("/autonoma/comidadelcielo/images/Cigarette.png",
                x, y, 50, 60);
        poison.setGraphicContainer(this);
        poison.startMovement();
        this.poisonAmount++;
        return poison;
    }

    public ArrayList<Sprite> getSpriteCopy() {
        synchronized (sprites) {
            return new ArrayList<>(sprites);
        }
    }
}
