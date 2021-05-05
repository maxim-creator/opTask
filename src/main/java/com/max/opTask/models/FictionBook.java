package com.max.opTask.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FictionBook extends Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    FictionBookType fictionBookType;

    @Override
    public String toString() {
        return "FictionBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pages=" + pages +
                ", fictionBookType=" + fictionBookType +
                '}';
    }
}
