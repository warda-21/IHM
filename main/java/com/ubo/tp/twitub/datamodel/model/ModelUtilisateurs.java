package main.java.com.ubo.tp.twitub.datamodel.model;

import main.java.com.ubo.tp.twitub.component.Utilisateurs;
import main.java.com.ubo.tp.twitub.controller.HomeController;
import main.java.com.ubo.tp.twitub.core.Twitub;
import main.java.com.ubo.tp.twitub.datamodel.User;

import javax.swing.*;
import java.util.Set;

public class ModelUtilisateurs implements Observer{

    Twitub twitub;
    Utilisateurs utilisateurs;
    HomeController homeController;
    Session session;

    public ModelUtilisateurs(Session session, HomeController homeController){
        //this.twitub =twitub;
        this.session = session;
        this.homeController = homeController;
        this.utilisateurs = new Utilisateurs(homeController.getAllUsers(), session.getUser(), this.homeController);
    }



    public JPanel showUtilisateur(){

        repaint();
        return utilisateurs;

    }


    /**
     * rafrechi la page avec les nouvelles données.
     */
    public void repaint() {
        if(session.getUser()!=null){
            utilisateurs.removeAll();
            this.utilisateurs.add(new Utilisateurs(homeController.getAllUsers(), session.getUser(),this.homeController));
            this.utilisateurs.revalidate();
            this.utilisateurs.repaint();
        }

    }

    /**
     * Mise à jour de la vue
     */
    @Override
    public void update() {
        this.repaint();
    }
}
