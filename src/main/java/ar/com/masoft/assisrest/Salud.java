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
public class Salud implements java.io.Serializable,ConID {
    @Id
    @TableGenerator(name = "sld",
            table = "numerador",
            pkColumnName = "tipo",
            valueColumnName = "numero",
            pkColumnValue = "SLD",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "sld")
    @Basic(optional = false)
    @Column(name = "SLD_ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "SLD_NOMBRE", length=80)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "SLD_CALIDAD")
    private Integer calidad;
    @Column(name = "SLD_IDVIEJO")
    private Integer idViejo;
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
