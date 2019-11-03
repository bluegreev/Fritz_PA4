import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

class DuplicateRemover{

	private String dataFile;
	private ArrayList<String> uniqueWords;
	
	public void remove(String dataFile) {
		
		this.dataFile = dataFile;
		this.uniqueWords = new ArrayList();
		String temp;
		
		File ifp = new File(this.dataFile);
		try 
		{
			Scanner iSS = new Scanner(ifp);

			while(iSS.hasNext())
			{
				temp = iSS.next();
				if(!(uniqueWords.contains(temp))) 
				{
					uniqueWords.add(temp);
				}
			}
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void write(String outputFile) {
		
		try {
				PrintStream fileOut = new PrintStream(outputFile);
				System.setOut(fileOut);
				
				for(int i = 0; i < uniqueWords.size(); i++) {
					System.out.println(uniqueWords.get(i));
				}
				
				fileOut.close();
			} 
			catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

public class Application{
	public static void main(String[] args) {
		DuplicateRemover duplicateRemover = new DuplicateRemover();
		String dataFile = "problem1.txt";
		String outputFile = "unique_words.txt";
	
		duplicateRemover.remove(dataFile);
		duplicateRemover.write(outputFile);
	}
}

