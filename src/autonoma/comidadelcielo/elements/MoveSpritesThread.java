package autonoma.comidadelcielo.elements;

import autonoma.comidadelcielo.utils.Sprite;

public class MoveSpritesThread implements Runnable {

    private Sky sky;
    private boolean running = true;

    public MoveSpritesThread(Sky sky) {
        this.sky = sky;
    }

    @Override
    public void run() {
        while (running) {
            for (Sprite sprite : this.sky.getSpriteCopy()) {
                if (sprite instanceof Food) {
                    ((Food) sprite).move();
                } else if (sprite instanceof Poison) {
                    ((Poison) sprite).move();
                }
            }
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}