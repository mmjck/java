package org.z.repositories.profile.jpa.model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.Set;
import java.util.List;

import org.z.repositories.tweet.jpa.model.TweetJpaModel;

@Entity(name = "Profile")
@Table(name = "tb_profiles")
public class ProfileJpaModel {
    @Id
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @ManyToMany(
        targetEntity = ProfileJpaModel.class, 
        cascade = CascadeType.REMOVE, 
        fetch = FetchType.EAGER
    )
    @JoinTable(
        name = "profile_follow", 
        joinColumns = @JoinColumn(name = "follower_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "followed_id", referencedColumnName = "id"), uniqueConstraints = {
            @UniqueConstraint(columnNames = { "follower_id", "followed_id" })
    })
    private Set<ProfileJpaModel> follows;

    

    @OneToMany(
        targetEntity = TweetJpaModel.class,
        cascade = CascadeType.REMOVE, 
        fetch = FetchType.EAGER,
        mappedBy = "id"
    )
    private List<TweetJpaModel> tweets;

    public ProfileJpaModel() {

    }

    public ProfileJpaModel(String id, String name, String email, String login, Set<ProfileJpaModel> follows,
            List<TweetJpaModel> tweets) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.follows = follows;
        this.tweets = tweets;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Set<ProfileJpaModel> getFollows() {
        return follows;
    }

    public void setFollows(Set<ProfileJpaModel> follows) {
        this.follows = follows;
    }

    public List<TweetJpaModel> getTweets() {
        return tweets;
    }

    public void setTweets(List<TweetJpaModel> tweets) {
        this.tweets = tweets;
    }



}
