package com.example.demo.dao;

import com.example.demo.model.Person;
import com.example.demo.model.TwitterPoll;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("twitterFakeDao")
public class TwitterDataAccess implements TwitterPollDao{
    private static List<TwitterPoll> twitterdb= new ArrayList<>();

    @Override
    public int insertPoll(UUID id, TwitterPoll poll) {
        twitterdb.add(new TwitterPoll(id, poll.getQuestion(), poll.getResult(), poll.getOptions()));
        return 0;
    }

    @Override
    public List<TwitterPoll> selectAllPolls() {
        return twitterdb;
    }

    @Override
    public Optional<TwitterPoll> selectPollById(UUID id) {
        return twitterdb.stream().filter(poll -> poll.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePollById(UUID id) {
        Optional<TwitterPoll> pollMaybe = selectPollById(id);
        if (pollMaybe.isPresent()) {
            twitterdb.remove(pollMaybe.get());
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updatePollById(UUID id, TwitterPoll update) {
        return selectPollById(id)
                .map(person -> {
                    int indexOfPollToUpdate = twitterdb.indexOf(person);
                    if (indexOfPollToUpdate >= 0){
                        twitterdb.set(indexOfPollToUpdate, new TwitterPoll(id, update.getQuestion(), update.getResult(),
                                update.getOptions()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
