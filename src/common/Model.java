package common;

public interface Model {
    boolean validate(); 

    void save();

    Object[] getAttributeValues();

    String[] getAttributeNames();
}
