package com.fls.forum;

// <<<<<<< forum
import com.fls.forum.controller.ForumController;
import com.fls.forum.model.localModel.Post;
import com.fls.forum.model.localModel.Section;
import com.fls.forum.model.localModel.Topic;
import com.fls.manager.Manager;
import javafx.scene.layout.Pane;

import java.util.List;
// =======
// >>>>>>> develop
// import com.fls.manager.Manager;
// import javafx.scene.layout.Pane;
// import javafx.stage.Stage;

// import java.util.List;

/**
 * Created by Marcin on 2017-12-12.
 */
// <<<<<<< forum
public class Forum implements com.fls.forum.model.Forum {

    private ForumController forumController = new ForumController();

    @Override
    public int countUserPluses(long userId) {
        return 0;
    }

    @Override
    public int countUserPosts(long userId) {
        return 0;
    }

    @Override
    public int countTopicsCreatedByUser(long userId) {
        return 0;
    }

    @Override
    public Post getPostById(long postId) {
        return null;
    }

    @Override
    public Topic getTopicById(long topicId) {
        return null;
    }

    @Override
    public Section getCategoryById(long categoryId) {
        return null;
    }

    @Override
    public List<Post> getUserPosts(long userId) {
        return null;
    }

    @Override
    public Topic getLastUserActivityById(long userId) {
        return null;
    }

    public Pane load() {
        return forumController.loadSectionsPane();
    }

    public void setManager(Manager manager){
        forumController.setManager(manager);
    }
// =======
// public class Forum {
//     public Forum(Manager manager) {

//     }

//     public Pane load() {return null;}
// >>>>>>> develop
}