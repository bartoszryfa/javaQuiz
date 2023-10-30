package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get("src/main/resources/quiz.txt");

        // Read quiz questions and answers from a file

        List<String> quiz = Files.readAllLines(path);

        int correctAnswerPoints = 0;
        for (String quizList : quiz) {
            String[] questionAndAnswer = quizList.split(";");
            System.out.println(questionAndAnswer[0]);
            System.out.println(("1. " + questionAndAnswer[1]));
            System.out.println(("2. " + questionAndAnswer[2]));
            System.out.println(("3. " + questionAndAnswer[3]));
            System.out.println(("4. " + questionAndAnswer[4]));
            System.out.println();

            System.out.println("Wybierz prawidłową odpowiedź :");

            boolean validInput = true;
            int userAnswer = 0;

        // validate input and check user answer

            while (validInput) {
                try {
                    userAnswer = Integer.parseInt(reader.readLine());
                    if (userAnswer >= 1 && userAnswer <= 4) {
                        validInput = false;
                    } else {
                        System.out.println("Liczba musi być w zakresie od 1 do 3. Podaj prawidłową liczbę raz jeszcze: ");
                    }
                } catch (NumberFormatException | IOException e) {
                    System.out.println("To nie jest poprawna liczba. Podaj prawidłową liczbę: ");
                    userAnswer = Integer.parseInt(reader.readLine());
                }
        }
                if (userAnswer == Integer.parseInt(questionAndAnswer[5])) {
                    System.out.println("Prawidłowa odpowiedź!!");
                    correctAnswerPoints++;
                } else {
                    int correctAnswer = Integer.parseInt(questionAndAnswer[5]);
                    System.out.println("Błędna odpowiedź!!");
                    System.out.println("Poprawna odpowiedź to: " + questionAndAnswer[5] + " - " + questionAndAnswer[correctAnswer]);
                }
                System.out.println();

            }

        // Summary of points and print result

        System.out.println("Liczba prawidłowych odpowiedzi to: " + correctAnswerPoints);

        if(correctAnswerPoints >= 21) {
            System.out.println("Jesteś mistrzem JAVA!");
        } else if(correctAnswerPoints < 21 && correctAnswerPoints >= 17 ) {
            System.out.println("Jesteś już naprawdę dobry!");
        } else if(correctAnswerPoints < 17 && correctAnswerPoints >= 14 ) {
            System.out.println("Dobra robota!");
        } else if ( correctAnswerPoints < 14 && correctAnswerPoints >= 11) {
            System.out.println("Musisz się jeszcze trochę podszkolić i będziesz wymiatał!");
        } else if(correctAnswerPoints < 11) {
            System.out.println("Pora wziąć się do roboty!");
        }
    }
}