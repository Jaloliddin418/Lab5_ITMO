package Data;

import lombok.Getter;
import lombok.Setter;
import java.time.ZonedDateTime;


@Setter
@Getter
public class Dragon implements Comparable<Dragon> {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer age; //Значение поля должно быть больше 0, Поле может быть null
    private int weight; //Значение поля должно быть больше 0
    private Color color; //Поле может быть null
    private DragonCharacter character; //Поле не может быть null
    private DragonHead head;

    public Dragon(Integer id, String name, Integer age, int weight, Coordinates coordinates, Color color, DragonCharacter character, DragonHead head,ZonedDateTime zonedDateTime){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.age = age;
        this.weight = weight;
        this.color = color;
        this.character = character;
        this.head = head;
        this.creationDate = zonedDateTime;
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", age=" + age +
                ", weight=" + weight +
                ", color=" + color +
                ", character=" + character +
                ", head=" + head +
                '}';
    }

    @Override
    public int compareTo( Dragon o) {
        return this.name.compareTo(o.name);
    }


}