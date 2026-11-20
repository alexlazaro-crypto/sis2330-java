import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaCalificaciones {

    static double leerNota(Scanner sc, String msg) {
        double n = -1;
        boolean bien = false;
        while (!bien) {
            try {
                System.out.print(msg);
                n = sc.nextDouble();
                if (n < 0 || n > 100) {
                    System.out.println("pon una nota entre 0 y 100");
                    continue;
                }
                bien = true;
            } catch (InputMismatchException e) {
                System.out.println("eso no es un numero");
                sc.next();
            }
        }
        return n;
    }

    static double prom(double[] v) {
        double s = 0;
        for (double x : v) s += x;
        return s / v.length;
    }

    static double mayor(double[] v) {
        double m = v[0];
        for (double x : v) if (x > m) m = x;
        return m;
    }

    static double menor(double[] v) {
        double m = v[0];
        for (double x : v) if (x < m) m = x;
        return m;
    }

    static String estado(double p) {
        if (p >= 51) return "Aprobado";
        return "Reprobado";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] alumnos = {"Ana", "Luis", "Marta", "Kevin", "Sofia"};
        double[][] notas = new double[5][3];
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("alumno " + alumnos[i]);
            for (int j = 0; j < 3; j++) {
                notas[i][j] = leerNota(sc, "nota " + (j + 1) + " ");
            }
        }
        System.out.println("\nresultados");
        for (int i = 0; i < alumnos.length; i++) {
            double p = prom(notas[i]);
            System.out.printf("%s prom %.2f max %.2f min %.2f %s%n",
                    alumnos[i], p, mayor(notas[i]), menor(notas[i]), estado(p));
        }
        sc.close();
    }
}
