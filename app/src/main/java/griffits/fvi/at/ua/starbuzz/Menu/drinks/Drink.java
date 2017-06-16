package griffits.fvi.at.ua.starbuzz.Menu.drinks;

import griffits.fvi.at.ua.starbuzz.R;

/**
 * Created by Vika on 07.06.2017.
 */

public class Drink {
    private String  name;
    private String description;
    private int imgResId;

    public Drink(String name, String description, int imgResId) {
        this.name = name;
        this.description = description;
        this.imgResId = imgResId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImgResId() {
        return imgResId;
    }

    //object.tosString()
    public String toString(){
        return this.name;
    }
}
