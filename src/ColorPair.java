import java.awt.Color;

public class ColorPair
{
	public ColorPair(Color color, String label) {
		super();
		this.color = color;
		this.label = label;
	}
	private Color color;

	private String label;
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

}
