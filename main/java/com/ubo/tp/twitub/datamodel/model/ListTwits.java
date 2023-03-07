package main.java.com.ubo.tp.twitub.datamodel.model;

import main.java.com.ubo.tp.twitub.datamodel.Twit;

import java.util.Set;

public class ListTwits {
    Set<Twit> twitSet;

    public void setTwitSet(Set<Twit> twitSet) {
        System.out.println(twitSet.size());
        this.twitSet = twitSet;
    }

    public Set<Twit> getTwitSet() {
        return twitSet;
    }
}
