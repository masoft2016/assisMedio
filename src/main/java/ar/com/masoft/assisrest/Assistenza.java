/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.masoft.assisrest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
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
public class Assistenza implements java.io.Serializable {
    @Id
    @TableGenerator(name = "ass",
            table = "numerador",
            pkColumnName = "tipo",
            valueColumnName = "numero",
            pkColumnValue = "ASS",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ass")
    @Basic(optional = false)
    @Column(name = "ASS_ID")
    private Integer id;
    @JoinColumn(name = "AST_ID", referencedColumnName = "AST_ID", insertable = true, updatable = true)
    @ManyToOne(optional = false)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private AssistenzaTipo tipo;
    @JoinColumn(name = "TIT_ID", referencedColumnName = "TIT_ID", insertable = true, updatable = true)
    @ManyToOne(optional = false)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Titular titular;
    @Lob
    @Basic(optional = true)
    @Column(name = "ASS_MOTIVO", length=65000) // ,columnDefinition = "text"
    private String motivo;
    @Column(name = "ASS_LEGAL")
    private Boolean legal;    
    @Column(name = "ASS_FARMACIA")
    private Boolean farmacia;    
    @Column(name = "ASS_SANITARIA")
    private Boolean sanitaria;    
     @Lob
    @Basic(optional = true)
    @Column(name = "ASS_NOTA", length=65000) // ,columnDefinition = "text"
    private String nota;
    @Lob
    @Basic(optional = true)
    @Column(name = "ASS_CONCLUSIONC", length=65000) // ,columnDefinition = "text"
    private String conclusionC; 
    @Lob
    @Basic(optional = true)
    @Column(name = "ASS_CONCLUSIONM", length=65000) // ,columnDefinition = "text"
    private String conclusionM; 
    @Column(name = "AST_USUARIOM", length=80)
    private String usuarioM;
    @Column(name = "AST_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "AST_FECESTADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEstado;
    
    @JoinColumn(name = "ASE_ID", referencedColumnName = "ASE_ID", insertable = true, updatable = true)
    @ManyToOne(optional = false)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private AssistenzaEstado estado;
    @Column(name = "AST_FECRICHIESTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRichiesta;
    @JoinColumn(name = "RIC_USU_ID", referencedColumnName = "USU_ID", insertable = true, updatable = true)
    @ManyToOne(optional = false)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Usuario usuRichiesta;
    
    @Column(name = "AST_FECPROPUESTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecPropuesta;
    @JoinColumn(name = "PRO_USU_ID", referencedColumnName = "USU_ID", insertable = true, updatable = true)
    @ManyToOne(optional = false)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Usuario usuPropuesta;
    
    
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
