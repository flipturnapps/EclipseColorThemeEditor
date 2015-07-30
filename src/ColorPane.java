import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorPane extends JPanel 
{
	private ColorPair color;
	public ColorPane(ColorPair colorPairs) 
	{
		color = colorPairs;
		this.setToolTipText(color.getLabel());
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		this.add(new ColorPaneColorPanel());
		this.add(new JLabel(color.getLabel()));
		JButton button = new JButton();
		button.setText("Edit");
		button.addActionListener(new ChangeButtonListener());
		this.add(button);
	}
	private ColorPane getAsPane()
	{
		return this;
	}
	private class ColorPaneColorPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			g.setColor(color.getColor());
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
	}
	private class ChangeButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			ColorPickerFrame frame = new ColorPickerFrame(getAsPane());
			frame.setVisible(true);
		}		
	}
	public void setColor(Color selectedColor) 
	{
		color.setColor(selectedColor);		
		this.repaint();
		XMLWriter writer = new XMLWriter(ColorEditorMain.getXMLFile());
		writer.rewritePair(color);
	}
	public Color getColor() 
	{
		return color.getColor();
	}
}
