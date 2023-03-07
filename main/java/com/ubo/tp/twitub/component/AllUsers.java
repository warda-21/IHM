package main.java.com.ubo.tp.twitub.component;

import main.java.com.ubo.tp.twitub.controller.HomeController;
import main.java.com.ubo.tp.twitub.datamodel.Database;
import main.java.com.ubo.tp.twitub.datamodel.IDatabase;
import main.java.com.ubo.tp.twitub.datamodel.IDatabaseObserver;
import main.java.com.ubo.tp.twitub.datamodel.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class AllUsers extends JPanel {
    JPanel panel;
    HomeController homeController;

    AllUsers(Set<User> allUsers, User user, HomeController controller) {

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.lightGray);
        homeController =controller;
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("size ........" + allUsers.size());
        int compteur = 1;
        for (User userTwitUb : allUsers) {
            JPanel panel1 = new JPanel();
            panel1.setLayout(new GridBagLayout());
            panel1.setBorder(
                    BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
            );
            panel1.setBackground(Color.white);

            JLabel tagName = new JLabel(userTwitUb.getUserTag());
            tagName.setForeground(Color.BLUE);
            tagName.setFont(new Font(tagName.getName(), tagName.getFont().getStyle(), 18));

            JLabel nbFollowers = new JLabel("Nombre de followers " + userTwitUb.getFollows().size());
            nbFollowers.setForeground(Color.BLACK);


            String urlUser = "main/resources/images/profil.jpg";
            ImageIcon icon = new ImageIcon(urlUser);
            JLabel image = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));

            JButton button = new JButton("S'abonner");
            button.setBackground(Color.BLUE);
            button.setForeground(Color.white);


            JButton button1 = new JButton("Se desabonner");
            button1.setBackground(Color.lightGray);


            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                  AllUsers.this.homeController.addFollower(user.getUserTag(), userTwitUb);
                   // userTwitUb.addFollowing(user.getUserTag());
                    button.setEnabled(false);
                    button1.setEnabled(true);
                }

                });

            button1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    AllUsers.this.homeController.removeFollower(user.getUserTag(), userTwitUb);
                   // userTwitUb.removeFollowing(user.getUserTag());
                    button1.setEnabled(false);
                    button.setEnabled(true);
                }

            });








            JButton button2 = new JButton("Voir profil");
            button2.setBackground(Color.BLUE);
            button2.setForeground(Color.white);

            panel1.add(image, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.WEST,
                    GridBagConstraints.NONE, new Insets(15, 15, 15, 0), 0, 0));
            panel1.add(tagName, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.WEST,
                    GridBagConstraints.NONE, new Insets(0, 0, 15, 0), 0, 0));
            panel1.add(nbFollowers, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.WEST,
                    GridBagConstraints.NONE, new Insets(50, 0, 15, 0), 0, 0));
            panel1.add(button, new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.WEST,
                    GridBagConstraints.NONE, new Insets(0, 0, 15, 0), 45, 0));
            panel1.add(button1, new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.WEST,
                    GridBagConstraints.NONE, new Insets(80, 0, 15, 0), 0, 0));

            panel1.add(button2, new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.EAST,
                    GridBagConstraints.NONE, new Insets(0, 0, 0, 15), 0, 50));

            panel.add(panel1, new GridBagConstraints(0, compteur, 1, 1, 1, 1, GridBagConstraints.CENTER,
                    GridBagConstraints.BOTH, new Insets(2, 0, 1, 0), (int) screenSize.getWidth() - 700, 0));
            compteur++;
            this.add(panel);
        }
    }

}