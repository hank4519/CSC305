package project_4;

import java.io.IOException;

public class ChooseInput {
	
	ChooseSource source; 
	ChooseFormat format; 
	ChooseChannel channel; 
	
	public ChooseInput(ChooseSource source, ChooseFormat format) { 
		if (source == ChooseSource.URL && format == ChooseFormat.SIMPLE)
			return; 
		this.source = source; 
		this.format = format; 
	}
	
	public ChooseInput(ChooseSource source, ChooseFormat format, ChooseChannel channel) { 
		if (source == ChooseSource.URL && format == ChooseFormat.SIMPLE)
			return; 
		this.source = source; 
		this.format = format; 
		this.channel = channel; 
	}
	
	/* 
	 *	This accept() evaluates user's choice of parser based on the format, source, and filter channel 
	 *  It would create corresponding parser, and call visit on the given input for proper parsing 
	 *  
	 *  @param 	input	The String input used for parsing, usually is a file name or URL
	 *  @return	Parser 	A corresponding parser that has been visited 
	 */
	Parser accept(String input) throws IOException { 
		if (this.channel != null && this.format != ChooseFormat.SIMPLE) { 
			Parser parser = null;
			if(this.source == ChooseSource.FILE) { 
				parser = new ParsingNews(); 
			} else { 
				parser = new ParsingUrl(); 
			}
			NewsApiDecorator decorator = new NewsApiDecorator(parser, this.channel); 
			decorator.visit(input);
			return parser; 
		}
		if (this.source == ChooseSource.FILE && this.format == ChooseFormat.NEWSAPI) { 
			Parser parser = new ParsingNews(); 
			parser.visit(input); 
			return parser; 
		} else if(this.source == ChooseSource.FILE && this.format == ChooseFormat.SIMPLE) { 
			Parser parser = new ParsingSimple(); 
			parser.visit(input);
			return parser; 
		} else if (this.source == ChooseSource.URL && this.format == ChooseFormat.NEWSAPI) { 
			Parser parser = new ParsingUrl(); 
			parser.visit(input);
			return parser; 
		} else {
			return null; 
		}
	}
}
