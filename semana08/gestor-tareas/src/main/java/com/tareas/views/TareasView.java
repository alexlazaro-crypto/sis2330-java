package com.tareas.views;

import com.tareas.Tarea;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;

@Route("")
public class TareasView extends VerticalLayout {

    private final List<Tarea> lst = new ArrayList<>();
    private long nId = 1;
    private final Grid<Tarea> grd = new Grid<>(Tarea.class, false);
    private final TextField txtD = new TextField("Descripcion");
    private final Checkbox chkC = new Checkbox("Completada");
    private final Binder<TareaEditable> bnd = new Binder<>(TareaEditable.class);
    private Tarea act;

    public TareasView() {
        setSizeFull();
        grd.setWidth("65%");
        grd.setHeight("400px");
        grd.addColumn(Tarea::id).setHeader("ID").setWidth("80px").setFlexGrow(0);
        grd.addColumn(Tarea::dsc).setHeader("Descripcion");
        grd.addColumn(t -> t.comp() ? "Si" : "No").setHeader("Completada").setWidth("120px").setFlexGrow(0);
        grd.asSingleSelect().addValueChangeListener(ev -> cargar(ev.getValue()));

        bnd.forField(txtD).asRequired("La descipcion es obligatoria").bind(TareaEditable::getDsc, TareaEditable::setDsc);
        bnd.forField(chkC).bind(TareaEditable::isComp, TareaEditable::setComp);

        Button bSav = new Button("Guardar", ev -> guardar());
        Button bDel = new Button("Eliminar", ev -> borrar());
        Button bNue = new Button("Nuevo", ev -> {
            grd.deselectAll();
            cargar(null);
        });

        VerticalLayout frm = new VerticalLayout(txtD, chkC, new HorizontalLayout(bSav, bDel, bNue));
        frm.setWidth("35%");

        HorizontalLayout row = new HorizontalLayout(grd, frm);
        row.setWidthFull();
        add(row);
        refrescar();
        cargar(null);
    }

    private void cargar(Tarea t) {
        act = t;
        TareaEditable ed = new TareaEditable();
        if (t != null) {
            ed.setId(t.id());
            ed.setDsc(t.dsc());
            ed.setComp(t.comp());
        }
        bnd.readBean(ed);
    }

    private void guardar() {
        TareaEditable ed = new TareaEditable();
        if (!bnd.writeBeanIfValid(ed)) {
            Notification.show("Revisa los datos del formulario");
            return;
        }
        if (act == null) {
            lst.add(new Tarea(nId++, ed.getDsc(), ed.isComp()));
        } else {
            long idAux = act.id();
            lst.removeIf(x -> x.id() == idAux);
            lst.add(new Tarea(idAux, ed.getDsc(), ed.isComp()));
        }
        refrescar();
        grd.deselectAll();
        cargar(null);
    }

    private void borrar() {
        if (act == null) {
            Notification.show("Selecciona una tarea para eliminar");
            return;
        }
        lst.removeIf(x -> x.id() == act.id());
        refrescar();
        grd.deselectAll();
        cargar(null);
    }

    private void refrescar() {
        grd.setItems(lst);
    }
}
