import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XSLTTransformer {
    public static void main(String[] args) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Source xslt = new StreamSource(new File("src/transform.xslt"));
            Transformer transformer = factory.newTransformer(xslt);
            Source text = new StreamSource(new File("src/library.xml"));
            transformer.transform(text, new StreamResult(new File("src/output.html")));
            System.out.println("XML преобразован в HTML.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
