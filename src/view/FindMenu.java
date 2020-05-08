package view;

import controller.Controller;
import controller.PageController;
import view.listeners.FirstButtonListener;
import view.listeners.LastButtonListener;
import view.listeners.NextButtonListener;
import view.listeners.PrevButtonListener;
import model.PatientReport;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import java.util.ArrayList;
import java.util.List;

public class FindMenu {
 List<PatientReport> vectorOfAnswers=new ArrayList<>(0);
 List<PatientReport> findVector=null;
  PageController pageControl=new PageController();
    public void setWorkSpace(List<PatientReport> base, Display display)
    {
       Controller findController=new Controller();
       findVector=base;

       Controller controller=new Controller();
        for (int i=0;i<findVector.size();i++)
        {
            controller.setItemOfTable(findVector.get(i));
        }

       Shell shell=new Shell();
       shell.setLayout(new RowLayout(SWT.VERTICAL));

        Composite group0 = new Composite(shell, SWT.NONE);

     String[] arrayOfButtonsNames={"Teacher name",
             "Teacher surname",
             "Teacher middle name",
             "Faculty",
             "DepartmentsName",
             "MINStage",
             "MAXStage"
                    };

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

        Button startFindButton=new Button(group0,SWT.NONE);

        Combo facultyCombo =new Combo(group0,SWT.DROP_DOWN);
        Combo departmentsNameCombo =new Combo(group0,SWT.DROP_DOWN);
        Combo academicRankCombo =new Combo(group0,SWT.DROP_DOWN);
        Combo academicDegreeCombo =new Combo(group0,SWT.DROP_DOWN);
        for(int i=0;i<base.size();i++)
        {
            base.get(i).getFaculty();
            base.get(i).getDepartmentsName();
            base.get(i).getAcademicDegree();
            base.get(i).getAcademicRank();

            boolean cheak=true;
            for(int j=0;j<facultyCombo.getItemCount();j++)
            {
                if(base.get(i).getFaculty().equals(facultyCombo.getItem(j)))
                {
                    cheak = false;
                    break;
                }
            }
            if(cheak)
                facultyCombo.add(base.get(i).getFaculty());
            else
                cheak=true;
            ///////////////////////////////////////////////////////////////////////////////////////////
            for(int j=0;j<departmentsNameCombo.getItemCount();j++)
            {
                if(base.get(i).getDepartmentsName().equals(departmentsNameCombo.getItem(j)))
                {
                    cheak = false;
                    break;
                }
            }
            if(cheak)
                departmentsNameCombo.add(base.get(i).getDepartmentsName());
            else
                cheak=true;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
            for(int j=0;j<academicRankCombo.getItemCount();j++)
            {
                if(base.get(i).getAcademicRank().equals(academicRankCombo.getItem(j)))
                {
                    cheak = false;
                    break;
                }
            }
            if(cheak)
                academicRankCombo.add(base.get(i).getAcademicRank());
            else
                cheak=true;
///////////////////////////////////////////////////////////////////////////////////////////////////////
            for(int j=0;j<academicDegreeCombo.getItemCount();j++)
            {
                if(base.get(i).getAcademicDegree().equals(academicDegreeCombo.getItem(j)))
                {
                    cheak = false;
                    break;
                }
            }
            if(cheak)
                academicDegreeCombo.add(base.get(i).getAcademicDegree());
            else
                cheak=true;
        }

        startFindButton.setText("Find");

        Table tableView = new Table(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
        tableView.setHeaderVisible(true);

        TableColumn column1 = new TableColumn(tableView, SWT.NONE);
        column1.setText("Teacher name");
        column1.setWidth(140);

        TableColumn column2 = new TableColumn(tableView, SWT.NONE);
        column2.setText("Teacher surname");
        column2.setWidth(140);

        TableColumn column3 = new TableColumn(tableView, SWT.NONE);
        column3.setText("Teacher middle name");
        column3.setWidth(140);

        TableColumn column4 = new TableColumn(tableView, SWT.NONE);
        column4.setText("Faculty");
        column4.setWidth(140);

        TableColumn column5 = new TableColumn(tableView, SWT.NONE);
        column5.setText("DepartmentsName");
        column5.setWidth(180);

        TableColumn column6 = new TableColumn(tableView, SWT.NONE);
        column6.setText("AcademicRank");
        column6.setWidth(140);

        TableColumn column7 = new TableColumn(tableView, SWT.NONE);
        column7.setText("Stage");
        column7.setWidth(80);

        TableColumn column8 = new TableColumn(tableView, SWT.NONE);
        column8.setText("AcademicDegree");
        column8.setWidth(100);

        for(int i=0;i<10;i++)
        {
           TableItem item = new TableItem(tableView, SWT.NONE);
        }

     Composite controlButtons =new Composite(shell,SWT.NONE);
        controlButtons.setLayout(new RowLayout());

     Button firstButton = new Button(controlButtons,SWT.NONE);
     Button prevPage = new Button(controlButtons, SWT.NONE);
     Button nextPage = new Button(controlButtons, SWT.NONE);
     Button lastButton = new Button(controlButtons,SWT.NONE);
     Label pagesLabel=new Label(controlButtons,SWT.NONE);

     Image image1 = new Image(display,"button1.0.png");
     Image image2 = new Image(display,"button2.0.png");
     Image image3 = new Image(display,"button1.png");
     Image image4 = new Image(display,"button2.png");

     firstButton.setImage(image1);
     lastButton.setImage(image2);
     prevPage.setImage(image3);
     nextPage.setImage(image4);

     pagesLabel.setText("0/0");

     firstButton.addSelectionListener(new FirstButtonListener(tableView,pageControl,controller,pagesLabel));

     firstButton.addSelectionListener( new FirstButtonListener(tableView,pageControl,controller,pagesLabel));

     lastButton.addSelectionListener(new LastButtonListener(tableView,pageControl,controller,pagesLabel) );

     nextPage.addSelectionListener(new NextButtonListener(tableView,pageControl,controller,pagesLabel));

     prevPage.addSelectionListener(new PrevButtonListener(tableView,pageControl,controller,pagesLabel));

     startFindButton.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event1)
      {
       findVector=base;
          if(facultyCombo.getSelectionIndex()!=-1)
          {
              controller.deleteElementsOfBase(findVector);

              vectorOfAnswers = findController.findNoteByFaculty(facultyCombo.getItem(facultyCombo.getSelectionIndex()), findVector);
              findVector=vectorOfAnswers;

              for (int i=0;i<findVector.size();i++)
              {
                  controller.setItemOfTable(findVector.get(i));
              }
          }

          if(departmentsNameCombo.getSelectionIndex()!=-1)
          {
              controller.deleteElementsOfBase(findVector);

              vectorOfAnswers = findController.findNoteByDepartmentsName(departmentsNameCombo.getItem(departmentsNameCombo.getSelectionIndex()), findVector);
              findVector=vectorOfAnswers;

              for (int i=0;i<findVector.size();i++)
              {
                  controller.setItemOfTable(findVector.get(i));
              }
          }

          if(academicDegreeCombo.getSelectionIndex()!=-1)
          {
              controller.deleteElementsOfBase(findVector);

              vectorOfAnswers = findController.findNoteByAcademicDegree(academicDegreeCombo.getItem(academicDegreeCombo.getSelectionIndex()), findVector);
              findVector=vectorOfAnswers;

              for (int i=0;i<findVector.size();i++)
              {
                  controller.setItemOfTable(findVector.get(i));
              }
          }

          if(academicRankCombo.getSelectionIndex()!=-1)
          {
              controller.deleteElementsOfBase(findVector);

              vectorOfAnswers = findController.findNoteByAcademicRank(academicRankCombo.getItem(academicRankCombo.getSelectionIndex()), findVector);
              findVector=vectorOfAnswers;

              for (int i=0;i<findVector.size();i++)
              {
                  controller.setItemOfTable(findVector.get(i));
              }
          }



       if(!arrayOfText[0].getText().isEmpty())
       {
           controller.deleteElementsOfBase(findVector);

        vectorOfAnswers = findController.findNoteByTeacherName(arrayOfText[0].getText(), findVector);
        findVector=vectorOfAnswers;

           for (int i=0;i<findVector.size();i++)
           {
               controller.setItemOfTable(findVector.get(i));
           }
       }

       if(!arrayOfText[1].getText().isEmpty())
       {
           controller.deleteElementsOfBase(findVector);

        vectorOfAnswers = findController.findNoteByTeacherSurname(arrayOfText[1].getText(), findVector);
        findVector=vectorOfAnswers;

           for (int i=0;i<findVector.size();i++)
           {
               controller.setItemOfTable(findVector.get(i));
           }
       }

       if(!arrayOfText[2].getText().isEmpty())
       {
           controller.deleteElementsOfBase(findVector);

        vectorOfAnswers = findController.findNoteByTeacherMiddleName(arrayOfText[2].getText(), findVector);
        findVector=vectorOfAnswers;

           for (int i=0;i<findVector.size();i++)
           {
               controller.setItemOfTable(findVector.get(i));
           }
       }

       if(!arrayOfText[3].getText().isEmpty())
       {
           controller.deleteElementsOfBase(findVector);

        vectorOfAnswers = findController.findNoteByFaculty(arrayOfText[3].getText(), findVector);
        findVector=vectorOfAnswers;

           for (int i=0;i<findVector.size();i++)
           {
               controller.setItemOfTable(findVector.get(i));
           }
       }

       if(!arrayOfText[4].getText().isEmpty())
       {
           controller.deleteElementsOfBase(findVector);

        vectorOfAnswers = findController.findNoteByDepartmentsName(arrayOfText[4].getText(), findVector);
        findVector=vectorOfAnswers;

           for (int i=0;i<findVector.size();i++)
           {
               controller.setItemOfTable(findVector.get(i));
           }
       }

       if(!arrayOfText[5].getText().isEmpty() && !arrayOfText[6].getText().isEmpty())
       {
        int MINstage=Integer.valueOf(arrayOfText[5].getText());
        int MAXstage=Integer.valueOf(arrayOfText[6].getText());

        controller.deleteElementsOfBase(findVector);

        vectorOfAnswers = findController.findNoteByStage(MINstage,MAXstage, findVector);
        findVector=vectorOfAnswers;

           for (int i=0;i<findVector.size();i++)
           {
               controller.setItemOfTable(findVector.get(i));
           }
       }


        SeeTable seeTable=new SeeTable();
       seeTable.seeTable(tableView,pageControl.getPage(),vectorOfAnswers,pagesLabel);
      }
     });

        shell.pack();
        shell.open();
    }
}
