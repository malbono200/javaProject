package exam.abstractex;

public abstract class DrawingObject {
	
	String color;

    public DrawingObject(String color) {
        this.color = color;
    }

    public abstract void draw();
}
