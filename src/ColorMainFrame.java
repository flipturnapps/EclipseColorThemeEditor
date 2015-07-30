import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class ColorMainFrame extends SimpleFrame
{
	public ColorMainFrame(ColorPair[] colorPairs)
	{
		this.setSize(900,900);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		for (int i = 0; i < colorPairs.length; i++) 
		{
			ColorPane pane = new ColorPane(colorPairs[i]);
			this.getContentPane().add(pane);
		}
	}
}
