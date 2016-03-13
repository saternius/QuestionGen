package PDFParser;

import java.io.IOException;

import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

public class PickyScrapper extends PDFTextStripper{
	private boolean setFontThreshHold = false;
    private float maxFontHeight;
    private float minFontHeight;
	
    
	public PickyScrapper() throws IOException {
		super();
	}
	
	
	  /**
     * Custom function to selectively only have certain fonts parsed versus others
     */
    public void setFontSizeThreshHolds(float min, float max){
    	setFontThreshHold = true;
    	minFontHeight = min;
    	maxFontHeight = max;
    }
    
    @Override
    protected void processTextPosition(TextPosition text){
    	
    	if(setFontThreshHold &&	(text.getHeight()<minFontHeight || text.getHeight()>maxFontHeight) ){
    		return;
    	}
    	super.processTextPosition(text);
    }
    


	
}
