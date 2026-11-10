package by.bsuir.glycemicindex;

public class Product {

    private final String name;
    private final int glycemicIndex;

    public Product(String name, int glycemicIndex) {
        this.name = name;
        this.glycemicIndex = glycemicIndex;
    }

    public String getName() {
        return name;
    }

    public int getGlycemicIndex() {
        return glycemicIndex;
    }
}
