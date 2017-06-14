package griffits.fvi.at.ua.starbuzz.Menu;

import griffits.fvi.at.ua.starbuzz.R;

/**
 * Created by Vika on 09.06.2017.
 */

public class Dessert {
    private String name;
    private String description;
    private int idResImg;

    public Dessert(String name, String description, int idResImg) {
        this.name = name;
        this.description = description;
        this.idResImg = idResImg;
    }


    public  static  final Dessert[] desserts = {
            new Dessert("Tiramisu",
                    "Italian dessert from mascarpone cheese, cookies added as filler \"ladyfinger\" coffee and cocoa.",
                     R.mipmap.ic_tirramisu),
            new Dessert("Churros",
                    "A stick of soft dough, cut very similar to the shape of a star and made from wheat flour and other special ingredients",
                    R.mipmap.ic_churros),
            new Dessert("Filter",
                    "Highest quality beans roasted and brewed fresh",
                    R.mipmap.ic_filter)
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getIdResImg() {
        return idResImg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdResImg(int idResImg) {
        this.idResImg = idResImg;
    }

    public String toString(){
        return this.name ;
    }
}
