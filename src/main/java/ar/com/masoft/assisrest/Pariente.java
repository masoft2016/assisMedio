/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.masoft.assisrest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
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
public class Pariente implements java.io.Serializable {
    @Id
    @TableGenerator(name = "par",
            table = "numerador",
            pkColumnName = "tipo",
            valueColumnName = "numero",
            pkColumnValue = "PAR",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "par")
    @Basic(optional = false)
    @Column(name = "PAR_ID")
    private Integer id;
    @JsonIgnore
    @JoinColumn(name = "TIT_ID", referencedColumnName = "TIT_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)    
    private Titular titular;
    @Basic(optional = false)    
    @Column(name = "TIT_ID")
    private Integer titId;
    @Basic(optional = false)
    @Column(name = "ALO_NOMBRE", length=80)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ALO_COGNOME", length=80)
    private String cognome;
    @JoinColumn(name = "VIN_ID", referencedColumnName = "VIN_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Vinculo vinculo;
    @Column(name = "ALO_CONVIVE")
    private Boolean convive;
    @Column(name = "OTD_FECAGIORNATOII")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecAgiornatoII;
    @Column(name = "ALO_ACARGO")
    private Boolean acargo;
    @Column(name = "ALO_SESSO", length=2)
    private String sesso;
    @JoinColumn(name = "CDD_ID", referencedColumnName = "CDD_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Ciudadania ciudadania;
    @Column(name = "ALO_NASCITA")
    private Integer nascita;
    @Column(name = "ALO_NATOA")
    private String natoa;
    @Column(name = "ALO_PROVINCIA")
    private String provincia;
    @Column(name = "ALO_ARRIVO")
    private Integer arrivo;
    @Column(name = "ALO_DECESSO")
    private Integer decesso;
    @JoinColumn(name = "ECI_ID", referencedColumnName = "ECI_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Estadocivil estadocivil;
    @Column(name = "ALO_ANIOCASADO")
    private Integer anioCasado;
    @Basic(optional = true)
    @Column(name = "ALO_ANIOSEPARADO")
    private Integer anioSeparado;
    @JoinColumn(name = "ESC_ID", referencedColumnName = "ESC_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Escolaridad escolaridad;
     
    @JoinColumn(name = "PRO_ID", referencedColumnName = "PRO_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Profesion profesion;
    
    @JoinColumn(name = "OCU_ID", referencedColumnName = "OCU_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Ocupacion ocupacion;
     
    @JoinColumn(name = "EST_ID", referencedColumnName = "EST_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Estabilidad estabilidad;
    
    @JoinColumn(name = "ING_ID", referencedColumnName = "ING_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Ingresos ingresos;
    @Column(name = "ALO_OTRAFUENTE", length=100)
    private String otraFuente;
    @Basic(optional = true)
    @Column(name = "ALO_REDITO")
    private BigDecimal reditoMensual;
    @JoinColumn(name = "SLD_ID", referencedColumnName = "SLD_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Salud salud;
    
    @JoinColumn(name = "OSS_ID", referencedColumnName = "OSS_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Obrasocial obrasocial;
    
    @Basic(optional = true)
    @Column(name = "OTD_PATOLOGIA", length=100)
    private String patologia;
     @Basic(optional = true)
    @Column(name = "OTD_MEDICAMENTOS", length=100)
    private String medicamentos;
    @Basic(optional = true)
    @Column(name = "OTD_TRATAMIENTO", length=100)
    private String tratamiento;
    @Column(name = "OTD_GASTOSALUD")
    private BigDecimal gastoSalud;
    /*@JoinColumn(name = "TAL_ID", referencedColumnName = "TAL_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private TipoAlojamiento tipoAlojamiento;*/
    
    @JoinColumn(name = "ALO_ID", referencedColumnName = "ALO_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Alojamiento alojamiento;
    @Column(name = "OTD_INDIRIZZIO", length=100)
    private String indirizzio;
    @Lob
    @Basic(optional = true)
    @Column(name = "OTD_NOTA", length=65000) // ,columnDefinition = "text"
    private String nota;
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
    
    public static void APLICA(Pariente original, Pariente modificada){
        original.acargo = modificada.acargo;
        original.alojamiento = modificada.alojamiento;
        original.anioCasado = modificada.anioCasado;
        original.anioSeparado = modificada.anioSeparado;
        original.arrivo = modificada.arrivo;
        original.ciudadania = modificada.ciudadania;
        original.cognome = modificada.cognome;
        original.convive = modificada.convive;
        original.decesso = modificada.decesso;
        original.escolaridad = modificada.escolaridad;
        original.estabilidad = modificada.estabilidad;
        original.estadocivil = modificada.estadocivil;
        original.fecAgiornatoII = modificada.fecAgiornatoII;
        original.gastoSalud = modificada.gastoSalud;
        original.indirizzio = modificada.indirizzio;
        original.ingresos = modificada.ingresos;
        original.medicamentos= modificada.medicamentos;
        original.nascita = modificada.nascita;
        original.natoa = modificada.natoa;
        original.nombre = modificada.nombre;
        original.nota = modificada.nota;
        original.obrasocial = modificada.obrasocial;
        original.ocupacion = modificada.ocupacion;
        original.otraFuente=modificada.otraFuente;
        original.patologia=modificada.patologia;
        original.profesion=modificada.profesion;
        original.provincia=modificada.provincia;
        original.reditoMensual=modificada.reditoMensual;
        original.salud=modificada.salud;
        original.sesso=modificada.sesso;
        original.tratamiento=modificada.tratamiento;
        original.vinculo=modificada.vinculo;
        
    }
}
