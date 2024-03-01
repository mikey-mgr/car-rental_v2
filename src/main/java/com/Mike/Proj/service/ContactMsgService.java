package com.Mike.Proj.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mike.Proj.exceptions.CustomException;
import com.Mike.Proj.model.ContactMessages;
import com.Mike.Proj.repository.ContactMsgRepo;

@Service
public class ContactMsgService {

    @Autowired
    ContactMsgRepo contactMsgRepo;

    //retrieve a list of all messages
    public List<ContactMessages> getMessages(){
        List<ContactMessages> msgs = contactMsgRepo.findAll();

        if(msgs.isEmpty()){
            throw new CustomException("There are no contact messages");
        } else return msgs;
    }

    //saves the contact us message
    public void saveMessage(ContactMessages msg){
        if(Objects.isNull(msg)){
            throw new CustomException("The submitted message contains no data");
        } else contactMsgRepo.save(msg);
    }

    //find a contact message by name
    public List<ContactMessages> findMessage(String name){
        List<ContactMessages> msgs = contactMsgRepo.findByNameContaining(name);

        if(msgs.isEmpty()){
            throw new CustomException("There is no message with name: " + name);
        } else return msgs;
    }
}
