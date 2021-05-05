package com.max.opTask;

import com.max.opTask.repositories.SessionBuilder;
import com.max.opTask.views.*;

import java.util.Scanner;

public class ProgramStarter {
    GenericView view;
    Scanner scanner = new Scanner(System.in);

    public void start() {
        MainView.actions();
        int action = scanner.nextInt();
        MainView.models();
        setView();
        SessionBuilder.openSession();
        switch (action) {
            case 1:
                view.printAll();
                break;
            case 2:
                System.out.println(view.save());
                break;
            case 3:
                System.out.println(view.Update());
                break;
            case 4:
                view.delete();
                break;
            case 5:
                SessionBuilder.closeSession();
                System.exit(0);
                break;
        }
        start();
    }

    public void setView() {
        switch (scanner.nextInt()) {
            case 1:
                view = new TechnicalBookView();
                break;

            case 2:
                view = new FictionBookView();
                break;
            case 3:
                view = new ChildBookView();
                break;
        }
    }
}
