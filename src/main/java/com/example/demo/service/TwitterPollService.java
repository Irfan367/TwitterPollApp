package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.dao.TwitterPollDao;
import com.example.demo.model.Person;
import com.example.demo.model.TwitterPoll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TwitterPollService {
    private final TwitterPollDao pollDao;

    @Autowired
    public TwitterPollService(@Qualifier("twitterFakeDao") TwitterPollDao pollDao){

        this.pollDao = pollDao;
    }

    public int addPoll(TwitterPoll poll){
        return pollDao.insertPoll(poll);
    }
    public List<TwitterPoll> getAllPolls(){
        return pollDao.selectAllPolls();
    }
    public Optional<TwitterPoll> getPollById(UUID id){
        return pollDao.selectPollById(id);
    }
    public int deletePoll(UUID id){
        return pollDao.deletePollById(id);
    }
    public int updatePoll(UUID id, TwitterPoll newPoll){
        return pollDao.updatePollById(id, newPoll);
    }
}
