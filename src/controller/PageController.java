package controller;

public class PageController {
    int page=0;
    public void nextPage(Controller controller)
    {
        if(controller.getTable().size()%10==0)
        {
            if(controller.getTable().size()/10-1>page)
            page++;
        }
        else
        {
            if(controller.getTable().size()/10>page)
                page++;
        }
    }

    public void prevPage()
    {
        if(page>0)
            page--;
    }

    public void lastPage(Controller controller)
    {
        if(controller.getTable().size()%10==0)
        {
            page = controller.getTable().size() / 10-1;
        }
        else
        {
            page = controller.getTable().size() / 10;
        }
    }

    public void firsPage()
    {
        page=0;
    }

    public int getPage()
    {
        return page;
    }
}
