package trainingapp.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    Account deleteAccount(int id) {
        Account bookToDelete = accountRepository.findById(id).orElse(null);
        accountRepository.deleteById(id);
        return bookToDelete;
    }

    List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        accountRepository.findAll().forEach(accounts::add);
        return accounts;
    }
}
