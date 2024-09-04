package pckg_23_24;

import java.util.concurrent.ThreadLocalRandom;

public class GuessGame {

    static String[] countries = { "Albania", "Australia", "Argentina", "Bahamas", "Belgium", "BiH", "Brazil",
            "Bulgaria", "Chile", "Croatia", "Canada", "Colombia", "Cuba", "Cyprus", "Denmark", "Dominican Republic",
            "Egypt", "Ecuador", "Estonia", "Finland", "France", "Germany", "Ghana", "Greece", "Hungary", "India",
            "Iran", "Jordan", "Kenya", "Latvia", "Luxembourg", "Madagascar", "Malta", "Mexico", "Montenegro",
            "Morocco", "Nepal", "Netherlands", "New Zealand", "North Korea", "Norway", "Panama", "Pakistan",
            "Paraguay", "Qatar", "Romania", "San Marino", "Samoa", "Singapore", "Sudan", "Tanzania", "Uganda",
            "Venezuela", "Vietnam", "Slovenia", "Poland", "Slovakia", "United States of America", "United Kingdom",
            "Ukraine", "Uganda", "Yemen", "Laos", "Russia"
    };

    public GuessGame() {
    }

    public static String pickRandomCountry(){

        int indMax = countries.length - 1;
        int indRand = ThreadLocalRandom.current().nextInt(indMax);
        return countries[indRand];
    }

    public static void printGuessFields(String country){

        int ind = country.length() - 1;  //last index of a string
        StringBuilder maskedCountry = new StringBuilder();
        maskedCountry.append(country);
        if (country.length() <= 3){
            for (int i = 1; i < ind ; i++) {  //first and last letter are not masked (index: 0 and ind)
                maskedCountry.setCharAt(i, '_');
            }
        }else {
            int rand = ThreadLocalRandom.current().nextInt(1,ind);
            for (int i = 1; i < ind ; i++) {
                if (i == rand || maskedCountry.charAt(i) == ' ' ) {  //not masking one letter and spaces
                    continue;
                }
                maskedCountry.setCharAt(i, '_');
            }
        }
        System.out.println(maskedCountry);
    }

    public static boolean checkGuess(String userGuess, String country){
        boolean guessed;
        if (userGuess.equals(country)){
            guessed = true;
        } else {
            guessed = false;
        }

        return guessed;
    }



}

