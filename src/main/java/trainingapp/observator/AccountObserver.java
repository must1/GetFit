package trainingapp.observator;

import trainingapp.account.Account;
import trainingapp.exercises.Exercise;

public class AccountObserver implements Observable {

    private Account account;

    public AccountObserver(Account account) {
        this.account = account;
    }

    @Override
    public String notify(Exercise exercise) {
        return "Hey " + account.getName() + " we've just added new excercise " + exercise.getName() +
                " to your favourite body part!";
    }
}
