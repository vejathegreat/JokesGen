package com.velaphi.jokeslib;

public class JokesLib {

    private static String[] jokes = {
            "What do you get when you wake up on a workday and realize you ran out of coffee?" +"\n" + "A depresso.",
            "I used to breed rabbits. Then I realized they can handle it themselves.",
            "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away",
            "Why are eggs not very much into jokes? Because they could crack up.",
            "I went to see the doctor about my short-term memory problems. The first thing the bastard did was made me pay in advance."
    };

    /**
     * This class should not be instantiated
     */
    private JokesLib(){}

    /**
     * Method that generates a random integer number for a given range
     * @param min Minimum number in range
     * @param max Maximum number in range
     * @return integer number between min and max range
     */
    private static int getRandomNumberInRange(int min, int max){
        return (int)(Math.random() * (max-min) + min);
    }

    /**
     * This method fetches randomly one of the available jokes
     * @return String containing a random joke
     */
    public static String getRandomJoke(){
        return jokes[getRandomNumberInRange(0, jokes.length-1)];
    }
}
