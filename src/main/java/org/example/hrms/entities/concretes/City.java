package org.example.hrms.entities.concretes;
import lombok.Data;
import org.apache.commons.text.StringEscapeUtils;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String plate;
    private String name;


    public String getName() {
        return StringEscapeUtils.unescapeJava(name);
    }

}

