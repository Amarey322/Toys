import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
}
class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private double weight;

    public Toy(int id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Toy otherToy) {
        // Сравниваем игрушки по весу для определения порядка в очереди
        return Double.compare(this.weight, otherToy.weight);
    }
}
