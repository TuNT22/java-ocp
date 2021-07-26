package chapter8.io.workingwithstream.objectinputoutputstream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreamSample {
    public static List<Animal> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<Animal>();
        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(dataFile)))) {
            while(true) {
                Object object = in.readObject();
                if(object instanceof Animal)
                    animals.add((Animal)object);
            }
        } catch (EOFException e) {
            // file end reached
            // EOFException marks the program encountering the end of the file
            // this is one of the few times when it is perfectly acceptable to swallow an exception
        }
        return animals;
    }

    public static void createAnimalsFile(List<Animal> animals, File dataFile) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for(Animal animal: animals)
                out.writeObject(animal);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal("Tommy Tiger",5,'T'));
        animals.add(new Animal("Peter Penguin",8,'P'));

        File dataFile = new File("animal");
        createAnimalsFile(animals,dataFile);
        System.out.println(getAnimals(dataFile));
    }
}
