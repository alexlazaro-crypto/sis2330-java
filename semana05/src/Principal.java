import modelo.Estudiante;
import servicio.SistemaEstudiantes;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static int leerEntero(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("escribe un numero entero valido");
            }
        }
    }

    private static double leerDouble(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("escribe un numero valido");
            }
        }
    }

    public static void main(String[] args) {
        SistemaEstudiantes sistema = new SistemaEstudiantes();
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n1 registrar  2 buscar  3 actualizar  4 ranking  5 top n  6 salir");
            op = leerEntero(sc, "opcion ");

            if (op == 1) {
                System.out.print("codigo ");
                String cod = sc.nextLine();
                System.out.print("nombre ");
                String nom = sc.nextLine();
                double prom = leerDouble(sc, "promedio ");
                try {
                    boolean ok = sistema.registrar(new Estudiante(cod, nom, prom));
                    System.out.println(ok ? "registrado" : "codigo repetido");
                } catch (IllegalArgumentException e) {
                    System.out.println("no se pudo registrar " + e.getMessage());
                }
            } else if (op == 2) {
                System.out.print("codigo a buscar ");
                Estudiante e = sistema.buscarPorCodigo(sc.nextLine());
                System.out.println(e != null ? e : "no encontrado");
            } else if (op == 3) {
                System.out.print("codigo ");
                String c2 = sc.nextLine();
                double np = leerDouble(sc, "nuevo promedio ");
                System.out.println(sistema.actualizarPromedio(c2, np) ? "actualizado" : "no encontrado");
            } else if (op == 4) {
                ArrayList<Estudiante> lista = sistema.listarRanking();
                if (lista.isEmpty()) {
                    System.out.println("sin estudiantes");
                } else {
                    for (Estudiante r : lista) {
                        System.out.println(r);
                    }
                }
            } else if (op == 5) {
                int n = leerEntero(sc, "cantidad n ");
                ArrayList<Estudiante> top = sistema.topN(n);
                if (top.isEmpty()) {
                    System.out.println("sin resultados");
                } else {
                    for (Estudiante t : top) {
                        System.out.println(t);
                    }
                }
            } else if (op == 6) {
                System.out.println("adios");
            } else {
                System.out.println("opcion no valida");
            }
        } while (op != 6);

        sc.close();
    }
}
