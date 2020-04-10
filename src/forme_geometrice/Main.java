package forme_geometrice;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape shape1 = new Shape("gold","yellow is text");
		Shape shape2 = new Shape("gold","blue is text");
		Triangle triangle1 = new Triangle(3,4);
		Triangle triangle2 = new Triangle(2,4);
		Rectangle rectangle1 = new Rectangle(3,4);
		Rectangle rectangle2 = new Rectangle(2,4);
		ArrayList<Shape> array = new ArrayList();
		array.add(shape1);
		array.add(shape2);
		array.add(triangle1);
		array.add(triangle2);
		array.add(rectangle1);
		array.add(rectangle2);
		for(int i = 0;i<array.size();i++) {
			System.out.println(array.get(i));
			System.out.println(array.get(i).getSize());
		}
		for(int i = 0;i<array.size();i++) {
			if(array.get(i) instanceof Triangle) {
				Triangle tr = (Triangle) array.get(i);
				tr.displayTriangleHeight();
			}
			if(array.get(i) instanceof Rectangle) {
				Rectangle rt = (Rectangle) array.get(i);
				rt.displayRectangleHeight();
			}
		}
	}

}
