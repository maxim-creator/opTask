package com.max.opTask.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildBook extends Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private ChildBookType childBookType;

    @Override
    public String toString() {
        return "ChildBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pages=" + pages +
                ", childBookType=" + childBookType +
                '}';
    }
}
