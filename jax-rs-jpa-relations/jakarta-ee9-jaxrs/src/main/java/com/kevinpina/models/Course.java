package com.kevinpina.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Note: When work with SOAP or REST Services avoid using JPA relations such as:
 * @ManyToMany, @OneToOne, @OneToMany, @ManyToOne because it will raised a cyclical call
 * causing a failing web service. To avoid that keep it simple and use @Xmltransient and @JSONTransient.
 * Example:
 *   @Xmltransient   // With this in the generated xml does not contain the instructor. Avoiding cyclical call.
 *  private Instructor instructor;
 */

@XmlRootElement // Used because of @Produces(MediaType.APPLICATION_XML) CourseRestController if it is JSON not necessary.
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    // @XMLTransient
    // @JsonbTransient
    // @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "instructor_id") // Column name by default
    private Instructor instructor;

    private Double duration;

}
