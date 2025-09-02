import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SuperHeroi p1 = new SuperHeroi("Nicolas Lobo", "M", 1.77,
                Arrays.asList("Voa", "Visão Laser", "SUPER Força"));
        p1.usarHabilidades();
        System.out.println(p1);
    }
}