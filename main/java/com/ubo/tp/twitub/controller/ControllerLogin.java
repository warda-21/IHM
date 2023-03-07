package main.java.com.ubo.tp.twitub.controller;

import main.java.com.ubo.tp.twitub.core.Twitub;
import main.java.com.ubo.tp.twitub.datamodel.IDatabase;
import main.java.com.ubo.tp.twitub.datamodel.User;
import main.java.com.ubo.tp.twitub.datamodel.model.Session;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class ControllerLogin {
    IDatabase database;
    IController controller;
    Session session;

    public ControllerLogin(IDatabase database, IController controller, Session session) {
        this.database = database;
        this.controller = controller;
        this.session = session;
    }

    public void connexion(String cpt, String mdp) {
        boolean connected=false;
        Set<User> allUser = database.getUsers();
        for (User user : allUser) {
            //System.out.println(mdp);
            if (user.getUserTag().equals(cpt) && user.getUserPassword().equals(mdp)) {
                //System.out.println(mdp);
                session.setUser(user);
                controller.showUser();
                connected=true;
            }
        }

        if(!connected) {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Vérifiez votre Tag ou votre mot de passe ");

        }
    }
}
