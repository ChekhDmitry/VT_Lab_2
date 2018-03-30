package by.chekh.client.view.menu;

/**
 * Created by dima on 11/6/2017.
 */
public class MenuViewPrinter {

    public static void printMenu(String role){
        System.out.println("-----------------МЕНЮ-------------------");
        System.out.println("1 - Поиск дела студента");
        if(role.equals("admin")) {
            System.out.println("2 - Создание дела студента");
            System.out.println("3 - Редактирование дела студента");
        }
        System.out.println("4 - Выход");
        System.out.println("----------------------------------------");
    }

    public static void printRoleMenu(){
        System.out.println("--------ОПРЕДЕЛИТЕ ПРАВА ДОСТУПА--------");
        System.out.println("1 - Администратор");
        System.out.println("2 - Преподаватель");
        System.out.println("----------------------------------------");
    }
}
