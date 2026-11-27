package com.tareas.views;

public class TareaEditable {
    private long id;
    private String dsc = "";
    private boolean comp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public boolean isComp() {
        return comp;
    }

    public void setComp(boolean comp) {
        this.comp = comp;
    }
}
