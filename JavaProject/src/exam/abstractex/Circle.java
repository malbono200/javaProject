package exam.abstractex;

public class Circle extends DrawingObject{
	public Circle(String color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println(color + "색상으로 원 그리기");
    }
}
