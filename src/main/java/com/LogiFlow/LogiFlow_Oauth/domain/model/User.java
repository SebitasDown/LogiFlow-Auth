package com.LogiFlow.LogiFlow_Oauth.domain.model;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private Role role;
    private Integer activeShipment;
    private String avatarUrl;
    private String avatarColor;
    private Status status;

    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public User() {
    }

    public void updateProfile(String fullName, String email, String password, Role role, Integer activeShipment, String avatarUrl, String avatarColor, Status status) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.activeShipment = activeShipment;
        this.avatarUrl = avatarUrl;
        this.avatarColor = avatarColor;
        this.status = status;
    }

    public User(Long id, String fullName, String email, String password, Role role, Integer activeShipment, String avatarUrl, String avatarColor, Status status) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.activeShipment = activeShipment;
        this.avatarUrl = avatarUrl;
        this.avatarColor = avatarColor;
        this.status = status;
    }

    public void updateProfilePhoto(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getActiveShipment() {
        return activeShipment;
    }

    public void setActiveShipment(Integer activeShipment) {
        this.activeShipment = activeShipment;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarColor() {
        return avatarColor;
    }

    public void setAvatarColor(String avatarColor) {
        this.avatarColor = avatarColor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
