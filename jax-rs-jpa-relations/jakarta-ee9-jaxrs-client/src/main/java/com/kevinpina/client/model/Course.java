package com.kevinpina.client.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement // Used just in case we return or receive a XML
public class Course {

    private Long id;
    private String name;
    private String description;
    private Instructor instructor;
    private Double duration;

}
