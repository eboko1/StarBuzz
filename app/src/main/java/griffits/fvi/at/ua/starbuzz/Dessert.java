package griffits.fvi.at.ua.starbuzz;

/**
 * Created by Vika on 09.06.2017.
 */

public class Dessert extends Drink {


    public Dessert(String name, String description, int imgResId) {
        super(name, description, imgResId);
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
}
