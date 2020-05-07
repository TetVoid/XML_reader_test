package XMLcreater;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;

public class XMLcreater {
    public void create() {
        String[] names = {"Евгений", "Ольга", "Владимир", "Андрей", "Аастасия", "Ирина"};
        String[] surnames = {"Давыденко", "Шадрин", "Шункевич", "Голенков", "Гулякин", "Семашко"};
        String[] middleName = {"Юрьевич", "Алексеевич", "Владимирович", "Павловна", "Францевна", "Артёмович"};
        String[] stagesStr = {"365", "30", "600", "0", "1", "1000"};
        String[] facultyStr = {"ФИТУ", "КСИС", "ФКП", "ФРЭ", "ИЭФ", "ФСК"};
        String[] departmentsNameStr = {"Искуственный интелект", "Математики", "Иностранных языков", "Физики", "Электронных приборов", "Информационных технологий"};
        String[] academicRankStr = {"Бакалавр", "Кандидат наук", "Доцент", "Профессор", "Лиценциата", "Агреже"};
        String[] academicDegreeStr = {"Доктор информационных наук", "Профессор информационных наук", "Профессор математических наук", "Аспирант", "Доктор математических наук", "Доцент математических наук"};

        String[] fileNames = {"test1.xml", "test2.xml", "test3.xml"};
        for (int j = 0; j < 3; j++) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;


            try {
                builder = factory.newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                ex.printStackTrace();
            }

            Document document = builder.newDocument();
            Element root = document.createElement("base");
            document.appendChild(root);

            for (int i = 0; i < 50; i++) {
                Element note = document.createElement("note");

                Element teacherNameEl = document.createElement("teacherName");
                Element teacherSurnameEl = document.createElement("teacherSurname");
                Element teacherMiddleNameEl = document.createElement("teacherMiddleName");
                Element facultyEl = document.createElement("faculty");
                Element depNameEl = document.createElement("depName");
                Element academRankEl = document.createElement("academRank");
                Element academDegreeEl = document.createElement("academDegree");
                Element stageEl = document.createElement("stage");

                Random random = new Random();
                int[] index =new int[8];
                for(int k=0;k<8;k++)
                    index[k]=random.nextInt(5);

                Text teacherName = document.createTextNode(names[index[0]]);
                Text teacherSurname = document.createTextNode(surnames[index[1]]);
                Text teacherMiddleName = document.createTextNode(middleName[index[2]]);
                Text faculty = document.createTextNode(facultyStr[index[3]]);
                Text depName = document.createTextNode(departmentsNameStr[index[4]]);
                Text academRank = document.createTextNode(academicRankStr[index[5]]);
                Text academDegree = document.createTextNode(academicDegreeStr[index[6]]);
                Text stage = document.createTextNode(stagesStr[index[7]]);

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
            } catch (
                    TransformerConfigurationException e) {
                e.printStackTrace();
            }
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            try {
                transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(fileNames[j])));
            } catch (
                    TransformerException e) {
                e.printStackTrace();
            } catch (
                    FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
