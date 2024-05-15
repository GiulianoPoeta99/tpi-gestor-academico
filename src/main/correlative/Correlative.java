package main.correlative;

import main.career.Career;
import main.common.Model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Correlative implements Model {
    public static final String TRANSLATE_NAME = "Correlativas";

    private int id;

    private int idSubject;

    private int idSubjectCorrelative;

    protected static int serial = 0;
    protected static Map<Integer, Model> all = new LinkedHashMap<>();

    public Correlative() {
    }

    protected Correlative(int idSubject, int idSubjectCorrelative) {
        this.idSubject = idSubject;
        this.idSubjectCorrelative = idSubjectCorrelative;
        save();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubjectCorrelative(int idSubjectCorrelative) {
        this.idSubjectCorrelative = idSubjectCorrelative;
    }

    public int getIdSubjectCorrelative() {
        return idSubjectCorrelative;
    }

    public static Map<Integer, Model> getAll() {
        return all;
    }

    protected static void addSerial() {
        serial++;
    }

    @Override
    public boolean validate() {
        return ((idSubject > 0) && (idSubjectCorrelative > 0));
    }

    @Override
    public boolean save() {
        if (validate()) {
            addSerial();
            id = serial;
            all.put(id, this);
            return true;
        }
        return false;
    }

    @Override
    public boolean update() {
        if (validate()) {
            all.put(id, this);
            return true;
        }
        return false;
    }

    @Override
    public void delete() {
        all.remove(id, this);
    }

    @Override
    public Object[] getAttributeValues() {
        return new Object[] {};
    }

    @Override
    public String[] getAttributeNames() {
        return new String[] {};
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                  * Materia: %d
                  * Materia correlativa: %d
                """,
                TRANSLATE_NAME,
                idSubject,
                idSubjectCorrelative);
    }
}
