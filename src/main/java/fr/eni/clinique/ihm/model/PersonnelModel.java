package fr.eni.clinique.ihm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bo.Personnel;


public class PersonnelModel extends Observable {


    private List<Personnel> articles = new ArrayList<>();
    private int currentIndex;
    public boolean dataChanged;

    public void loadPersonnel(List<Personnel> personnels) {
    	
    	for (Personnel personnel : personnels){
    		
    	}
        this.articles.clear();
        this.articles.addAll(articles);
        firstOrNew();
    }

    
    public void addArticle(Personnel article) {
        articles.add(article);
        last();
    }

    public void changeCurrentArticle(Personnel article) {

        if (!articles.isEmpty()) {
            articles.set(currentIndex, article);
            setDataChanged();
            changeState();
        }
    }

    public void removeCurrentArticle() {

        if (!articles.isEmpty()) {
            
            // Data change if we removing an article with an id.
            
            
            articles.remove(currentIndex);

            if (currentIndex > articles.size() - 1) {
                currentIndex = 0;
            }
            
            changeState();
        }
    }

    public void firstOrNew() {

        currentIndex = 0;
        changeState();
    }

    public void previousArticle() {
        if (!articles.isEmpty()) {
            if (currentIndex > 0) {
                currentIndex--;
            } else {
                currentIndex = articles.size() - 1;
            }
        }
        changeState();
    }

    public void nextArticle() {
        if (!articles.isEmpty()) {
            if (currentIndex < articles.size() - 1) {
                currentIndex++;
            } else {
                currentIndex = 0;
            }
        }
        changeState();
    }

    private void last() {

        if (!articles.isEmpty()) {
            currentIndex = articles.size() - 1;
        }
        changeState();
    }

    private void changeState() {

    	Personnel article = null;
        if (!articles.isEmpty()) {
            article = articles.get(currentIndex);
        }
        
    }

    /**
     * @return the dataChanged
     */
    public boolean hasDataChanged() {
        return dataChanged;
    }
    
    protected void setDataChanged() {
        dataChanged = true;
    }
    
    protected void clearDataChanged() {
        dataChanged = false;
    }

}
