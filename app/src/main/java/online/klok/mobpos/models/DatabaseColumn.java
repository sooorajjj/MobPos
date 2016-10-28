package online.klok.mobpos.models;

public class DatabaseColumn {
    String name, typeSpecification;

    public DatabaseColumn(String name, String typeSpecification) {
        this.name = name;
        this.typeSpecification = typeSpecification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeSpecification() {
        return typeSpecification;
    }

    public void setTypeSpecification(String typeSpecification) {
        this.typeSpecification = typeSpecification;
    }

    public String getColumnQuery() {
        return " " + name + " " + typeSpecification;
    }
}
