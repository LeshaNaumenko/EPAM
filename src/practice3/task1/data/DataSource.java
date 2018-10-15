package practice3.task1.data;

import practice3.task1.model.entity.doll.Doll;
import practice3.task1.model.entity.Toy;
import practice3.task1.model.entity.constructor.type.Bolted;
import practice3.task1.model.entity.constructor.type.LegoType;
import practice3.task1.model.entity.constructor.type.Magnetic;

public class DataSource {
    public static Toy[] getToys(){
        return new Toy[]{
                new Doll("Cupcake Surprise серии Джелатто Джесси с ароматом винограда",     160, 0.5, "Collectible Dolls"),
                new Doll("Маленькая кукла Hasbro Disney Princess Принцесса Жасмин ",     160, 0.5, "Collectible Dolls"),
                new Doll("Кукла Hasbro Disney Princess Золушка",     260, 0.5, "Mini dolls"),
                new Doll("Кукла Hasbro Disney Princess Жасмин",     260, 0.5, "Mini dolls"),
                new LegoType( "LEGO Architecture Шанхай",           1800, 0.5,  50,   "City","transport"  ),
                new LegoType( "LEGO City Полицейская погоня",       2239, 2,    550,  "City","transport"  ),
                new LegoType( "LEGO City Паром",                    1048, 0.6,  50,   "City","transport"  ),
                new LegoType( "LEGO Friends Мини Гольф",            2347, 1,    50,   "Friends","animals"  ),
                new LegoType( "LEGO Friends День рождения: тортики",3435, 2,    20,   "Friends","animals"  ),
                new LegoType( "LEGO Friends Клиника Хартлейк-Сити", 2597, 1,    100,  "Friends","buildings"  ),
                new Bolted( "Toy State Самосвал CAT ", 2597, 1,    172,  72 ),
                new Bolted( "Toy Bolted 1 ",    2597,   1,    172,  72 ),
                new Bolted( "Toy Bolted 2",     297,    2,    72,  7 ),
                new Bolted( "Toy Bolted 3 ",    257,    4,    272,  72 ),
                new Bolted( "Toy Bolted 4 ",    597,    15,    372,  72 ),
                new Bolted( "Toy Bolted 5 ",    97,     7,    12,  2 ),
                new Magnetic( "Toy Magnetic 1 ", 97, 3,    12,  "Triangle" ),
                new Magnetic( "Toy Magnetic 2 ", 97, 4,    132,  "Triangle" ),
                new Magnetic( "Toy Magnetic 3 ", 97, 6,    122,  "Triangle" ),
                new Magnetic( "Toy Magnetic 4 ", 97, 7,    142,  "Circle" ),
                new Magnetic( "Toy Magnetic 5 ", 97, 1,    122,  "Circle" ),
                new Magnetic( "Toy Magnetic 6 ", 97, 2,    1242,  "Circle" ),
                new Magnetic( "Toy Magnetic 7 ", 97, 3,    142,  "Rectangle" ),
                new Magnetic( "Toy Magnetic 8 ", 97, 4,    12,  "Rectangle" ),
                new Magnetic( "Toy Magnetic 9 ", 97, 1,    12,  "Rectangle" ),
                new Magnetic( "Toy Magnetic 10 ", 97, 2,    12,  "Rectangle" )
        };
    }
}
