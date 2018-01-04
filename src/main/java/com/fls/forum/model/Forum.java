package com.fls.forum.model;

import javafx.scene.layout.Pane;

import java.util.List;

/**
 * Możliwość stworzenia wielu instancji forum przez managera
 */
public interface Forum {

    int countUserPluses(long userId);

    int countUserPosts(long userId);

    int countTopicsCreatedByUser(long userId);

    Post getPostById(long postId);

    Topic getTopicById(long topicId);

    Section getCategoryById(long categoryId);

    List<Post> getUserPosts(long userId);

    Topic getLastUserActivityById(long userId);

    Pane load();
}
