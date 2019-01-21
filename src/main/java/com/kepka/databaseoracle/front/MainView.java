package com.kepka.databaseoracle.front;

import com.kepka.databaseoracle.editor.StudentEditor;
import com.kepka.databaseoracle.model.Student;
import com.kepka.databaseoracle.repository.StudentRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.util.StringUtils;

@Route
public class MainView extends VerticalLayout {

    private final StudentRepository studentRepository;
    private final StudentEditor studentEditor;
    final Grid<Student> grid;
    final TextField filter;
    private final Button addNewBtn;

    public MainView(StudentRepository studentRepository, StudentEditor studentEditor1) {
        this.studentRepository = studentRepository;
        this.studentEditor = studentEditor1;
        this.grid = new Grid<>(Student.class);
        this.filter = new TextField();
        this.addNewBtn = new Button("Dodaj Studenta", VaadinIcon.PLUS.create());

        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid, studentEditor);

        grid.setHeight("300px");
        grid.setWidth("600px");
        grid.removeColumnByKey("id");

        filter.setPlaceholder("Filtruj po nazwisku");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listStudents(e.getValue()));

        grid.asSingleSelect().addValueChangeListener(e -> {
            studentEditor.editStudent(e.getValue());
        });
        addNewBtn.addClickListener(e -> studentEditor.editStudent(new Student()));

        studentEditor.setChangeHandler(() -> {
            studentEditor.setVisible(false);
            listStudents(filter.getValue());
        });
        listStudents(null);
    }

    private void listStudents(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(studentRepository.findAll());
        } else {
            grid.setItems(studentRepository.findByNazwiskoStartsWithIgnoringCase(filterText));
        }
    }
}