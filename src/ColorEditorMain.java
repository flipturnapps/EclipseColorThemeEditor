import java.io.File;

public class ColorEditorMain 
{

	private static File file;

	public static void main(String[] args) 
	{
		String fileString = "";
		for (int i = 0; i < args.length; i++) 
		{
			fileString += args[i] + " ";
		}
		fileString = fileString.substring(0,fileString.length() -1);
		file = new File(fileString);
		XMLReader reader = new XMLReader(file);
		ColorMainFrame frame = new ColorMainFrame(reader.getColors());
		frame.setVisible(true);
	}

	public static File getXMLFile()
	{
		return file;
	}

}
