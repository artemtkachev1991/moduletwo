
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PingPong extends Thread {
    public static void main(String[] args) {
        PingPong pingpong = new PingPong();
        pingpong.start ();
    }
    private String line = "";
    private boolean gameOver = false;

    @Override
    public synchronized void start() {
        super.start();
        while (!gameOver)
            line = new Scanner(System.in).nextLine();
    }

    @Override
    public void run() {
        while (!gameOver) {
            System.out.println("bamm");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (line.equals("")) {
                System.out.println("You lose!");
                gameOver = true;
            } else line = "";
        }
        System.exit(0);
    }
}