package com.fls.forum.controller;

import com.fls.forum.ForumApp;
import com.fls.forum.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

import java.util.Date;

public class PostsController {

    private Long userId;
    private Topic topic;
    private PostView postView;



    private ObservableList<Post> posts = FXCollections.observableArrayList();


    @FXML
    public Button send;

    @FXML
    private Label errorLabel;

    @FXML
    private Pane mainPane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TextArea answerText;

    @FXML
    private Label titleLabel;

    @FXML
    private VBox vBox;

    private ApplicationController applicationController;

    private TimedLabel errorTimedLabel;


    @FXML
    private void handleSendAction() {
        if(answerText.getText().length() > 0) {
            addPost(new AnswerPost(topic, 1, new Date(), userId, new Content(1, answerText.getText()), false));
            answerText.setText("");
        }
        else{
            errorTimedLabel.setText("You cannot send empty message", 3);
        }
    }


    @FXML
    private void initialize() {
        vBox.prefWidthProperty().bind(scrollPane.widthProperty());
        vBox.prefHeightProperty().bind(scrollPane.heightProperty());

        scrollPane.prefWidthProperty().bind(mainPane.widthProperty().multiply(0.9));
        scrollPane.prefHeightProperty().bind(mainPane.heightProperty().multiply(0.7));

        scrollPane.setFitToWidth(true);

        this.errorTimedLabel = new TimedLabel(errorLabel);

    }

    void setApplicationController(ApplicationController applicationController){
        this.applicationController = applicationController;
    }


    private void addPost(Post post){

        posts.add(post);

        postView.showPost(post);
    }

    void setData(Long userId, Topic topic, ObservableList<Post> posts) {
        this.userId = userId;
        this.topic = topic;
        postView = new PostView(vBox, applicationController);
        for(Post post: posts) {
            addPost(post);
        }

        titleLabel.setText(((QuestionPost)posts.get(0)).getTitle());
    }

    public ObservableList<Post> getPosts() {
        return posts;
    }

    public VBox getVbox(){
        return postView.getvBox();
    }

    public void handleGoBackAction(ActionEvent actionEvent) {
        applicationController.loadTopicsPane(topic.getSection());
    }
}