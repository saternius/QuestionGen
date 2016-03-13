package PDFParser;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

	public class Example {
	 static String output;
	    public static void main(String[] args) throws IOException {
	       console.log("processing..");
	       PDFReader pdfReader = new PDFReader((float)4.0,(float)4.8717113);
	       pdfReader.setFilePath("chest.pdf"); //where chest.pdf is the your pdf directory
	      
	       
	       
	       output = pdfReader.ToText();
	       output = Parse.removeAllDashNewLines(output);
	       out("out1.txt");
	       output = Parse.removeAllTitles(output);
	       out("out2.txt");
	       output = Parse.removeAllNumOnly(output);
	       out("out3.txt");
	       output = Parse.newLinesToSpace(output);
	       out("out4.txt");
	       output = Parse.breakOnPeriods(output);
	       out("out5.txt");
	       output = Parse.removeFigsAndTablesRefs(output);
	       out("out6.txt");
	       
	       
	      // pdfReader.exportImages();
	       console.log("DONE");
	}
	    
	public static void out(String filename) throws UnsupportedEncodingException, FileNotFoundException, IOException{
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(filename), "utf-8"));
			writer.write(output);
		} catch (IOException ex) {
			// report
		} finally {
			try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
	}
	    
	
}