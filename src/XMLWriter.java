import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class XMLWriter 
{

	private File xmlFile;

	public XMLWriter(File xmlFile) 
	{
		this.xmlFile = xmlFile;
	}

	public void rewritePair(ColorPair pair) 
	{
		ArrayList<String> linesToWrite = new ArrayList<String>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(xmlFile));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true)
		{
			String line = null;
			try {
				line = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(line != null)
			{
				if(line.contains("<" + pair.getLabel()))
				{
					String hex = String.format("#%02x%02x%02x", pair.getColor().getRed(), pair.getColor().getGreen(), pair.getColor().getBlue());
					String beforeHex = line.split("#")[0];
					String afterHex = line.split("#")[1].substring(6);
					String newLine = beforeHex + hex + afterHex;
					linesToWrite.add(newLine);
				}
				else
					linesToWrite.add(line);
			}
			else
				break;
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			xmlFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(xmlFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < linesToWrite.size(); i++) 
		{
			writer.println(linesToWrite.get(i));
		}
		writer.flush();
		writer.close();
		Frame[] frames = Frame.getFrames();
		for (int i = 0; i < frames.length; i++) 
		{
			Frame frame = frames[i];
			frame.setVisible(false);
			frame.dispose();
		}
		ColorEditorMain.main(new String[] {ColorEditorMain.getXMLFile().getAbsolutePath()});
	}


}
