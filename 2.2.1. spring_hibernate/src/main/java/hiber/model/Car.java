package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;
    @OneToOne (mappedBy = "car")
    private User user;


    public Car() {}

    public Car(String model, int series) {
        this.series = series;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public long getId() {
        return id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
