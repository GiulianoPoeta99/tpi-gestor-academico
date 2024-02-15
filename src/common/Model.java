package common;

public interface Model {
    boolean validate(); 

    boolean save();

    Object[] getAttributeValues();

    String[] getAttributeNames();

    int getId();
}
