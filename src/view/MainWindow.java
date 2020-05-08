package view;

import controller.Controller;
import controller.PageController;
import view.listeners.*;
import XMLcreater.XMLcreater;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;


public class MainWindow {
    public static void main(String[] args) {
        PageController pageControl = new PageController();
        Controller controller = new Controller();
        Shell shell;
        Display display = new Display();
        shell = new Shell(display);
        shell.setLayout(new RowLayout(SWT.VERTICAL));

        XMLcreater creater=new XMLcreater();
        creater.create();

        Composite menuGroup = new Composite(shell, SWT.NONE);
        Composite controlButtons = new Composite(shell, SWT.NONE);



        Button openFile = new Button(menuGroup, SWT.NONE);
        Button saveFile = new Button(menuGroup, SWT.NONE);
        Button addNewNote = new Button(menuGroup, SWT.NONE);
        Button findNote = new Button(menuGroup, SWT.NONE);
        Button deleteNote = new Button(menuGroup, SWT.NONE);

        openFile.setText("open file");
        saveFile.setText("save file");
        addNewNote.setText("add new note");
        findNote.setText("find note");
        deleteNote.setText("delete note");

        String[] arrayOfButtonsNames={"Teacher name",
                "Teacher surname",
                "Teacher middle name",
                "Faculty",
                "DepartmentsName",
                "AcademicRank",
                "Stage",
                "AcademicDegree"
                };

        Composite group0 = new Composite(shell, SWT.NONE);

        Composite[] arrayOfComposites=new Composite[8];
        Label[] arrayOfLabels =new Label[8];
        Text[] arrayOfText =new Text[8];

        for(int i=0;i<8;i++)
        {
            arrayOfComposites[i]=new Composite(group0, SWT.NONE);
            arrayOfComposites[i].setLayout(new RowLayout(SWT.VERTICAL));
            arrayOfLabels[i]=new Label(arrayOfComposites[i],SWT.NONE);
            arrayOfLabels[i].setText(arrayOfButtonsNames[i]);
            arrayOfText[i]=new Text(arrayOfComposites[i],SWT.NONE);
        }

        group0.setLayout(new RowLayout(SWT.HORIZONTAL));
        menuGroup.setLayout(new RowLayout(SWT.HORIZONTAL));
        controlButtons.setLayout(new RowLayout(SWT.HORIZONTAL));


        Table tableView = new Table(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
        tableView.setHeaderVisible(true);

        TableColumn column1 = new TableColumn(tableView, SWT.NONE);
        column1.setText("Name of Teacher");
        column1.setWidth(140);

        TableColumn column2 = new TableColumn(tableView, SWT.NONE);
        column2.setText("Surname of Teacher");
        column2.setWidth(140);

        TableColumn column3 = new TableColumn(tableView, SWT.NONE);
        column3.setText("Middle name of Teacher");
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


        for (int i = 0; i < 10; i++) {
            TableItem item = new TableItem(tableView, SWT.NONE);
        }


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


        firstButton.addSelectionListener( new FirstButtonListener(tableView,pageControl,controller,pagesLabel));

        lastButton.addSelectionListener(new LastButtonListener(tableView,pageControl,controller,pagesLabel) );

        nextPage.addSelectionListener(new NextButtonListener(tableView,pageControl,controller,pagesLabel));

        prevPage.addSelectionListener(new PrevButtonListener(tableView,pageControl,controller,pagesLabel));

        addNewNote.addSelectionListener(new AddButtonListener(tableView,pageControl,controller,pagesLabel,arrayOfText));

        openFile.addSelectionListener(new OpenButtonListener(tableView,pageControl,controller,pagesLabel));

        saveFile.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event1) {
                FileDialog dialog=new FileDialog(shell,SWT.SAVE);
                dialog.setFilterNames(new String[]{"XML files"});
                dialog.setFilterExtensions(new String[]{"*.xml"});
                dialog.open();
                controller.save(dialog.getFileName());

            }
        });



        findNote.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event1) {
                FindMenu menu = new FindMenu();
                menu.setWorkSpace(controller.getTable(),display);
            }
        });

        deleteNote.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event1) {
                DeleteMenu menu = new DeleteMenu();
                menu.setWorkSpace(controller.getTable(),controller);


            }
        });


        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
}
