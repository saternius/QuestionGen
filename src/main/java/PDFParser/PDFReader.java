package PDFParser;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;


public class PDFReader {

    private PDFParser parser;
    private PickyScrapper pdfStripper;
    private PDDocument pdDoc;
    private COSDocument cosDoc;

    private String Text;
    private String filePath;
    private File file;
    private float maxFontHeight;
    private float minFontHeight;
    static ArrayList<Float> polyX = new ArrayList<Float>();
    static ArrayList<Float> polyY = new ArrayList<Float>();

    public PDFReader(float minFH, float maxFH) {
        maxFontHeight = maxFH;
        minFontHeight = minFH;
    }

    public String ToText() throws IOException {

        this.pdfStripper = null;
        this.pdDoc = null;
        this.cosDoc = null;

        file = new File(filePath);
        parser = new PDFParser(new RandomAccessFile(file, "r")); // update for PDFBox V 2.0

        parser.parse();
        cosDoc = parser.getDocument();
        pdfStripper = new PickyScrapper();
        pdDoc = new PDDocument(cosDoc);
        pdDoc.getNumberOfPages();
        pdfStripper.setStartPage(1);
        pdfStripper.setEndPage(1);
        pdfStripper.setFontSizeThreshHolds(minFontHeight, maxFontHeight);
        // reading text from page 1 to 10
        // if you want to get text from full pdf file use this code
        //pdfStripper.setEndPage(pdDoc.getNumberOfPages());

        Text = pdfStripper.getText(pdDoc);
        return Text;
    }


    @SuppressWarnings({"unchecked", "deprecation"})
//public void exportImages() throws IOException{
//
////	// For simplicity the code provided doesn't have any null checks or
////    // exception handling !!
////       PDDocument document = PDDocument.load(new File(filePath));
////	   PDPage page = (PDPage)
////	   document.getDocumentCatalog().getPages().get(0);
////
////	   // The transparency, opacity of graphic objects can't be set directly on the drawing commands.
////	   // Instead we need to define a graphic state which will become part of the
////	   // resources. That state can be called later prior to doing the graphic operations.
////	   // That's part of the ISO/PDF specification [ISO-32000: 8.4.1]
////
////	   /* --------- Set up the graphic state -------------- */
////	   // Define a new extended graphic state
////	   PDExtendedGraphicsState extendedGraphicsState = new PDExtendedGraphicsState();
////	   // Set the transparency/opacity
////	   extendedGraphicsState.setNonStrokingAlphaConstant(0.2f);
////	   // Get the page resources.
////	   PDResources resources = page.getResources();
////	   resources.add(extendedGraphicsState);
////	   // Get the defined graphic states.
////	  // Map graphicsStateDictionary = resources.getGraphicsStates();
////	   // Add the new state definition. The name is the reference w need later on.
////	  // graphicsStateDictionary.put("TransparentState", extendedGraphicsState);
////	  // resources.setGraphicsStates(graphicsStateDictionary);
////	   /* --------- End of setup -------------------------- */
////	   // Now we will be able to call the state definition before doing the drawing
////	   PDPageContentStream contentStream = new PDPageContentStream(document, page,true,true);
////	   // Call the graphic state using the name defined
////	 //  contentStream.appendRawCommands("/TransparentState gs\n");
////	   //contentStream.app
////	   contentStream.setNonStrokingColor(Color.yellow);
////	   contentStream.addRect(100, 100, 200, 200);
////	   contentStream.close();
////	 // document.save(...);
////	 //  document.close();
//
//	   PDDocument document = PDDocument.load(new File(filePath));
//
//	   PDPageContentStream contentStream = new PDPageContentStream(document, document.getPage(0), true, true, true);
//	   PDRectangle pageSize = document.getPage(0).getMediaBox();
//
//	   contentStream.setNonStrokingColor(Color.red);
//	   contentStream.setStrokingColor(Color.red);
//	  // contentStream.addRect(pageSize.getLowerLeftX() + x, pageSize.getLowerLeftY() + y, w, h);
//	   float[] pX = new float[polyX.size()];
//	   float[] pY = new float[polyY.size()];
//	   for(int i=0; i<polyX.size(); i++){
//		  pX[i] = pageSize.getLowerLeftX()+polyX.get(i);
//		  pY[i] = pageSize.getLowerLeftY()+polyY.get(i)-100;
//	   }
//	  // contentStream.addPolygon(pX, pY);
//	   contentStream.drawPolygon(pX, pY);
//	   contentStream.close();
//
//
//////	   PDPage page = (PDPage)document.getDocumentCatalog.getAllPages.get(i);
//////
//////	   for (int page = 0; page < 2; ++page)
//////	   {
//////	       */
//////	       // suffix in filename will be used as the file format
////	   		PDFRenderer pdfRenderer = new PDFRenderer(document);
////	   		BufferedImage bim = pdfRenderer.renderImageWithDPI(0, 300, ImageType.RGB);
////	        ImageIOUtil.writeImage(bim, "img" + "-" + (1) + ".png", 300);
//////	   //}
////	   document.close();
//   }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}