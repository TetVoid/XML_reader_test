package controller;

import model.PatientReport;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import parser.SAXPars;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<PatientReport> table=new ArrayList<>(0);


    public void clear()
    {
     table.clear();
    }
    public List<PatientReport> findNoteByTeacherSurname(String patientSurname, List<PatientReport> findingVector)
    {
        List<PatientReport> needToFind=new ArrayList<>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(patientSurname.equals(findingVector.get(i).getTeacherSurname()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }

    public List<PatientReport> getTable()
    {
        return table;
    }

    public List<PatientReport> findNoteByTeacherName(String patientSurname, List<PatientReport> findingVector)
    {
        List<PatientReport> needToFind=new ArrayList<>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(patientSurname.equals(findingVector.get(i).getTeacherName()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }

    public List<PatientReport> findNoteByTeacherMiddleName(String patientSurname, List<PatientReport> findingVector)
    {
        List<PatientReport> needToFind=new ArrayList<>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(patientSurname.equals(findingVector.get(i).getTeacherMiddleName()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }

    public List<PatientReport> findNoteByFaculty(String patientAddress, List<PatientReport> findingVector)
    {
        List<PatientReport> needToFind=new ArrayList<>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(patientAddress.equals(findingVector.get(i).getFaculty()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }

    public List<PatientReport> findNoteByStage(int MINstage,int MAXstage, List<PatientReport> findingVector)
    {
        List<PatientReport> needToFind=new ArrayList<>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(MAXstage>=findingVector.get(i).getStage() && MINstage<=findingVector.get(i).getStage())
                needToFind.add(findingVector.get(i));
        }
        return needToFind;

    }

    public List<PatientReport> findNoteByDepartmentsName(String doctorName, List<PatientReport> findingVector)
    {
        List<PatientReport> needToFind=new ArrayList<>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(doctorName.equals(findingVector.get(i).getDepartmentsName()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }

    public List<PatientReport> findNoteByAcademicRank(String doctorSurname, List<PatientReport> findingVector)
    {
        List<PatientReport> needToFind=new ArrayList<>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(doctorSurname.equals(findingVector.get(i).getAcademicRank()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }

    public List<PatientReport> findNoteByAcademicDegree(String doctorMiddleName, List<PatientReport> findingVector)
    {
        List<PatientReport> needToFind=new ArrayList<>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(doctorMiddleName.equals(findingVector.get(i).getAcademicDegree()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }

    public void deleteElementsOfBase(List<PatientReport> needDeleteElements)
    {
        for(int i=0;i<needDeleteElements.size();i++)
            table.remove(needDeleteElements.get(i));
    }

    public void save(String nameOfFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = builder.newDocument();
        Element root = document.createElement("base");
        document.appendChild(root);
        for (int i = 0; i < table.size(); i++) {
            Element note = document.createElement("note");

            Element teacherNameEl = document.createElement("teacherName");
            Element teacherSurnameEl = document.createElement("teacherSurname");
            Element teacherMiddleNameEl = document.createElement("teacherMiddleName");
            Element facultyEl = document.createElement("faculty");
            Element depNameEl = document.createElement("depName");
            Element academRankEl = document.createElement("academRank");
            Element academDegreeEl = document.createElement("academDegree");
            Element stageEl = document.createElement("stage");


            Text teacherName = document.createTextNode(table.get(i).getTeacherName());
            Text teacherSurname = document.createTextNode(table.get(i).getTeacherSurname());
            Text teacherMiddleName = document.createTextNode(table.get(i).getTeacherMiddleName());
            Text faculty = document.createTextNode(table.get(i).getFaculty());
            Text depName = document.createTextNode(table.get(i).getDepartmentsName());
            Text academRank = document.createTextNode(table.get(i).getAcademicRank());
            Text academDegree = document.createTextNode(table.get(i).getAcademicDegree());
            Text stage = document.createTextNode(Integer.toString(table.get(i).getStage()));


            note.appendChild(teacherNameEl);
            note.appendChild(teacherSurnameEl);
            note.appendChild(teacherMiddleNameEl);
            note.appendChild(facultyEl);
            note.appendChild(depNameEl);
            note.appendChild(academRankEl);
            note.appendChild(academDegreeEl);
            note.appendChild(stageEl);

            teacherNameEl.appendChild(teacherName);
            teacherSurnameEl.appendChild(teacherSurname);
            teacherMiddleNameEl.appendChild(teacherMiddleName);
            facultyEl.appendChild(faculty);
            depNameEl.appendChild(depName);
            academRankEl.appendChild(academRank);
            academDegreeEl.appendChild(academDegree);
            stageEl.appendChild(stage);

            root.appendChild(note);
        }
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        try {
            transformer.transform(new DOMSource(document),new StreamResult(new FileOutputStream(nameOfFile)));
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void load(String nameOfFile)
    {
        SAXParserFactory factory=SAXParserFactory.newInstance();
        SAXParser parser = null;
        try
        {
            parser = factory.newSAXParser();
            SAXPars saxp=new SAXPars();

            parser.parse(new File(nameOfFile),saxp);
            table= saxp.getResult();
        } catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (SAXException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void setItemOfTable(PatientReport item)
    {
        table.add(item);
    }

    public List<PatientReport> getPageOfTable(int pageNumber)
    {
        List<PatientReport> tablePage=new ArrayList<>(0);

        for(int i=0;i<10;i++)
        {
            if(table.size()-10*pageNumber>i)
            tablePage.add(table.get(i+10*pageNumber));
        }
        return tablePage;
    }
}
