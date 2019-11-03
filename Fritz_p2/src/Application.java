import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class DuplicateCounter
{

	private ArrayList<String> uniqueWords;
	public Map<String, Integer> wordCounter = new HashMap<String, Integer>();
	
	public void count(String dataFile)
	{
		String temp;
		this.uniqueWords = new ArrayList();
		
		File ifp = new File(dataFile);
		try 
		{
			Scanner iSS = new Scanner(ifp);

			while(iSS.hasNext())
			{
				temp = iSS.next();
				Integer num = wordCounter.get(temp);
				wordCounter.put(temp, (num == null) ? 1 : (num + 1));
				
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
	public void write(String outputFile) 
	{
		PrintStream fileOut;
		try 
		{
			fileOut = new PrintStream(outputFile);
			System.setOut(fileOut);
			
			for(int i = 0; i < uniqueWords.size(); i++) 
			{
				System.out.println(uniqueWords.get(i) + "count: " + wordCounter.get(uniqueWords.get(i)));
			}
			
			fileOut.close();
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DuplicateCounter duplicateCounter = new DuplicateCounter();
		String dataFile = "problem2.txt";
		String outputFile = "unique_word_counts.txt";
	
		duplicateCounter.count(dataFile);
		duplicateCounter.write(outputFile);
	}

}
