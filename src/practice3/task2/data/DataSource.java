package practice3.task2.data;

import practice3.task2.data.factory.*;
import practice3.task2.model.entity.Goods;
import practice3.task2.model.entity.Shoes;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static GoodsMaker goodsMaker;

    public static List<Goods> getGoods(String name, int numb) {

        List<Goods> goods = new ArrayList<>();
        switch (name.toLowerCase()) {
            case "shoes":
                goodsMaker = new ShoesMaker();
                break;
            case "clothes":
                goodsMaker = new ClothesMaker();
                break;
            case "appliances":
                goodsMaker = new AppliancesMaker();
                break;
            default:
                return goods;
        }
        for (int i = 0; i < numb; i++) {
            goods.add(goodsMaker.createGoods());
        }
        return goods;
    }
}
