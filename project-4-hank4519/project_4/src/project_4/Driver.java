package project_4;

import java.io.IOException;

public class Driver {
	public static void main(String[] args) throws IOException {
		
		System.out.println("Filter CNBC");
		ChooseInput formats = new ChooseInput(ChooseSource.FILE, ChooseFormat.NEWSAPI, ChooseChannel.CNBC); 
		Parser parser = formats.accept("inputs/newsapi.txt");
		System.out.println(parser);
		
		System.out.println("Filter CNN");
		formats = new ChooseInput(ChooseSource.URL, ChooseFormat.NEWSAPI, ChooseChannel.CNN); 
		parser = formats.accept("https://newsapi.org/v2/top-headlines?country=us&apiKey=15a282145dca4e0c933ce03f16e6997c"); 
		System.out.println(parser); 
		
		
		//Previous configuration without Filter 
		/*
		formats = new ChooseInput(ChooseSource.FILE, ChooseFormat.NEWSAPI); 
		parser = formats.accept("inputs/newsapi.txt"); 
		System.out.println(parser);
		
		formats = new ChooseInput(ChooseSource.URL, ChooseFormat.NEWSAPI); 
		parser = formats.accept("https://newsapi.org/v2/top-headlines?country=us&apiKey=15a282145dca4e0c933ce03f16e6997c");
		System.out.println(parser);
		
		
		formats = new ChooseInput(ChooseSource.FILE, ChooseFormat.SIMPLE); 
		parser = formats.accept("inputs/simple.txt"); 
		System.out.println(parser);
		*/

		

	}
}
