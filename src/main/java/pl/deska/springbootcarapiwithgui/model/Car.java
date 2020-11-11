package pl.deska.springbootcarapiwithgui.model;

import javax.persistence.*;


@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String mark;
    private String model;
    @Enumerated(value = EnumType.STRING)
    private Color color;
    private int productionYear;


    public Car(String mark, String model, int productionYear, Color color) {
        this.mark = mark;
        this.model = model;
        this.productionYear = productionYear;
        this.color = color;
    }

    public Car() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                ", color=" + color +
                '}';
    }

}
