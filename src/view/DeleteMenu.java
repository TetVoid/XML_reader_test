package view;

import controller.Controller;
import model.PatientReport;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import java.util.ArrayList;
import java.util.List;

public class DeleteMenu {
    List<PatientReport> vectorOfAnswers=new ArrayList<>(0);
    List<PatientReport> findVector=null;

    public void setWorkSpace(List<PatientReport> base, Controller mainController)
    {
        Controller findController=new Controller();
        findVector=base;

        Shell shell=new Shell();
        shell.setLayout(new RowLayout(SWT.VERTICAL));

        Composite group0 = new Composite(shell, SWT.NONE);

        String[] arrayOfButtonsNames={"Teacher name",
                "Teacher surname",
                "Teacher middle name",
                "Faculty",
                "DepartmentsName",
                "MINStage",
                "MAXStage"};

        Composite[] arrayOfComposites=new Composite[7];
        Label[] arrayOfLabels =new Label[7];
        Text[] arrayOfText =new Text[7];

        for(int i=0;i<7;i++)
        {
            arrayOfComposites[i]=new Composite(group0, SWT.NONE);
            arrayOfComposites[i].setLayout(new RowLayout(SWT.VERTICAL));
            arrayOfLabels[i]=new Label(arrayOfComposites[i],SWT.NONE);
            arrayOfLabels[i].setText(arrayOfButtonsNames[i]);
            arrayOfText[i]=new Text(arrayOfComposites[i],SWT.NONE);
        }


        group0.setLayout(new RowLayout(SWT.HORIZONTAL));


        Label answer=new Label(shell,SWT.NONE);
        RowData size=new RowData();
        size.height=30;
        size.width=250;
        answer.setLayoutData(size);

        Button deleteButton =new Button(shell,SWT.NONE);
        deleteButton.setText("Delete");
        deleteButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event1) {
                findVector=base;
                if (!arrayOfText[0].getText().isEmpty()) {
                    vectorOfAnswers = findController.findNoteByTeacherName(arrayOfText[0].getText(), findVector);
                    findVector = vectorOfAnswers;
                }

                if (!arrayOfText[1].getText().isEmpty()) {
                    vectorOfAnswers = findController.findNoteByTeacherSurname(arrayOfText[1].getText(), findVector);
                    findVector = vectorOfAnswers;
                }

                if (!arrayOfText[2].getText().isEmpty()) {
                    vectorOfAnswers = findController.findNoteByTeacherMiddleName(arrayOfText[2].getText(), findVector);
                    findVector = vectorOfAnswers;
                }

                if (!arrayOfText[3].getText().isEmpty()) {
                    vectorOfAnswers = findController.findNoteByFaculty(arrayOfText[3].getText(), findVector);
                    findVector = vectorOfAnswers;
                }

                if (!arrayOfText[4].getText().isEmpty()) {
                    vectorOfAnswers = findController.findNoteByDepartmentsName(arrayOfText[4].getText(), findVector);
                    findVector = vectorOfAnswers;
                }

                if(!arrayOfText[5].getText().isEmpty() && !arrayOfText[6].getText().isEmpty()){
                    int MINstage=Integer.valueOf(arrayOfText[5].getText());
                    int MAXstage=Integer.valueOf(arrayOfText[6].getText());

                    vectorOfAnswers = findController.findNoteByStage(MINstage,MAXstage, findVector);
                    findVector = vectorOfAnswers;
                }


                if(vectorOfAnswers.size()==0)
                    answer.setText("noting to delete");
                else
                    answer.setText(vectorOfAnswers.size()+" elements of base has deleted");
                    mainController.deleteElementsOfBase(vectorOfAnswers);

            }
        });

        shell.pack();
        shell.open();
    }
}
