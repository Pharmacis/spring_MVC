package web.model;
public class Car {
    private String mark;
    private int yearOfManufacture;
    private String color;

    public Car(String model,  int yearOfManufacture, String color) {
        this.mark = model;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
    }

    public Car(){}

    public String getMark() {
        return mark;
    }

    public void setModel(String model) {
        this.mark = model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
