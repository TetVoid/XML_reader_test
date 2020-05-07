package parser;

import model.PatientReport;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Vector;

public class SAXPars extends DefaultHandler {
    Vector<PatientReport> array=new Vector<PatientReport>(0);
    PatientReport item = null;
    String thisElement = "";

    public Vector<PatientReport> getResult(){
        return array;
    }


    public void startDocument()  {
        System.out.println("Start parse XML...");
    }


    public void startElement(String namespaceURI, String localName, String qName, Attributes atts)  {

        thisElement = qName;
        if(thisElement.equals("note"))
            item= new PatientReport();
    }


    public void endElement(String namespaceURI, String localName, String qName) {
        if(qName.equals("note"))
            array.addElement(item);
        thisElement = "";
    }


    public void characters(char[] ch, int start, int length) {

        if (thisElement.equals("stage"))
        {
            item.setStage(Integer.valueOf(new String(ch, start, length)));
        }
        if (thisElement.equals("teacherName")) {
            item.setTeacherName(new String(ch, start, length));
        }
        if (thisElement.equals("teacherSurname")) {
            item.setTeacherSurname(new String(ch, start, length));
        }
        if (thisElement.equals("teacherMiddleName")) {
            item.setTeacherMiddleName(new String(ch, start, length));
        }
        if (thisElement.equals("faculty")) {
            item.setFaculty(new String(ch, start, length));
        }
        if (thisElement.equals("depName")) {
            item.setDepartmentsName(new String(ch, start, length));
        }
        if (thisElement.equals("academRank")) {
            item.setAcademicRank(new String(ch, start, length));
        }
        if (thisElement.equals("academDegree")) {
            item.setAcademicDegree(new String(ch, start, length));
        }

    }


    public void endDocument() {
        System.out.println("Stop parse XML...");
    }
}

