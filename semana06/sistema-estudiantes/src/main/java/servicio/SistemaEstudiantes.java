package servicio;

import modelo.Estudiante;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class SistemaEstudiantes {
    private HashMap<String, Estudiante> porCodigo;
    private TreeSet<Estudiante> ranking;

    public SistemaEstudiantes() {
        this.porCodigo = new HashMap<String, Estudiante>();
        this.ranking = new TreeSet<Estudiante>();
    }

    public boolean registrar(Estudiante e) {
        if (e == null || porCodigo.containsKey(e.getCodigo())) {
            return false;
        }
        porCodigo.put(e.getCodigo(), e);
        ranking.add(e);
        return true;
    }

    public Estudiante buscarPorCodigo(String codigo) {
        if (codigo == null) {
            return null;
        }
        return porCodigo.get(codigo.trim());
    }

    public boolean actualizarPromedio(String codigo, double nuevoPromedio) {
        if (codigo == null || nuevoPromedio < 0.0 || nuevoPromedio > 100.0) {
            return false;
        }
        Estudiante e = porCodigo.get(codigo.trim());
        if (e == null) {
            return false;
        }
        ranking.remove(e);
        e.setPromedio(nuevoPromedio);
        ranking.add(e);
        return true;
    }

    public ArrayList<Estudiante> listarRanking() {
        return new ArrayList<Estudiante>(ranking);
    }

    public ArrayList<Estudiante> topN(int n) {
        ArrayList<Estudiante> top = new ArrayList<Estudiante>();
        if (n <= 0) {
            return top;
        }
        int i = 0;
        for (Estudiante e : ranking) {
            if (i >= n) {
                break;
            }
            top.add(e);
            i++;
        }
        return top;
    }

    public boolean eliminar(String codigo) {
        if (codigo == null) {
            return false;
        }
        Estudiante e = porCodigo.remove(codigo.trim());
        if (e == null) {
            return false;
        }
        ranking.remove(e);
        return true;
    }

    public int cantidad() {
        return porCodigo.size();
    }
}
