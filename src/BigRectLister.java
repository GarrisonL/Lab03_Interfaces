import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BigRectLister {
    public static void main(String[] args) {
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(2, 3));
        rectangles.add(new Rectangle(1, 1));
        rectangles.add(new Rectangle(5, 1));
        rectangles.add(new Rectangle(3, 2));

        Filter bigRectangleFilter = new BigRectangleFilter();
        List<Rectangle> bigRectangles = collectAll(rectangles, bigRectangleFilter);

        System.out.println("Rectangles with big perimeters:");
        for (Rectangle rectangle : bigRectangles) {
            System.out.println(rectangle);
        }
    }

    public static List<Rectangle> collectAll(List<Rectangle> objects, Filter filter) {
        List<Rectangle> filteredList = new ArrayList<>();
        for (Rectangle object : objects) {
            if (filter.accept(object)) {
                filteredList.add(object);
            }
        }
        return filteredList;
    }
}

