package com.solarvalley.service.impl;

import com.solarvalley.dto.UserDTO;
import com.solarvalley.entities.Mail;
import com.solarvalley.entities.User;
import com.solarvalley.exceptions.UserAlreadyExistException;
import com.solarvalley.exceptions.UserNotFoundException;
import com.solarvalley.repository.UserRepository;
import com.solarvalley.service.EmailService;
import com.solarvalley.service.UserService;
import com.solarvalley.util.EmailUtil;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Value("mail.fromMail")
    private String fromMail;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmailService emailService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return user;
        } else {
            throw new UserNotFoundException("User not found with email: "+ email);
        }
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        if (user != null) {
            return user;
        } else {
            throw new UserNotFoundException("User not found with phone number: "+ phoneNumber);
        }
    }

    @Override
    public User createUser(UserDTO userDTO) throws UserAlreadyExistException {
        isExistingRecord(userDTO);
        User user = modelMapper.map(userDTO, User.class);
        User savedUser = userRepository.save(user);
        LOGGER.info("User created successfully with name: "+ savedUser.getFullName());
        sendEmail(savedUser);
        return user;
    }

    @Override
    public User updateUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return userRepository.save(user);
    }

    @Override
    public void deleteUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            userRepository.delete(user);
        } else {
            throw new UserNotFoundException("User not found for delete with email: "+ email);
        }
    }

    private void isExistingRecord(UserDTO userDTO) throws UserAlreadyExistException {
        //email check
        User userByEmail = userRepository.findByEmail(userDTO.getEmail());
        if (userByEmail != null){
            LOGGER.error("User already exist with email: {}", userDTO.getEmail());
            throw new UserAlreadyExistException("We have already got your query earlier, our team will contact you soon!");
        }
        //phone number check
        User userByPhoneNumber = userRepository.findByPhoneNumber(userDTO.getPhoneNumber());
        if (userByPhoneNumber != null){
            LOGGER.error("User already exist with phone number: {}", userDTO.getPhoneNumber());
            throw new UserAlreadyExistException("We have already got your query earlier, our team will contact you soon!");
        }
    }

    private void sendEmail(User user){
        try {
            Mail mail = new Mail("info@solarvalley.co.in", user.getEmail(), getMailSubject(), EmailUtil.getMailBody(user));
            emailService.sendEmail(mail, javaMailSender);
        } catch (Exception e) {
            LOGGER.error("Error occurred while sending mail to the user with username: "+ user.getFullName(), e);
        }
    }


    private String getMailSubject(){
        return "Thank You for Contacting Solar Valley!";
    }



}
