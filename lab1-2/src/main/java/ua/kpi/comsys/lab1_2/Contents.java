package ua.kpi.comsys.lab1_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Contents {
    public static void main(String[] args) {
        // Частина 1
        // Дано рядок у форматі "Student1 - Group1; Student2 - Group2; ..."

        String studentsStr = "Дмитренко Олександр - ІП-84; Матвійчук Андрій - ІВ-83; Лесик Сергій - ІО-82; Ткаченко Ярослав - ІВ-83; Аверкова Анастасія - ІО-83; Соловйов Даніїл - ІО-83; Рахуба Вероніка - ІО-81; Кочерук Давид - ІВ-83; Лихацька Юлія - ІВ-82; Головенець Руслан - ІВ-83; Ющенко Андрій - ІО-82; Мінченко Володимир - ІП-83; Мартинюк Назар - ІО-82; Базова Лідія - ІВ-81; Снігурець Олег - ІВ-81; Роман Олександр - ІО-82; Дудка Максим - ІО-81; Кулініч Віталій - ІВ-81; Жуков Михайло - ІП-83; Грабко Михайло - ІВ-81; Іванов Володимир - ІО-81; Востриков Нікіта - ІО-82; Бондаренко Максим - ІВ-83; Скрипченко Володимир - ІВ-82; Кобук Назар - ІО-81; Дровнін Павло - ІВ-83; Тарасенко Юлія - ІО-82; Дрозд Світлана - ІВ-81; Фещенко Кирил - ІО-82; Крамар Віктор - ІО-83; Іванов Дмитро - ІВ-82";

        // Завдання 1
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – відсортований масив студентів, які відносяться до відповідної групи

        Map<String, ArrayList<String>> studentsGroups = new HashMap<>();

        // Ваш код починається тут
        String[] students = studentsStr.split("; ");
        String[] tmp;
        for(int i=0; i<students.length; i++){
            tmp = students[i].split(" - ");
            if(!studentsGroups.containsKey(tmp[1])) studentsGroups.put(tmp[1], new ArrayList<String>());
            studentsGroups.get(tmp[1]).add(tmp[0]);

        }

        String[] groups = studentsGroups.keySet().toArray(new String[studentsGroups.size()]);
        for(int i=0; i<groups.length;i++){
            Collections.sort(studentsGroups.get(groups[i]));
        }
        // Ваш код закінчується тут

        System.out.println("Завдання 1");
        System.out.println(studentsGroups);
        System.out.println();

        // Дано масив з максимально можливими оцінками
        int[] points = {12, 12, 12, 12, 12, 12, 12, 16};

        // Завдання 2
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – словник, де:
        //   - ключ – студент, який відносяться до відповідної групи
        //   - значення – масив з оцінками студента (заповніть масив випадковими значеннями, використовуючи функцію `randomValue(maxValue: Int) -> Int`)

        Map<String, Map<String, ArrayList<Integer>>> studentPoints = new HashMap<>();

        // Ваш код починається тут
        HashMap<String, ArrayList<Integer>> name_point;
        ArrayList<String> curr_names;
        ArrayList<Integer> curr_p;
        for(int i=0; i<groups.length;i++){
            name_point = new HashMap<>();
            studentPoints.put(groups[i], name_point);
            curr_names = studentsGroups.get(groups[i]);
            for(int j=0; j<curr_names.size(); j++) {
                curr_p = new ArrayList<>();
                name_point.put(curr_names.get(j), curr_p);
                for(int k=0; k<points.length; k++) {
                    curr_p.add(randomValue(points[k]));
                }
            }
        }
        // Ваш код закінчується тут

        System.out.println("Завдання 2");
        System.out.println(studentPoints);
        System.out.println();

        // Завдання 3
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – словник, де:
        //   - ключ – студент, який відносяться до відповідної групи
        //   - значення – сума оцінок студента

        Map<String, Map<String, Integer>> sumPoints = new HashMap<>();

        // Ваш код починається тут
        Integer sum;
        for(int i=0; i<groups.length;i++){
            sumPoints.put(groups[i], new HashMap<String, Integer>());
            curr_names = studentsGroups.get(groups[i]);
            for(int j=0; j<curr_names.size(); j++) {
                sum = 0;
                for(int k=0; k<points.length; k++) {
                    sum += studentPoints.get(groups[i]).get(curr_names.get(j)).get(k);
                }
                sumPoints.get(groups[i]).put(curr_names.get(j), sum);
            }
        }
        // Ваш код закінчується тут

        System.out.println("Завдання 3");
        System.out.println(sumPoints);
        System.out.println();

        // Завдання 4
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – середня оцінка всіх студентів групи

        Map<String, Float> groupAvg = new HashMap<>();

        // Ваш код починається тут
        for(int i=0; i<groups.length; i++) {
            sum = 0;
            curr_names = studentsGroups.get(groups[i]);
            for (int j=0; j<curr_names.size(); j++) {
                sum += sumPoints.get(groups[i]).get(curr_names.get(j));
            }
            groupAvg.put(groups[i], Float.valueOf(sum/curr_names.size()));
        }
        // Ваш код закінчується тут

        System.out.println("Завдання 4");
        System.out.println(groupAvg);
        System.out.println();

        // Завдання 5
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – масив студентів, які мають >= 60 балів

        Map<String, ArrayList<String>> passedPerGroup = new HashMap<>();

        // Ваш код починається тут
        ArrayList<String> curr_pass;
        for (int i=0; i<groups.length; i++) {
            curr_names = studentsGroups.get(groups[i]);
            curr_pass = new ArrayList<>();
            for(int j=0; j<curr_names.size(); j++) {
                if (sumPoints.get(groups[i]).get(curr_names.get(j)) >= 60) {
                    curr_pass.add(curr_names.get(j));
                }
            }
            passedPerGroup.put(groups[i], curr_pass);
        }
        // Ваш код закінчується тут

        System.out.println("Завдання 5");
        System.out.println(passedPerGroup);

// Приклад виведення. Ваш результат буде відрізнятися від прикладу через використання функції random для заповнення масиву оцінок та через інші вхідні дані.
//
//Завдання 1
//["ІВ-73": ["Гончар Юрій", "Давиденко Костянтин", "Капінус Артем", "Науменко Павло", "Чередніченко Владислав"], "ІВ-72": ["Бортнік Василь", "Киба Олег", "Овчарова Юстіна", "Тимко Андрій"], "ІВ-71": ["Андрющенко Данило", "Гуменюк Олександр", "Корнійчук Ольга", "Музика Олександр", "Трудов Антон", "Феофанов Іван"]]
//
//Завдання 2
//["ІВ-73": ["Давиденко Костянтин": [5, 8, 9, 12, 11, 12, 0, 0, 14], "Капінус Артем": [5, 8, 12, 12, 0, 12, 12, 12, 11], "Науменко Павло": [4, 8, 0, 12, 12, 11, 12, 12, 15], "Чередніченко Владислав": [5, 8, 12, 12, 11, 12, 12, 12, 15], "Гончар Юрій": [5, 6, 0, 12, 0, 11, 12, 11, 14]], "ІВ-71": ["Корнійчук Ольга": [0, 0, 12, 9, 11, 11, 9, 12, 15], "Музика Олександр": [5, 8, 12, 0, 11, 12, 0, 9, 15], "Гуменюк Олександр": [5, 8, 12, 9, 12, 12, 11, 12, 15], "Трудов Антон": [5, 0, 0, 11, 11, 0, 12, 12, 15], "Андрющенко Данило": [5, 6, 0, 12, 12, 12, 0, 9, 15], "Феофанов Іван": [5, 8, 12, 9, 12, 9, 11, 12, 14]], "ІВ-72": ["Киба Олег": [5, 8, 12, 12, 11, 12, 0, 0, 11], "Овчарова Юстіна": [5, 8, 12, 0, 11, 12, 12, 12, 15], "Бортнік Василь": [4, 8, 12, 12, 0, 12, 9, 12, 15], "Тимко Андрій": [0, 8, 11, 0, 12, 12, 9, 12, 15]]]
//
//Завдання 3
//["ІВ-72": ["Бортнік Василь": 84, "Тимко Андрій": 79, "Овчарова Юстіна": 87, "Киба Олег": 71], "ІВ-73": ["Капінус Артем": 84, "Науменко Павло": 86, "Чередніченко Владислав": 99, "Гончар Юрій": 71, "Давиденко Костянтин": 71], "ІВ-71": ["Корнійчук Ольга": 79, "Трудов Антон": 66, "Андрющенко Данило": 71, "Гуменюк Олександр": 96, "Феофанов Іван": 92, "Музика Олександр": 72]]
//
//Завдання 4
//["ІВ-71": 79.333336, "ІВ-72": 80.25, "ІВ-73": 82.2]
//
//Завдання 5
//["ІВ-72": ["Бортнік Василь", "Киба Олег", "Овчарова Юстіна", "Тимко Андрій"], "ІВ-73": ["Давиденко Костянтин", "Капінус Артем", "Чередніченко Владислав", "Гончар Юрій", "Науменко Павло"], "ІВ-71": ["Музика Олександр", "Трудов Антон", "Гуменюк Олександр", "Феофанов Іван", "Андрющенко Данило", "Корнійчук Ольга"]]
    }

    private static int randomValue(int maxValue){
        Random rand = new Random();
        switch(rand.nextInt(6)+1) {
            case 1:
                return (int) Math.ceil(maxValue * 0.7);
            case 2:
                return (int) Math.ceil(maxValue * 0.9);
            case 3:
            case 4:
            case 5:
                return maxValue;
            default:
                return 0;
        }
    }
}