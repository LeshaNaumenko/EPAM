package practice3.task2.data.factory;

import practice3.task2.model.entity.Goods;
import practice3.task2.model.entity.Shoes;

public class ShoesMaker implements GoodsMaker {
    @Override
    public Goods createGoods() {
        return new Shoes();
    }
}
