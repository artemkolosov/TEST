import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws MyExeption {

        String vyvod = new String();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметический пример");
        String vvod = scanner.nextLine();

        vyvod = calc(vvod);
        System.out.println(vyvod);

    }


    public static String calc(String input) {

        boolean arithmeticPrimerCorrect, arabic;
        String[] romeInput = new String[]{" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };
        String[] arabicInput = new String[]{" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        char[] operatorInput = new char[]{'+', '-', '*', '/'};
        String argument1, argument2, arithmeticPrimer = new String();
        char operator;
        int finalArgument1, finalArgument2, finalResultArabic, lengthPrimer;
        Scanner scanner = new Scanner(System.in);
        finalArgument1 = 0;
        finalArgument2 = 0;
        finalResultArabic = 0;
    //Проверка корректности введенных данных.
        //Общая длина примера
        arithmeticPrimer = input;
        lengthPrimer = arithmeticPrimer.length();
        if (lengthPrimer > 11) {
            //По условиям получатеся максимальная длина примера не более 11 символов, включая внутренние пробелы.
            // Пробелов после примера быть не должно, так как маска вводимых данных 'a + b'.

            arithmeticPrimerCorrect = false;

            if (arithmeticPrimerCorrect == false) {
                try {
                    throw new MyExeption("Некорректные данные");
                } catch (MyExeption e) {
                    System.err.println(e.getMessage());;
                }
            }
            System.out.println("Недопустимая длина выражения");
            System.exit(0);
        }

        // Нулевая длинна примера

        if (lengthPrimer < 1) {
            arithmeticPrimerCorrect = false;

            if (arithmeticPrimerCorrect == false) {
                try {
                    throw new MyExeption("Некорректные данные");
                } catch (MyExeption e) {
                    System.err.println(e.getMessage());;
                }
            }
            System.out.println("Ничего не введено");
            System.exit(0);
        }


        // Разложим строку на символы. Создадим массив символов
        char[] arrayPrimer = new char[lengthPrimer];
        for (int i = 0; i < lengthPrimer; i++)
        {
            arrayPrimer[i] = arithmeticPrimer.charAt(i);
        }

        //Проверка на пробел в начале выражения
        if (arrayPrimer[0] == ' ') {
            arithmeticPrimerCorrect = false;

            if (arithmeticPrimerCorrect == false) {
                try {
                    throw new MyExeption("Некорректные данные");
                } catch (MyExeption e) {
                    System.err.println(e.getMessage());;
                }
            }
            System.out.println("Пробел в начале выражения");
            System.exit(0);
        }
        //Проверка на пробел в конце выражения
        if (arrayPrimer[lengthPrimer-1] == ' ') {
            arithmeticPrimerCorrect = false;

            if (arithmeticPrimerCorrect == false) {
                try {
                    throw new MyExeption("Некорректные данные");
                } catch (MyExeption e) {
                    System.err.println(e.getMessage());;
                }
            }
            System.out.println("Пробел(ы) в конце выражения");
            System.exit(0);
        }

        //Проверка на двойной пробел
        for (int i = 0; i < lengthPrimer - 1; i++) {
            if (arrayPrimer[i] == ' ' & arrayPrimer[i + 1] == ' ') {arithmeticPrimerCorrect = false;

                if (arithmeticPrimerCorrect == false) {
                    try {
                        throw new MyExeption("Некорректные данные");
                    } catch (MyExeption e) {
                        System.err.println(e.getMessage());;
                    }
                }
                System.out.println("Лишние пробелы между аргументами");
                System.exit(0);
            }
        }



        //Получение аргументов и операторов. Здесь строка ввода с арабскими аргументами считается корректной.
        int i = 0;
        argument1 = "";
        while (arrayPrimer[i] != ' ' & i < lengthPrimer-1) {
            argument1 = argument1 + arrayPrimer[i];
            i++;
        }

        // Вставим проверку на отсутствие в выражении пробелов

        if (i>=lengthPrimer-1) {
            arithmeticPrimerCorrect = false;

            if (arithmeticPrimerCorrect == false) {
                try {
                    throw new MyExeption("Некорректные данные");
                } catch (MyExeption e) {
                    System.err.println(e.getMessage());;
                }
            }
            System.out.println("Недопустимое выражение");
            System.exit(0);
        }


        i = i + 1;
        operator = arrayPrimer[i];



        i = i + 2;
        argument2 = "";
        for (i = i; i < lengthPrimer; i++) {
            argument2 = argument2 + arrayPrimer[i];
        }




        //Проверка аргумента
        boolean arabicArgument1 = false;
        for (i = 1; i <= 10; i++) {
            if (argument1.equals(arabicInput[i])) {
                arabicArgument1 = true;
            }
        }
        boolean arabicArgument2 = false;
        for (i = 1; i <= 10; i++) {
            if (argument2.equals(arabicInput[i])) {
                arabicArgument2 = true;
            }
        }

        boolean romeArgument1 = false;
        for (i = 1; i <= 10; i++) {
            if (argument1.equals(romeInput[i])) {
                romeArgument1 = true;
            }
        }
        boolean romeArgument2 = false;
        for (i = 1; i <= 10; i++) {
            if (argument1.equals(romeInput[i])) {
                romeArgument2 = true;
            }
        }


        boolean bothArabicCorrect = arabicArgument1 & arabicArgument2;


        arabic = false;

        if (bothArabicCorrect){
            arabic = true;
        }

        // Если аргументы арабские парсим их из строки в числа

        if (arabic) {

            finalArgument1 = Integer.parseInt(argument1);
            finalArgument2 = Integer.parseInt(argument2);

        } else {
            // Иначе сопоставляем с римскими числами
            //Перевод римских аргументов в арабские
            switch (argument1) {
                case "I":
                    finalArgument1 = 1;
                    break;
                case "II":
                    finalArgument1 = 2;
                    break;
                case "III":
                    finalArgument1 = 3;
                    break;
                case "IV":
                    finalArgument1 = 4;
                    break;
                case "V":
                    finalArgument1 = 5;
                    break;
                case "VI":
                    finalArgument1 = 6;
                    break;
                case "VII":
                    finalArgument1 = 7;
                    break;
                case "VIII":
                    finalArgument1 = 8;
                    break;
                case "IX":
                    finalArgument1 = 9;
                    break;
                case "X":
                    finalArgument1 = 10;
                    break;
                default: // Иначе получаются некорректные аргументы
                    arithmeticPrimerCorrect = false;

                    if (arithmeticPrimerCorrect == false) {
                        try {
                            throw new MyExeption("Некорректные данные");
                        } catch (MyExeption e) {
                            System.err.println(e.getMessage());;
                        }

                        System.out.println("Недопустимые аргументы");
                        System.exit(0);
                    }

            }
            switch (argument2) {
                case "I":
                    finalArgument2 = 1;
                    break;
                case "II":
                    finalArgument2 = 2;
                    break;
                case "III":
                    finalArgument2 = 3;
                    break;
                case "IV":
                    finalArgument2 = 4;
                    break;
                case "V":
                    finalArgument2 = 5;
                    break;
                case "VI":
                    finalArgument2 = 6;
                    break;
                case "VII":
                    finalArgument2 = 7;
                    break;
                case "VIII":
                    finalArgument2 = 8;
                    break;
                case "IX":
                    finalArgument2 = 9;
                    break;
                case "X":
                    finalArgument2 = 10;
                    break;
                default: // Иначе получаются некорректные аргументы
                    arithmeticPrimerCorrect = false;

                    if (arithmeticPrimerCorrect == false) {
                        try {
                            throw new MyExeption("Некорректные данные");
                        } catch (MyExeption e) {
                            System.err.println(e.getMessage());;
                        }

                        System.out.println("Недопустимые аргументы");
                        System.exit(0);
                    }
            }
        }

        //Проверка оператора

        boolean corectOperator = false;

        for (i = 0; i < 4; i++) {
            if (operator == operatorInput[i]) {
                corectOperator = true;
            }
        }

        if (corectOperator == false) {arithmeticPrimerCorrect = false;

            if (arithmeticPrimerCorrect == false) {
                try {
                    throw new MyExeption("Некорректные данные");
                } catch (MyExeption e) {
                    System.err.println(e.getMessage());;
                }
            }
            System.out.println("Некорректный оператор");
            System.exit(0);
        }

        switch (operator) {
            case '+':
                finalResultArabic = finalArgument1 + finalArgument2;
                break;
            case '-':
                finalResultArabic = finalArgument1 - finalArgument2;
                break;
            case '*':
                finalResultArabic = finalArgument1 * finalArgument2;
                break;
            case '/':
                finalResultArabic = finalArgument1 / finalArgument2;
                break;
        }

        //Получение результата

        if (arabic) {
            input= String.valueOf(finalResultArabic);
        }
        else {
            if (finalResultArabic < 1){
                arithmeticPrimerCorrect = false;

                if (arithmeticPrimerCorrect == false) {
                    try {
                        throw new MyExeption("Некорректные данные");
                    } catch (MyExeption e) {
                        System.err.println(e.getMessage());
                        System.out.println("В римской системе нет отрицательных чисел");
                        System.exit(0);
                    }
                }
            }
            else {
                String[] romeAnswer = new String[]{" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                        "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                        "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                        "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                        "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                        "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                        "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                        "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                        "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                        "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C" };
                // Можно было, конечно, реализовать систему перевода римских цифр в арабские,
                // но в конкретно в этой задаче код массива будет короче


                input = (romeAnswer[finalResultArabic]);


            }
        }

        return input;
    }
}




















