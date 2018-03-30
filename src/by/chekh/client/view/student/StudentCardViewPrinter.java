package by.chekh.client.view.student;

import by.chekh.entity.StudentCard;

/**
 * Created by dima on 11/6/2017.
 */
public class StudentCardViewPrinter {

    public static void printStudentCard(StudentCard studentCard){
        System.out.println("-------------Дело студента--------------");
        System.out.println("Полное имя: "+ studentCard.getFullName());
        System.out.println("Дата рождения: "+ studentCard.getBirthDate());
        System.out.println("Номер телефона: "+ studentCard.getPhone());
        System.out.println("Email: "+ studentCard.getEmail());
        System.out.println("Адрес: "+ studentCard.getAddress());
        System.out.println("Университет: "+ studentCard.getUniversity());
        System.out.println("Факультет: "+ studentCard.getFaculty());
        System.out.println("Специальность: "+ studentCard.getSpeciality());
        System.out.println("Группа: "+ studentCard.getGroup());
        System.out.println("Основа: "+ studentCard.getBudget());
        System.out.println("Средняя оценка: "+ studentCard.getAvrMark());
        System.out.println("----------------------------------------");
    }

    public static void printReportNoSuchStudentCard(){
        System.out.println("Данного студента нету в архиве.");
        System.out.println("----------------------------------------");
    }
}
