package com.example.demo.dao;

import com.example.demo.model.Person;
import com.example.demo.model.TwitterPoll;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TwitterPollDao {
    int insertPoll(UUID id, TwitterPoll poll);

    default  int insertPoll(TwitterPoll poll){
        UUID id = UUID.randomUUID();
        return insertPoll(id, poll);
    }
    List<TwitterPoll> selectAllPolls();

    Optional<TwitterPoll> selectPollById(UUID id);
    int deletePollById(UUID id);
    int updatePollById(UUID id, TwitterPoll poll);
}
