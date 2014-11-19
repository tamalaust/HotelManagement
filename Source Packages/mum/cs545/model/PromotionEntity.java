/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs545.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author Imran
 */
@Entity
public class PromotionEntity implements Serializable {
     @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;
    private static final long serialVersionUID = 1L;
    private String name;
    private String promotionCode;
    private String description;
    private int discount;
    private String startDate ;
    private String endDate;
    

    public PromotionEntity(){}
    
    public PromotionEntity(String name,String promotionCode, String description, int discount, String startDate, String endDate) {
       this.name=name;
        this.promotionCode = promotionCode;
        this.description = description;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
       
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
    

}
