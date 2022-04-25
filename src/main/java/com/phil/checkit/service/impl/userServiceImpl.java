package com.phil.checkit.service.impl;

import com.phil.checkit.domain.User;
import com.phil.checkit.repository.UserRepo;
import com.phil.checkit.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor @Slf4j
public class userServiceImpl implements UserService {
    private final UserRepo userRepo;
    @Override
    public String saveUser(User user) {
        //data validation & persistence
        String validateMessage = validate(user);
        if(validateMessage != ""){
            userRepo.save(user);
        }
        else{
            return validateMessage;
        }
        return "user saved successfully";
    }

    @Override
    public String updateUser(User user) {
        //data validation & persistence
        String validateMessage = validate(user);
        if(validateMessage != ""){
            userRepo.save(user);
        }
        else{
            return validateMessage;
        }
        return "user updated successfully";
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public String validate(User user){
        if(user.getUsername().isBlank()){
            return "invalid username, username can't be blank";
        } else if(userRepo.findByUsernameOrEmail(user.getUsername()) != null){
            return "username has been taken";
        }

        if(user.getEmail().isBlank()){
            return "invalid username, username can't be blank";
        }
        else
        {
            if(validateEmail(user.getEmail())){
                return "invalid email";
            }
            if(userRepo.findByUsernameOrEmail(user.getUsername()) != null){
                return "email is owned by another account";
            }

        }

        if(!isValidPassword(user.getPassword())){
            return "invalid password;it should contain at least an uppercase, lowercase, special character and number" +
                    "and the length should be between 8 and 20";
        }
        return "";
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static boolean
    isValidPassword(String password)
    {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);

        if (password == null) {
            return false;
        }

        Matcher m = p.matcher(password);
        return m.matches();
    }

}



