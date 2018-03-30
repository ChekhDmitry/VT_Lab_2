package by.chekh.client.view.student;

import by.chekh.entity.StudentCard;

import java.util.Scanner;

/**
 * Created by dima on 11/6/2017.
 */
public class StudentCardViewInput {

    private static Scanner scanner = new Scanner(System.in);

    public static StudentCard studentCardCreationInput(){
        StudentCard studentCard = new StudentCard();
        System.out.println("------ФОРМА СОЗДАНИЯ ДЕЛА СТУДЕНТА------");
        System.out.print("Введите полное имя: ");
        studentCard.setFullName(scanner.nextLine().trim());
        System.out.print("Введите дату рождения: ");
        studentCard.setBirthDate(scanner.nextLine().trim());
        System.out.print("Введите номер телефона: ");
        studentCard.setPhone(scanner.nextLine().trim());
        System.out.print("Введите email: ");
        studentCard.setEmail(scanner.nextLine().trim());
        System.out.print("Введите адрес: ");
        studentCard.setAddress(scanner.nextLine().trim());
        System.out.print("Введите название университета: ");
        studentCard.setUniversity(scanner.nextLine().trim());
        System.out.print("Введите название факультета: ");
        studentCard.setFaculty(scanner.nextLine().trim());
        System.out.print("Введите название специальности: ");
        studentCard.setSpeciality(scanner.nextLine().trim());
        System.out.print("Введите номер группы: ");
        studentCard.setGroup(scanner.nextLine().trim());
        System.out.print("Введите экономическую основу (бюджет, платная): ");
        studentCard.setBudget(scanner.nextLine().trim());
        System.out.print("Введите средний балл: ");
        studentCard.setAvrMark(Double.parseDouble(scanner.nextLine().trim()));
        System.out.println("----------------------------------------");
        studentCard.setId(0);
        return studentCard;
    }

    public static StudentCard studentCardEditInput(StudentCard studentCard){
        String value = "";
        System.out.println("-------ФОРМА РЕДАКТИРОВАНИЯ ДЕЛА--------");
        System.out.println("Enter - пропуск поля.");
        System.out.println("----------------------------------------");
        System.out.print("Имя студента ("+ studentCard.getFullName()+"): ");
        value = scanner.nextLine().trim();
        studentCard.setFullName(value.equals("")? studentCard.getFullName():value);
        System.out.print("Дата рождения ("+ studentCard.getBirthDate()+"): ");
        value = scanner.nextLine().trim();
        studentCard.setBirthDate(value.equals("")? studentCard.getBirthDate():value);
        System.out.print("Номер телефона ("+studentCard.getPhone()+"): ");
        value = scanner.nextLine().trim();
        studentCard.setPhone(value.equals("")? studentCard.getPhone():value);
        System.out.print("Email ("+studentCard.getEmail()+"): ");
        value = scanner.nextLine().trim();
        studentCard.setEmail(value.equals("")? studentCard.getEmail():value);
        System.out.print("Адрес ("+studentCard.getAddress()+"): ");
        value = scanner.nextLine().trim();
        studentCard.setAddress(value.equals("")? studentCard.getAddress():value);
        System.out.print("Название университета ("+studentCard.getUniversity()+"): ");
        value = scanner.nextLine().trim();
        studentCard.setUniversity(value.equals("")? studentCard.getUniversity():value);
        System.out.print("Название факультета ("+studentCard.getFaculty()+"): ");
        value = scanner.nextLine().trim();
        studentCard.setFaculty(value.equals("")? studentCard.getFaculty():value);
        System.out.print("Название специальности ("+studentCard.getSpeciality()+"): ");
        value = scanner.nextLine().trim();
        studentCard.setSpeciality(value.equals("")? studentCard.getSpeciality():value);
        System.out.print("Номер группы ("+studentCard.getGroup()+"): ");
        value = scanner.nextLine().trim();
        studentCard.setGroup(value.equals("")? studentCard.getGroup():value);
        System.out.print("Экономическую основа (бюджет, платная)("+studentCard.getBudget()+"): ");
        value = scanner.nextLine().trim();
        studentCard.setBudget(value.equals("")? studentCard.getBudget():value);
        System.out.print("Средний балл ("+studentCard.getAvrMark()+"): ");
        value = scanner.nextLine().trim();
        studentCard.setAvrMark(Double.parseDouble(value.equals("")? String.valueOf(studentCard.getAvrMark()) :value));
        System.out.println("----------------------------------------");
        return studentCard;
    }

    public static String studentCardNameInput(){
        System.out.print("Введите полное имя студента: ");
        String studentName = scanner.nextLine().trim();
        System.out.println("----------------------------------------");
        return studentName;
    }
}
