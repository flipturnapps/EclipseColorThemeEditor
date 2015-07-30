import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ColorPickerFrame extends SimpleFrame
{
	private ColorPane pane;
	private JColorChooser picker;

	public ColorPickerFrame(ColorPane pane) 
	{
		this.setSize(300,300);
		this.pane = pane;
		picker = new JColorChooser();
		picker.getSelectionModel().setSelectedColor(pane.getColor());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().add(picker,BorderLayout.CENTER);
		JButton button = new JButton("Confirm");
		button.addActionListener(new ConfirmButtonListener());
		this.getContentPane().add(button, BorderLayout.SOUTH);
	}
	public JFrame getFrame()
	{
		return this;
	}
	private class ConfirmButtonListener implements ActionListener
	{		
		public void actionPerformed(ActionEvent e) 
		{
			pane.setColor(picker.getSelectionModel().getSelectedColor());	
			getFrame().setVisible(false);
			getFrame().dispose();
		}		
	}
}
