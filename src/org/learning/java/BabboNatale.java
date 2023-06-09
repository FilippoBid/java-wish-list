package org.learning.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BabboNatale {

    public static void main(String[] args) {

        final String FILE_PATH = "./resources/giftlist.txt";
        ArrayList<String> Gifts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Gifts.add(line);
            }
        } catch (IOException e) {
            System.out.println("Non è stato possibile leggere il file della lista dei regali.");
        }

        Scanner scan = new Scanner(System.in);
        boolean goOn = true;
        do {

            System.out.println("inserisci il nome del regalo che vuoi ");
            String name = scan.nextLine();
            Gifts.add(name);
            /*System.out.println("hai chiesto" + Gifts.size() + "e contiene: " + "\n");
            System.out.println(Gifts);*/
            System.out.println("vuoi continuare ad inserire un altro regalo?(invio per continuare o no per terminare esalvare la lista)");
            String answer = scan.nextLine();
            if (answer.equalsIgnoreCase("no")) {
                goOn = false;

            } else if (answer.equalsIgnoreCase("si")) {


            }
            ;


        } while (goOn);

        FileWriter writer = null;
        try {
            writer = new FileWriter(FILE_PATH);
            // BufferedWriter buffer = new BufferedWriter(writer);
            // itero sull'array di persone
            for (String element : Gifts) {

                writer.write(element + "\n");
            }

        } catch (IOException e) {
            System.out.println("non [ stato possibile creare il file con la lista.");
        } finally {
            try {
                writer.close();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("ecco la tua lista:");
        for (String element : Gifts) {

            System.out.println(element);
        }
    }

}
