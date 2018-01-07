package com.fls.forum.controller;

import com.fls.forum.model.Section;
import com.fls.forum.model.Topic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TopicsPaneController implements Initializable{

    private Section currentSection;
    @FXML
    private ListView<Topic> topicsListView = new ListView<>();
    private ObservableList<Topic> nameList;
    private List<Topic> topics = new ArrayList<>();

    @FXML
    private Label sectionNameLabel;

    @FXML
    private Pagination topicsListPagination;

    public TopicsPaneController(Section section){
        this.currentSection = section;
    }

    private int topicsPerPage(){
        return 10;
    }

    private ListView<Topic> createPage(int pageIndex) {
        int start = pageIndex * topicsPerPage();
        topicsListView.setItems(FXCollections.observableArrayList(topics.subList(start,start+topicsPerPage() > topics.size() ? topics.size() : (start + topicsPerPage()) )));
        return topicsListView;
    }


    private void setTopicsListView(){
        if(currentSection != null){
            sectionNameLabel.setText(currentSection.getName());
            topics = new dataGenerator().getTopics(currentSection.getId());
        }

        topicsListPagination.setPageCount(((int)(Math.ceil((topics.size()-1) / 10)+1)));

        topicsListPagination.setPageFactory(this::createPage);

        nameList = FXCollections.observableArrayList(topics);
        //topicsListView.setItems(nameList);
        topicsListView.setOnMouseClicked(mouseEvent -> System.out.println(topicsListView.getSelectionModel().getSelectedItem()));
    }

    public void changeScreenBackButtonClicked(javafx.event.ActionEvent event) throws IOException {
        Parent sectionsParent = FXMLLoader.load(getClass().getResource("../pane_sections.fxml"));
        Scene scene = new Scene(sectionsParent);

        Stage window = (Stage)((((Node)event.getSource())).getScene().getWindow());
        window.setScene(scene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTopicsListView();
    }
}