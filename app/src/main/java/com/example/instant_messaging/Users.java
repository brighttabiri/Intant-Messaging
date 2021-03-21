package com.example.instant_messaging;

public class Users {
    public String Id;
    public String user_name;
    public String image;
    public String status;
    public String search;



    public Users(String id, String username, String imageURL, String status, String search) {
        this.Id = id;
        this.user_name = username;
        this.image = imageURL;
        this.status = status;
        this.search = search;
    }
    public Users() {

    }


    public String getId() {
        return Id;
    }
    public void setId(String id) {
        this.Id = id;
    }

    public String getUser_name() {
        return user_name;
    }
    public void setUsername(String username) {
        this.user_name = username;
    }

    public String getImage() {
        return image;
    }
    public void setImageURL(String imageURL) {
        this.image = imageURL;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getSearch() {
        return search;
    }
    public void setSearch(String search) {
        this.search = search;
    }


}
