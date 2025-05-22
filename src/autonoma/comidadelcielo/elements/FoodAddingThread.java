package autonoma.comidadelcielo.elements;

/**
 * @author Mariana
 * @since 20250517
 * @version 1.0
 */
public class FoodAddingThread implements Runnable {

    private Sky sky;
    private boolean running = true;

    public FoodAddingThread(Sky sky) {
        this.sky = sky;
    }

    @Override
    public void run() {
        while (running) {
            this.sky.addSprites(1, 0);
            try {
                Thread.sleep(1500); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}