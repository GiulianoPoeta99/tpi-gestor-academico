package common;

public interface Model {
    boolean validate();
    boolean save();
    boolean update();
    void delete();
    Object[] getAttributeValues();
    String[] getAttributeNames();
}
