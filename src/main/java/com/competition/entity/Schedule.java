package com.competition.entity;

import java.io.Serializable;

public class Schedule implements Serializable {
    private Integer scheduleId;

    /**
    * 比赛编码
    */
    private Integer gameId;

    /**
    * 选手编码
    */
    private Integer playerId;

    /**
    * 所属组别
    */
    private String groupName;

    /**
     * 节目名称
     */
    private String title;

    private Game game;

    private Player player;

    private static final long serialVersionUID = 1L;

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}