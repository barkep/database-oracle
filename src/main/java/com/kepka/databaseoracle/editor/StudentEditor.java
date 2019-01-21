package com.kepka.databaseoracle.editor;

import com.kepka.databaseoracle.model.Student;
import com.kepka.databaseoracle.repository.StudentRepository;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class StudentEditor extends VerticalLayout implements KeyNotifier {


    private final StudentRepository studentRepository;
    private Student student;

    TextField imie = new TextField("imie");
    TextField nazwisko = new TextField("nazwisko");
    TextField telefon = new TextField("telefon");

    Button save = new Button("Zapisz", VaadinIcon.CHECK.create());
    Button cancel = new Button("Anuluj");
    Button delete = new Button("Usuń", VaadinIcon.TRASH.create());

    HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

    Binder<Student> binder = new Binder<>(Student.class);
    private ChangeHandler changeHandler;

    @Autowired
    public StudentEditor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        add(imie, nazwisko, telefon, actions);

        binder.bindInstanceFields(this);

        setSpacing(true);

        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e -> save());

        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editStudent(student));
        setVisible(false);

    }

    public void editStudent(Student s) {
        if (s == null) {
            setVisible(false);
            return;
        }
        final boolean persisted = s.getId() != 0;
        if (persisted) {
            student = studentRepository.findById(s.getId()).get();
        } else {
            student = s;
        }
        cancel.setVisible(persisted);
        binder.setBean(student);
        setVisible(true);
        imie.focus();
    }

    void delete() {
        studentRepository.delete(student);
        changeHandler.onChange();
    }

    void save() {
        studentRepository.save(student);
        changeHandler.onChange();
    }

    public void setChangeHandler(ChangeHandler h) {
        changeHandler = h;
    }

    public interface ChangeHandler {
        void onChange();
    }
}
