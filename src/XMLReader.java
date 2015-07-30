import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class XMLReader 
{

	private File xmlFile;
	private ColorPair[] colors;

	public XMLReader(File file) 
	{
		xmlFile = file;
	}

	public ColorPair[] getColors()
	{
		if(colors == null)
			this.readFile();
		return colors;
	}

	public void readFile() 
	{
		ArrayList<ColorPair> arrList_Colors = new ArrayList<ColorPair>();
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
				int hashIndex = line.indexOf("#");
				if(hashIndex == -1)
					continue;
				String hex = line.substring(hashIndex + 1, hashIndex + 7);
				int startLabelIndex = line.indexOf("<");
				String label = "";
				while(true)
				{
					startLabelIndex++;
					if(!((line.charAt(startLabelIndex)+"").equals(" ")))
						label += line.charAt(startLabelIndex);
					else
						break;
						
				}
				ColorPair pair = new ColorPair(new Color(Integer.parseInt(hex,16)),label);
				arrList_Colors.add(pair);
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
		colors = arrList_Colors.toArray(new ColorPair[arrList_Colors.size()]);
	}
}
