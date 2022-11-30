package sep.mini.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Film {
    @Transient
    public static Film INVALID = new Film();

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String author;
    private int duration;
    private int publishedYear;

    public Film(String title, String author, int duration, int publishedYear) {
        this.title = title;
        this.author = author;
        this.duration = duration;
        this.publishedYear = publishedYear;
    }
}
