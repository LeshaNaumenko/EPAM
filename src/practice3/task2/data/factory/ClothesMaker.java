package practice3.task2.data.factory;

import practice3.task2.model.entity.Clothes;
import practice3.task2.model.entity.Goods;

public class ClothesMaker implements GoodsMaker {
    @Override
    public Goods createGoods() {
        return new Clothes();
    }
}
