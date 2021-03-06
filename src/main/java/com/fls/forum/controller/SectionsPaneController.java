package com.fls.forum.controller;

import com.fls.forum.model.ServerController;
import com.fls.forum.model.localModel.Section;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SectionsPaneController implements Initializable {

    @FXML
    private ListView<Section> sectionsListView = new ListView<>();
    private ObservableList<Section> nameList;
    private ForumController forumController;
    private ServerController serverController = new ServerController();

    public SectionsPaneController() {

    }

    private void setSectionsListView() {
//        List<Section> sections = dataGenerator.getSections();
        List<Section> sections = serverController.getAllSections();
        nameList = FXCollections.observableArrayList(sections);
        sectionsListView.setItems(nameList);
        sectionsListView.setOnMouseClicked(mouseEvent -> {
            try {
                if (mouseEvent.getClickCount() == 2)
                    changeScreenSectionSelected();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void changeScreenSectionSelected() throws IOException {
        Section section = sectionsListView.getSelectionModel().getSelectedItem();
        if (section != null)
            forumController.loadTopicsPane(sectionsListView.getSelectionModel().getSelectedItem());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setSectionsListView();
    }

    public void setForumController(ForumController forumController) {
        this.forumController = forumController;
    }
}


