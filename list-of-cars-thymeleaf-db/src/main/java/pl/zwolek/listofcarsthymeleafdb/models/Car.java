package pl.zwolek.listofcarsthymeleafdb.models;


import org.springframework.format.annotation.DateTimeFormat;
import pl.zwolek.listofcarsthymeleafdb.enums.Color;


import java.util.Date;
import java.util.Objects;

public class Car {
    private long id;
    private String model;
    private String mark;
    private Color color;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date productionDate;

    public Car() {
    }

    public Car(long id, String mark, String model, Color color, Date productionDate) {
        this(mark, model, color, productionDate);
        this.id = id;
    }

    public Car(String mark, String model, Color color, Date productionDate) {
        this.model = model;
        this.mark = mark;
        this.color = color;
        this.productionDate = productionDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && Objects.equals(model, car.model) && Objects.equals(mark, car.mark) && color == car.color && Objects.equals(productionDate, car.productionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, mark, color, productionDate);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", mark='" + mark + '\'' +
                ", color=" + color +
                ", productionDate=" + productionDate +
                '}';
    }
}
