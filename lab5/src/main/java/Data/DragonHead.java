package Data;

import exceptions.DragonHeadException;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DragonHead {
    private Integer size; //Поле не может быть null
    private float toothCount;

    public DragonHead(Integer size, float toothCount) throws DragonHeadException {
        if(size == null)
            throw new DragonHeadException(null);
        this.size = size;
        this.toothCount = toothCount;
    }

    @Override
    public String toString() {
        return "DragonHead{" +
                "size=" + size +
                ", toothCount=" + toothCount +
                '}';
    }
}
