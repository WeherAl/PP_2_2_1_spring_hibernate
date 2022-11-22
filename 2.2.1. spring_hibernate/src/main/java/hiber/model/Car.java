package hiber.model;

import javax.persistence.*;
import java.util.Objects;

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
    @OneToOne(mappedBy = "car")
    private User user;


    public Car() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && series == car.series && Objects.equals(model, car.model) && Objects.equals(user, car.user);
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + Long.hashCode(id);
        result = prime * result + series;
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;

    }
}
