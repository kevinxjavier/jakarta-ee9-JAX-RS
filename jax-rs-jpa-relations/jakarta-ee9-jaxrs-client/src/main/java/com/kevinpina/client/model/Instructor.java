package com.kevinpina.client.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement // Used just in case we return or receive a XML
public class Instructor {

    private int id;
    private String name;
    private String surName;

}
