package com.test.springboot.rest.api.topicController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

   private List<Topic> topics = new ArrayList<>(Arrays.asList(
                new Topic("1","spring boot", "testing"),
                new Topic("2","spring boot", "testing"),
                new Topic("3","spring boot", "testing")
    ));

   public List<Topic> getAllTopics(){
//       return topics;
       List<Topic> topics = new ArrayList<>();
       topicRepository.findAll()
               .forEach(topics::add);
       return topics;
   }

   public Topic getTopic(String id){
//       return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
       return topicRepository.findOne(id);
   }

    public void addTopic(Topic topic) {
//        topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
//        for(int i=0; i<topics.size(); i++){
//            Course t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i, topic);
//                return;
//            }
//        }
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
//        for(int i=0; i<topics.size(); i++){
//            Course t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.remove(id);
//                return;
//            }
//        }
//        topics.removeIf(t -> t.getId().equals(id));
        topicRepository.delete(id);
    }
}
