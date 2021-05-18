package com.cv.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Loisire")
public class Loisire implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(updatable = false, nullable = false)
    private Long id;
    private String Loisire;
    
    public String getLoisire()
    {
    	return Loisire;
    }
    public void setLoisire(String Loisire)
    {
    	this.Loisire =Loisire;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur",referencedColumnName ="id", updatable = false)
    private Utilisateur utilisateur;

}
