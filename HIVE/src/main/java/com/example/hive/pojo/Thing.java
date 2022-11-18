package com.example.hive.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "a_thing")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Thing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    String ASIN;
    String title;
    String group;
    Integer salesrank;
    Integer categories;
    Integer reviews;
    Integer downloaded;
    Double avgrating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getASIN() {
        return ASIN;
    }

    public void setASIN(String ASIN) {
        this.ASIN = ASIN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getSalesrank() {
        return salesrank;
    }

    public void setSalesrank(Integer salesrank) {
        this.salesrank = salesrank;
    }

    public Integer getCategories() {
        return categories;
    }

    public void setCategories(Integer categories) {
        this.categories = categories;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public Integer getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(Integer downloaded) {
        this.downloaded = downloaded;
    }

    public Double getAvgrating() {
        return avgrating;
    }

    public void setAvgrating(Double avgrating) {
        this.avgrating = avgrating;
    }
}
