package only.mybeer.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Beer {
    private Long beerId;
    private String beerName;
    private int beerPrice;
    private int categoryId;

    public Beer() {

    }

    public Beer(String beerName, int beerPrice, int categoryId) {
        this.beerName = beerName;
        this.beerPrice = beerPrice;
        this.categoryId = categoryId;
    }
}
