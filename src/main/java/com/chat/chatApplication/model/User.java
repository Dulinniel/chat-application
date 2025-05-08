package com.chat.chatApplication.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class User implements Serializable // Add Serialization for Database
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Use a safely generated value
  @Column(nullable = false, updatable = false) // Protect the Column
  private Long id;
  private String name;
  private String email;
  private String pubKey;
  private String secKey;
  private String avatarURL;

  public User() {}

  public User(String name, String email, String avatarURL)
  {
    this.name = name;
    this.email = email;
    this.avatarURL = avatarURL;
  }

  public User(String name, String email, String pubKey, String secKey, String avatarURL)
  {
    this.name = name;
    this.email = email;
    this.pubKey = pubKey;
    this.secKey = secKey;
    this.avatarURL = avatarURL;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public void setPubKey(String pubKey)
  {
    this.pubKey = pubKey;
  }

  public void setSecKey(String secKey)
  {
    this.secKey = secKey;
  }

  public void setAvatarURL(String avatarURL)
  {
    this.avatarURL = avatarURL;
  }
    
  public String getName()
  {
    return this.name;
  }

  public String getEmail()
  {
    return this.email;
  }

  public String getPubKey()
  {
    return this.pubKey;
  }

  public String getSecKey()
  {
    return this.secKey;
  }

  public String getAvatarURL()
  {
    return this.avatarURL;
  }

  @Override
  public String toString()
  {
    return "User {\n" + 
      "id= " + this.id +
      ", name= '" + this.name + "'" +
      ", email= '" + this.email + "'" +
      ", pubKey= '" + this.pubKey + "'" +
      ", secKey= '" + this.secKey + "'" +
      ", avatarURL= '" + this.avatarURL + "'\n}";
  }

}
