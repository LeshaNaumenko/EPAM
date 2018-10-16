package practice3.task2.data.factory;

import practice3.task2.model.entity.Appliances;
import practice3.task2.model.entity.Goods;

public class AppliancesMaker implements GoodsMaker {
    @Override
    public Goods createGoods() {
        return new Appliances();
    }
}
