/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.masoft.assisrest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author magug
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Estadocivil implements java.io.Serializable {
    @Id
    @TableGenerator(name = "eci",
            table = "numerador",
            pkColumnName = "tipo",
            valueColumnName = "numero",
            pkColumnValue = "ECI",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "eci")
    @Basic(optional = false)
    @Column(name = "ECI_ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ECI_NOMBRE", length=80)
    private String nombre;
    
    @CreatedBy
    @Column(name = "AUD_USUALTA", length=50)
    private String user;
    @LastModifiedBy 
    @Column(name = "AUD_USUMOD" , length=50)
    private String userMod;
    @CreatedDate 
    @Column(name = "AUD_FECHALTA")    
    private Long audFechaAlta;
    @LastModifiedDate
    @Column(name = "AUD_FECHAMOD")    
    private Long audFechaMod;
    private @Version @JsonIgnore Long version;
}
