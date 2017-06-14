package griffits.fvi.at.ua.starbuzz.Menu;

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
    //drinks is an array of Drinks
    public  static  final Drink[] drinks = {
        new Drink("Latte", "A couple of espresso shots with streamed milk", R.mipmap.ic_latte),
        new Drink("Cappuccino","Espresso, hot milk, and a steamed milk foam", R.mipmap.ic_cappuccino),
        new Drink("Filter", "Highest quality beans roasted and brewed fresh", R.mipmap.ic_filter)
    };

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
