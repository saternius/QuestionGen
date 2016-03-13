package PDFParser;

public class Parse {

	public static String removeAllDashNewLines(String output) {
		for(int i=0; i<output.length();i++){
			if(output.charAt(i)=='\n'&& output.charAt(i-2)=='-'){
				output= output.substring(0,i-2)+output.substring(i+1,output.length());
			}
		}
		return output;
	}

	public static String breakOnPeriods(String output) {

		//return output.replaceAll(".", ".\n");
		for(int i=0; i<output.length();i++){
			if(output.charAt(i)=='.' ){
				output= output.substring(0,i)+".\n"+output.substring(i+2,output.length());
			}
		}
		return output;
	}

	public static String removeAllCapsNewLines(String output) {
		return output = output.replaceAll("\n[A-Z\\s]*\n", "");
	}

	//TODO: This function appears not to work
	public static String removeAllNumOnly(String output) {
		return output.replaceAll("\n[0-9]*\n", "");
	}

	public static String newLinesToSpace(String output) {
		for(int i=0; i<output.length();i++){
			if(output.charAt(i)=='\n'){
				output= output.substring(0,i-1)+" "+output.substring(i+1,output.length());
			}
		}
		return output;
	}

	public static String removeFigsAndTablesRefs(String output) {
		//output = output.replaceAll(" \\(see Fig.\n[0-9]*-[0-9]*\\)", "");
		//output = output.replaceAll(" \\(Fig.\n[0-9]*-[0-9]*[A-Z]*[,]*[\\s]*[A-Z]*\\)", "");
		
		return output.replaceAll("\\([A-z 0-9 \n;,.-]*Fig[A-z 0-9 \n;,.-]*\\)","");//\([A-z]*Fig[A-z 0-9 \n;,.-]*\)
		
	}

	public static String removeAllTitles(String output) {
		output = output.replaceAll("\n([\\s* and but or the is of in vs.]*([A-Z][a-z]*)\\s*\n*)*\n", "");
		return output;
	}
	

}
