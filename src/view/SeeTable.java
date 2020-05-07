package view;

import model.PatientReport;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import java.util.List;

public class SeeTable
{
    public void seeTable(Table workSpace, int pageControl, List<PatientReport> controller, Label pagesLabel)
    {
        int maxPage=0;
        String pages;
        if(controller.size()%10==0)
            maxPage=controller.size()/10;
        else
            maxPage=controller.size()/10+1;
        int temp =pageControl+1;
        pages=""+temp+"/"+maxPage;
        pagesLabel.setText(pages);

        TableItem[] arrayOfItems = workSpace.getItems();
        for (int i = 0; i < 10; i++) {
            if (controller.size() - 10 * pageControl > i) {
                arrayOfItems[i].setText(0, controller.get(i + pageControl*10).getTeacherName());
                arrayOfItems[i].setText(1, controller.get(i + pageControl*10).getTeacherSurname());
                arrayOfItems[i].setText(2, controller.get(i + pageControl*10).getTeacherMiddleName());
                arrayOfItems[i].setText(3, controller.get(i + pageControl*10).getFaculty());
                arrayOfItems[i].setText(4, controller.get(i + pageControl*10).getDepartmentsName());
                arrayOfItems[i].setText(5, controller.get(i + pageControl*10).getAcademicRank());
                arrayOfItems[i].setText(6, Integer.toString(controller.get(i + pageControl*10).getStage()));
                arrayOfItems[i].setText(7, controller.get(i + pageControl*10).getAcademicDegree());
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
