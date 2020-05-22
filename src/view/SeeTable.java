package view;

import controller.PageController;
import model.PatientReport;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import java.util.List;

public class SeeTable
{
    public void seeTable(Table workSpace, PageController pageControl, List<PatientReport> controller, Label pagesLabel)
    {
        int maxPage=0;
        String pages;

        int temp =pageControl.getPage()+1;
        pages=""+temp+"/"+pageControl.getMaxPage();
        pagesLabel.setText(pages);

        TableItem[] arrayOfItems = workSpace.getItems();
        for (int i = 0; i < 10; i++) {
            if (controller.size() > i) {
                arrayOfItems[i].setText(0, controller.get(i).getTeacherName());
                arrayOfItems[i].setText(1, controller.get(i).getTeacherSurname());
                arrayOfItems[i].setText(2, controller.get(i).getTeacherMiddleName());
                arrayOfItems[i].setText(3, controller.get(i).getFaculty());
                arrayOfItems[i].setText(4, controller.get(i).getDepartmentsName());
                arrayOfItems[i].setText(5, controller.get(i).getAcademicRank());
                arrayOfItems[i].setText(6, Integer.toString(controller.get(i).getStage()));
                arrayOfItems[i].setText(7, controller.get(i).getAcademicDegree());
            } else {
                arrayOfItems[i].setText(0, "");
                arrayOfItems[i].setText(1, "");
                arrayOfItems[i].setText(2, "");
                arrayOfItems[i].setText(3, "");
                arrayOfItems[i].setText(4, "");
                arrayOfItems[i].setText(5, "");
                arrayOfItems[i].setText(6, "");
                arrayOfItems[i].setText(7, "");
            }

        }
    }
}
