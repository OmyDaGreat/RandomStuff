package org.example.ultimateFootball;

import java.util.*;

public class UltimateTeam {
  private final ArrayList<UltimatePlayer> players;
  private final ArrayList<Coach> coaches;
  
  public UltimateTeam(List<UltimatePlayer> players, List<Coach> coaches) {
    this.players = (ArrayList<UltimatePlayer>) players;
    this.coaches = (ArrayList<Coach>) coaches;
  }
  
  public String getCutters() {
    ArrayList<UltimatePlayer> cutters = new ArrayList<>();
    for(UltimatePlayer u : players) {
      if(u.getPosition().equals("cutter")) {
        cutters.add(u);
      }
    }
    StringBuilder r = new StringBuilder();
    for(UltimatePlayer u : cutters) {
      r.append(u.toString()).append("\n");
    }
    return r.toString();
  }
  
  public String getHandlers() {
    ArrayList<UltimatePlayer> handlers = new ArrayList<>();
    for(UltimatePlayer u : players) {
      if(u.getPosition().equals("handler")) {
        handlers.add(u);
      }
    }
    StringBuilder r = new StringBuilder();
    for(UltimatePlayer u : handlers) {
      r.append(u.toString()).append("\n");
    }
    return r.toString();
  }
  
  public String toString() {
    StringBuilder r = new StringBuilder("COACHES");
    for(Coach u : coaches) {
      r.append("\n").append(u);
    }
    r.append("\n\nPLAYERS");
    for(UltimatePlayer u : players) {
      r.append("\n").append(u);
    }
    return r.toString();
  }
}