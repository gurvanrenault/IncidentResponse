package com.incidentresponse.application.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import  java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class IncidentDTO {


    int id ;

    @NotNull
    String title;

    @NonNull
    int user;

    @NonNull
    String description;

    int price;

    int quantity;

    @NonNull
    String inventoryStatus;

    ArrayList<CommentaryDTO> commentaries;

    Date date;
}
