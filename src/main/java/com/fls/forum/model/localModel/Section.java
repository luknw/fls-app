package com.fls.forum.model.localModel;


import com.fls.forum.model.ServerController;

import java.util.List;

public class Section {
    private long id;
    private String name;
    private String description;
    private List<Topic> topics;
    private List<Integer> topicIds;
    private Long topicCount;

    public Section() {

    }


    public Section(long id, String name, String description, List<Integer> topicIds, Long topicCount) {
        this.id = id;
        this.name = name;
        this.description = description;
//        topics = dataGenerator.getTopics(id);
        this.topicIds = topicIds;
        this.topicCount = topicCount;


//        for(Topic topic: topics)
//            topic.setSection(this);

    }

    public Section(long id, String name, String description, Long topicCount) {
        this.id = id;
        this.name = name;
        this.description = description;
//        topics = dataGenerator.getTopics(id);
        this.topicCount = topicCount;


//        for(Topic topic: topics)
//            topic.setSection(this);

    }

    public void loadTopics(ServerController serverController) {
        topics = serverController.getAllTopics(this);

        for (Topic topic : topics)
            topic.setSection(this);

    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public void addTopic(Topic topic) {
        this.topics.add(topic);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%-25s", name) + description;
    }
}