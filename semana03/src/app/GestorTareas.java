package app;

import modelo.Tarea;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorTareas {
    private static ArrayList<Tarea> tareas = new ArrayList<Tarea>();

    private static void agregar(String desc) {
        try {
            tareas.add(new Tarea(desc));
            System.out.println("tarea agregada");
        } catch (IllegalArgumentException e) {
            System.out.println("no se puede agregar: " + e.getMessage());
        }
    }

    private static void listar() {
        if (tareas.isEmpty()) {
            System.out.println("no hay tareas todavia");
            return;
        }
        for (Tarea t : tareas) {
            System.out.println(t);
        }
    }

    private static void completar(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                t.marcarCompletada();
                System.out.println("tarea " + id + " marcada como lista");
                return;
            }
        }
        System.out.println("no existe tarea con id " + id);
    }

    private static void eliminar(int id) {
        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getId() == id) {
                tareas.remove(i);
                System.out.println("tarea eliminada");
                return;
            }
        }
        System.out.println("no existe tarea con id " + id);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n1 agregar  2 listar  3 completar  4 eliminar  5 salir");
            System.out.print("opcion ");
            int op;
            try {
                op = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("pon un numero valido");
                sc.next();
                continue;
            }
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("descripcion ");
                    agregar(sc.nextLine());
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    System.out.print("id a completar ");
                    completar(sc.nextInt());
                    sc.nextLine();
                    break;
                case 4:
                    System.out.print("id a eliminar ");
                    eliminar(sc.nextInt());
                    sc.nextLine();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("esa opcion no existe");
                    break;
            }
        }
        sc.close();
    }
}
