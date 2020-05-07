package view.listeners;

import controller.Controller;
import controller.PageController;
import view.SeeTable;
import model.PatientReport;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddButtonListener extends SelectionAdapter
{
    PageController pageControl=null;
    Table tableView= null;
    Controller controller= null;
    Label pagesLabel=null;
    Text[] arrayOfText=new Text[7];
    public AddButtonListener(Table table, PageController tempValue, Controller tempController, Label tempLabel, Text[] tempArrayOfText)
    {
        tableView=table;
        controller=tempController;
        pagesLabel=tempLabel;
        pageControl=tempValue;
        arrayOfText=tempArrayOfText;
    }

    public void widgetSelected(SelectionEvent event1) {
        PatientReport newItem = new PatientReport();
        newItem.setTeacherName(arrayOfText[0].getText());
        newItem.setTeacherSurname(arrayOfText[1].getText());
        newItem.setTeacherMiddleName(arrayOfText[2].getText());
        newItem.setFaculty(arrayOfText[3].getText());
        newItem.setDepartmentsName(arrayOfText[4].getText());
        newItem.setAcademicRank(arrayOfText[5].getText());
        newItem.setStage(Integer.valueOf(arrayOfText[6].getText()));
        newItem.setAcademicDegree(arrayOfText[7].getText());

        controller.setItemOfTable(newItem);

        SeeTable view = new SeeTable();
        view.seeTable(tableView, pageControl.getPage(), controller.getTable(),pagesLabel);
    }
}
