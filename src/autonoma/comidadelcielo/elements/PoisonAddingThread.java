package autonoma.comidadelcielo.elements;

public class PoisonAddingThread implements Runnable {

    private Sky sky;
    private boolean running = true;

    public PoisonAddingThread(Sky sky) {
        this.sky = sky;
    }

    @Override
    public void run() {
        while (running) {
            this.sky.addSprites(0, 1);

            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}