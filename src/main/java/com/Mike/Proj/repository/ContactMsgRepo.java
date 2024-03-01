package com.Mike.Proj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Mike.Proj.model.ContactMessages;

@Repository
public interface ContactMsgRepo extends JpaRepository <ContactMessages, Integer>{

    @Query(value = "SELECT * FROM messages WHERE messages.name like %?1%", nativeQuery = true)
    List<ContactMessages> findByNameContaining(String name);
}
