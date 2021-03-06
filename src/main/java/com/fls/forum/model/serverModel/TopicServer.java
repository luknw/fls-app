package com.fls.forum.model.serverModel;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TopicServer {
    private Integer id;
    private Integer categoryId;
    private Integer postCount;

    public TopicServer(Integer id, Integer categoryId, Integer postCount) {
        this.id = id;
        this.categoryId = categoryId;
        this.postCount = postCount;
    }

    public TopicServer() {
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostCount() {
        return postCount;
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }

    public void incresePostCount() {
        postCount++;
    }

    public void decreasePostCount() {
        postCount--;
    }

}
