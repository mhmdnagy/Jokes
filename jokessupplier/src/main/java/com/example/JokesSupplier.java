package com.example;

import java.util.ArrayList;
import java.util.List;

public class JokesSupplier {

    //Source: http://www.buzzfeed.com/jessicamisener/21-jokes-so-stupid-theyre-actually-funny#.kjLEkZJ9Dg
    private String[] questions = {"My sister bet me a hundred dollars I couldn’t build a car out of spaghetti.",
            "How many South Americans does it take to change a lightbulb?",
            "What time does Sean Connery get to Wimbledon?",
            "I went to the zoo the other day. It was empty, except for a single dog…",
            "What kind of bagel can fly?",
            "Where do animals go when their tails fall off?",
            "Why can’t you hear a pterodactyl going to the bathroom?",
            "How does a train eat?",
            "Did you hear about the constipated mathematician?",
            "What’s Forrest Gump’s password?",
            "What do you call a cow with no legs?",
            "How is imitation like a plateau?",
            "So two snare drums and a cymbal fall off a cliff…",
            "A magician was driving down the street…",
            "What’s the best thing about living in Switzerland?",
            "What does Batman get in his drinks?",
            "What sport do you play with a wombat?",
            "What does a nosy pepper do?",
            "What did the buffalo say to his son when he left for college?",
            "Tried to take a photograph of some fog."};

    private String[] answers = {"You should've of seen the look on her face as I drove pasta.",
            "A Brazilian.",
            "Tennish.",
            "It was a Shih Tzu.",
            "A plain bagel.",
            "The retail store.",
            "Because the \"P\" is silent.",
            "It goes Chew Chew.",
            "He worked his problem out with a pencil\nIt was a No. 2 pencil.",
            "1Forrest1",
            "Ground beef.",
            "They're both the highest form of flattery.",
            "BA DUM tsssssh.",
            "Then he turned into a driveway.",
            "I don't know but the flag is a big plus",
            "Jus Ice.",
            "Wom.",
            "Gets Jalapeno business.",
            "Bison.",
            "Mist."};


    public List<Joke> getJokes() {
        List<Joke> jokes = new ArrayList<>();
        for (int i = 0; i < this.questions.length; i++) {
            Joke joke = new Joke();
            joke.setJoke(questions[i]);
            joke.setClue(answers[i]);
            jokes.add(joke);
        }
        return jokes;
    }
}
