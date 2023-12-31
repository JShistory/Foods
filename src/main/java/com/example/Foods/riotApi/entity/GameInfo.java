package com.example.Foods.riotApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
public class GameInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long gameCreation;
    private Long gameDuration;
    private Long gameEndTimestamp;
    private Long gameId;
    private String gameMode;
    private String gameName;
    private Long gameStartTimestamp;
    private String gameType;
    private String gameVersion;
    private int mapId;
    private int queueId;
    @JsonManagedReference
    @OneToMany(mappedBy = "gameInfo", fetch = FetchType.LAZY)
    private List<Participant> participants = new ArrayList<>();

    @JsonBackReference
    @OneToOne(mappedBy = "gameInfo")
    private Match match;

    @Builder
    public GameInfo(Long gameCreation, Long gameDuration, Long gameEndTimestamp, Long gameId, String gameMode, String gameName, Long gameStartTimestamp, String gameType
    ,String gameVersion, int mapId){
        this.gameCreation = gameCreation;
        this.gameDuration = gameDuration;
        this.gameEndTimestamp =  gameEndTimestamp;
        this.gameId = gameId;
        this.gameMode = gameMode;
        this.gameName = gameName;
        this.gameStartTimestamp = gameStartTimestamp;
        this.gameType = gameType;
        this.gameVersion = gameVersion;
        this.mapId = mapId;
    }

    public GameInfo() {

    }
    public void putMatch(Match match){
        this.match = match;
    }
    public void putParticipants(Participant participant){
        this.participants.add(participant);
    }
}
