package com.kepka.databaseoracle.FrontEnd;

import com.kepka.databaseoracle.model.Student;
import com.kepka.databaseoracle.repository.StudentRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.util.StringUtils;

@Route
public class MainView extends VerticalLayout {

    private final StudentRepository studentRepository;
    final Grid<Student> grid;
    final TextField filter;
    private final Button addNewBtn;

    public MainView(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.grid = new Grid<>(Student.class);
        this.filter = new TextField();
        this.addNewBtn = new Button("Dodaj Studenta", VaadinIcon.PLUS.create());
//
//        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
//        add(actions, grid);

        grid.setHeight("300px");
//        grid.setColumns("Id", "Imie", "Nazwisko", "Telefon");
//        grid.getColumnByKey("ID").setWidth("50px").setFlexGrow(0);

        TextField filter = new TextField();
        filter.setPlaceholder("Filtruj po nazwisku");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listStudents(e.getValue()));
        add(filter,addNewBtn, grid);
    }

    private void listStudents(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(studentRepository.findAll());
        } else {
            grid.setItems(studentRepository.findByNazwiskoStartsWithIgnoringCase(filterText));
        }
    }
}