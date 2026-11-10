
package by.bsuir.glycemicindex;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ProductCatalog {

    private static final Map<String, Product> PRODUCTS = new HashMap<>();

    static {
        addProduct("Яблоко", 36, "яблоко");
        addProduct("Банан", 51, "банан");
        addProduct("Апельсин", 43, "апельсин");
        addProduct("Груша", 38, "груша");
        addProduct("Клубника", 40, "клубника");
        addProduct("Молоко", 30, "молоко");
        addProduct("Натуральный йогурт", 35, "йогурт");
        addProduct("Гречка", 50, "гречка", "гречневая каша");
        addProduct("Овсяная каша", 55, "овсянка", "овсяная каша");
        addProduct("Белый рис", 73, "рис", "белый рис");
        addProduct("Картофель варёный", 78,
                "картофель", "варёный картофель", "отварной картофель");
        addProduct("Белый хлеб", 75, "хлеб", "белый хлеб");
        addProduct("Морковь", 39, "морковь");
        addProduct("Чечевица", 32, "чечевица");
        addProduct("Тёмный шоколад", 23,
                "шоколад", "тёмный шоколад", "темный шоколад");
    }

    private static void addProduct(String name, int glycemicIndex,
                                   String... aliases) {
        Product product = new Product(name, glycemicIndex);

        for (String alias : aliases) {
            PRODUCTS.put(normalize(alias), product);
        }
    }

    public static Product findByName(String name) {
        if (name == null || name.isBlank()) {
            return null;
        }

        return PRODUCTS.get(normalize(name));
    }

    private static String normalize(String name) {
        return name.trim().toLowerCase(Locale.ROOT);
    }
}
