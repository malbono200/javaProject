package exam.abstractex;

public class Rect extends DrawingObject {
	public Rect(String color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println(color + "색상으로 사각형 그리기");
    }
}
