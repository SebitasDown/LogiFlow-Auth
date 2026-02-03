package com.LogiFlow.LogiFlow_Oauth.domain.port.in.user;

public class UpdateUserProfileCommand {
    private String fullName;
    private String email;
    private String avatarUrl;
    private String password;

    public UpdateUserProfileCommand(String fullName, String email, String avatarUrl, String password) {
        this.fullName = fullName;
        this.email = email;
        this.avatarUrl = avatarUrl;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
