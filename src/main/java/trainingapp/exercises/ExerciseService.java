package trainingapp.exercises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainingapp.account.Account;
import trainingapp.observator.AccountObserver;
import trainingapp.account.AccountRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository, AccountRepository accountRepository) {
        this.exerciseRepository = exerciseRepository;
        this.accountRepository = accountRepository;
    }

    List<String> addExercise(Exercise newExercise) {
        exerciseRepository.save(newExercise);
        List<Account> accounts = accountRepository.findAccountsByFavouriteBodyPart(newExercise.getBodyPartType());
        List<AccountObserver> accountObserver = accounts
                .stream()
                .map(this::mapAccountToAccountObserver)
                .collect(Collectors.toList());
        return accountObserver.stream().map(it -> it.notify(newExercise)).collect(Collectors.toList());
    }

    private AccountObserver mapAccountToAccountObserver(Account account) {
        return new AccountObserver(account);
    }

    List<Exercise> getExercisesForBodyPart(BodyPartType bodyPartType) {
        return exerciseRepository.findByBodyPartType(bodyPartType);
    }
}
