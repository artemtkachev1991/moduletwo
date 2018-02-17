package pingpongtest;

import java.util.Scanner;

public class PPT extends Thread {


    String word;

    //String WORDS;

    int delay;



    PPT(String whatToSay, int delayTime) {

        word = whatToSay;

        delay = delayTime;


    }

    public void run() {

        try {
            Scanner scanner = new Scanner(System.in);

            String WORDS = scanner.next();

            for (; ; ) {

                System.out.println(word +" "+ WORDS );

                sleep(delay);

            }

        } catch (InterruptedException e) {

            return;

        }

    }

    public static void main(String[] args) {

        new PPT("ping", 2000).start();



    }

}

