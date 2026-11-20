public class Fundamentos {

    static double promedio(double[] valores) {
        double suma = 0.0;
        for (double v : valores) {
            suma += v;
        }
        return suma / valores.length;
    }

    static double promedio(double a, double b) {
        return (a + b) / 2.0;
    }

    public static void main(String[] args) {
        int edad = 20;
        double nota1 = 85.0;
        double nota2 = 78.0;
        boolean activo = true;
        char inicial = 'A';

        int divisionEntera = 7 / 2;
        double divisionDecimal = (double) 7 / 2;

        String nombre = null;
        boolean esAdminValido = (nombre != null) && nombre.equals("Admin");

        System.out.println("Edad: " + edad + " | Inicial: " + inicial + " | Activo: " + activo);
        System.out.println("7 / 2 (int): " + divisionEntera);
        System.out.println("(double) 7 / 2: " + divisionDecimal);
        System.out.println("Cortocircuito seguro: " + esAdminValido);

        if (nota1 >= 51.0) {
            System.out.println("Nota 1: Aprobado");
        } else {
            System.out.println("Nota 1: Reprobado");
        }

        int dia = 3;
        String nombreDia;
        switch (dia) {
            case 1:
                nombreDia = "Lunes";
                break;
            case 2:
                nombreDia = "Martes";
                break;
            case 3:
                nombreDia = "Miercoles";
                break;
            default:
                nombreDia = "Otro dia";
                break;
        }
        System.out.println("Dia: " + nombreDia);

        int contador = 1;
        while (contador <= 3) {
            System.out.println("Contador while: " + contador);
            contador++;
        }

        double[] notas = {nota1, nota2, 90.0};
        System.out.println("Promedio arreglo: " + promedio(notas));
        System.out.println("Promedio dos notas: " + promedio(80.0, 90.0));
    }
}
