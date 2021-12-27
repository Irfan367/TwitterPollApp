package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.model.TwitterPoll;
import com.example.demo.service.PersonService;
import com.example.demo.service.TwitterPollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/poll")
@RestController
public class TwitterPollController {
    private final TwitterPollService pollService;

    @Autowired
    public TwitterPollController(TwitterPollService pollService) {

        this.pollService = pollService;
    }
    @PostMapping
    public void addPoll(@Validated @NonNull @RequestBody TwitterPoll poll){

        pollService.addPoll(poll);
    }
    @GetMapping()
    public List<TwitterPoll> getAllPolls(){
        //System.out.println("Test1");
        return pollService.getAllPolls();
    }
    @GetMapping(path = "{id}")
    public TwitterPoll getPollById(@PathVariable("id") UUID id){

        return pollService.getPollById(id).orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deletePollById(@PathVariable("id") UUID id){
        pollService.deletePoll(id);
    }
    @PutMapping(path = "{id}")
    public void updatePollById(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody TwitterPoll poll){
        pollService.updatePoll(id, poll);
    }

}
