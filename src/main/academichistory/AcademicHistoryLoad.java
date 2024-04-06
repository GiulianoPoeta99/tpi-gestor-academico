package main.academichistory;

public class AcademicHistoryLoad extends AcademicHistory {
    public static void data() {
        dataStudent1();
        dataStudent2();
        dataStudent3();
        dataStudent4();
        dataStudent5();
    }

    private static void dataStudent1() {
        new AcademicHistory(1,1, "Aprobado",6,9,false,7,7);
        new AcademicHistory(1,2, "Aprobado",6,5,false,9,9);
        new AcademicHistory(1,3, "Desaprobado",6,5,false,3,2);
        new AcademicHistory(1,3, "Desaprobado",4,7,false,3,3);
        new AcademicHistory(1,3, "Aprobado",6,4,false,10,10);
        new AcademicHistory(1,4, "Aprobado",4,7,false,7,7);
        new AcademicHistory(1,5, "Aprobado",4,4,false,5,5);
        new AcademicHistory(1,6, "Promocionado",8,8,true,0,8);
        new AcademicHistory(1,7, "Promocionado",10,9,true,0,9);
        new AcademicHistory(1,8, "Promocionado",7,9,true,0,8);
        new AcademicHistory(1,9, "Aprobado",4,9,false,5,5);
        new AcademicHistory(1,10, "Aprobado",8,6,false,10,10);
        new AcademicHistory(1,11, "Aprobado",6,5,false,4,4);
        new AcademicHistory(1,12, "Aprobado",6,9,false,6,6);
        new AcademicHistory(1,13, "Promocionado",7,9,true,0,8);
        new AcademicHistory(1,14, "Aprobado",6,9,false,7,7);
        new AcademicHistory(1,15, "Aprobado",6,9,false,8,8);
        new AcademicHistory(1,16, "Promocionado",7,7,true,0,7);
        new AcademicHistory(1,17, "Aprobado",6,9,false,10,10);
    }

    private static void dataStudent2() {
        new AcademicHistory(2,51, "Aprobado",6,9,false,7,7);
    }

    private static void dataStudent3() {
        new AcademicHistory();
    }

    private static void dataStudent4() {
        new AcademicHistory();
    }

    private static void dataStudent5() {
        new AcademicHistory();
    }
}
