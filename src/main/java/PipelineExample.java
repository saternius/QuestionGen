import edu.illinois.cs.cogcomp.annotation.AnnotatorException;
import edu.illinois.cs.cogcomp.annotation.AnnotatorService;
import edu.illinois.cs.cogcomp.core.datastructures.ViewNames;
import edu.illinois.cs.cogcomp.core.datastructures.textannotation.*;
import edu.illinois.cs.cogcomp.core.utilities.configuration.ResourceManager;
import edu.illinois.cs.cogcomp.nlp.pipeline.IllinoisPipelineFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajason2 on 3/12/16.
 */
public class PipelineExample {
    public static void main(String [] args) throws IOException, AnnotatorException{


        System.out.println(System.getProperty("java.library.path"));

        String docId = "APW-20140101.3018"; // arbitrary string identifier
        String textId = "body"; // arbitrary string identifier
        String text = "There once was a happy boy named Bobby. Bobby had a silly dog named doe. Doe got hit by a car and died. Now Bobby is a sad boy."; // contains plain text to be annotated

        ResourceManager rm = new ResourceManager( "config/pipeline-config.properties" );
        AnnotatorService pipeline = IllinoisPipelineFactory.buildPipeline( rm );
        TextAnnotation ta = pipeline.createAnnotatedTextAnnotation( docId, textId, text );
        System.out.println("TextAnnotation possibilities-------------");

        System.out.println("text: "+ta.getText());
        System.out.println("Number of sentences: "+ta.getNumberOfSentences());
        System.out.println(ta.sentences());
        List<Sentence> sentences = ta.sentences();
        View view = ta.getView(ViewNames.PARSE_STANFORD);



        System.out.println("Num Constituents: "+view.getConstituents().size());
        for(Constituent constituent : view.getConstituents()){
            System.out.println(constituent.toString() + " -> "+constituent.getLabel());
        }

        System.out.println("Num relations: "+view.getRelations().size());
        for(Relation r: view.getRelations()){
            System.out.println(r.getSource().toString() +" -- "+r.getRelationName()+" -- "+r.getTarget());
        }

    }
}
