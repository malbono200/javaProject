package exam.abstractex;

public class DrawMain {

	public static void main(String[] args) {
		DrawingObject poly = new Poly("red");
        DrawingObject circle = new Circle("blue");
        DrawingObject rect = new Rect("green");

        poly.draw();
        circle.draw();
        rect.draw();

	}

}
