package only.mybeer.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Beer {
    private Long beerId;
    private String beerName;
    private double alc;
    private int beerPrice;
    private Long categoryId;
    private String description;

    public Beer() {

    }

    public Beer(String beerName, int beerPrice, Long categoryId, double alc) {
        this.beerName = beerName;
        this.beerPrice = beerPrice;
        this.alc = alc;
        this.categoryId = categoryId;
    }
}
