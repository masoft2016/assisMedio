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
public class OtrosDatos implements java.io.Serializable {
    @Id
    @TableGenerator(name = "otd",
            table = "numerador",
            pkColumnName = "tipo",
            valueColumnName = "numero",
            pkColumnValue = "OTD",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "otd")
    @Basic(optional = false)
    @Column(name = "OTD_ID")
    private Integer id;
    @JoinColumn(name = "TIT_ID", referencedColumnName = "TIT_ID", insertable = true, updatable = true)
    @ManyToOne(optional = false)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Titular titular;
    @Basic(optional = false)    
    @Column(name = "OTD_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
      
    @JoinColumn(name = "ECI_ID", referencedColumnName = "ECI_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Estadocivil estadocivil;
    
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
     
    @Basic(optional = true)
    @Column(name = "OTD_MONEDA1", length=5)
    private String moneda1;
    @Basic(optional = true)
    @Column(name = "OTD_MONEDA2", length=5)
    private String moneda2;
    
    @JoinColumn(name = "SLD_ID", referencedColumnName = "SLD_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Salud salud;
    
    @JoinColumn(name = "OSS_ID", referencedColumnName = "OSS_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Obrasocial obrasocial;
    
    @JoinColumn(name = "ALO_ID", referencedColumnName = "ALO_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Alojamiento alojamiento;
    
    @JoinColumn(name = "CTX_ID", referencedColumnName = "CTX_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Contexto contexto;
    
    @JoinColumn(name = "TAL_ID", referencedColumnName = "TAL_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private TipoAlojamiento tipoAlojamiento;
    
    @JoinColumn(name = "MAT_ID", referencedColumnName = "MAT_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Materiales materiales;
    
    @JoinColumn(name = "MNT_ID", referencedColumnName = "MNT_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Mantenimiento mantenimiento;
    
    @JoinColumn(name = "TER_ID", referencedColumnName = "TER_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Terminaciones terminaciones;
    
    @JoinColumn(name = "CNF_ID", referencedColumnName = "CNF_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Confort confort;
    
    @JoinColumn(name = "MUE_ID", referencedColumnName = "MUE_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Muebles muebles;
    
    @JoinColumn(name = "ELC_ID", referencedColumnName = "ELC_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Electrodomestico electrodomestico;
    @Lob
    @Basic(optional = true)
    @Column(name = "OTD_NOTA", length=65000) // ,columnDefinition = "text"
    private String nota;
    @Basic(optional = true)
    @Column(name = "OTD_AYUDA", length=100)
    private String datoAdi1;
    @Column(name = "OTD_FECCONCLUSION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecConclusion;
    @Lob
    @Basic(optional = true)
    @Column(name = "OTD_CONCLUSION", length=65000) // ,columnDefinition = "text"
    private String conclusion;
    @Column(name = "OTD_FECCONCLUSIONUFF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecConclusionUff;
    @Lob
    @Basic(optional = true)
    @Column(name = "OTD_CONCLUSIONUFF", length=65000) // ,columnDefinition = "text"
    private String conclusionUff;
    @Basic(optional = true)
    @Column(name = "OTD_REDITO")
    private BigDecimal reditoMensual;
    @Column(name = "OTD_REDITO2")
    private BigDecimal reditoMensual2;
    @Basic(optional = true)
    @Column(name = "OTD_OTRAFUENTE", length=100)
    private String otraFuente;
    @Column(name = "OTD_LIVELLOINDIGENZA")
    private BigDecimal livelloIndigenza;
    @Basic(optional = true)
    @Column(name = "OTD_MEDICAMENTOS", length=100)
    private String medicamentos;
    @Basic(optional = true)
    @Column(name = "OTD_TRATAMIENTO", length=100)
    private String tratamiento;
    @Basic(optional = true)
    @Column(name = "OTD_PATOLOGIA", length=100)
    private String patologia;
    @Column(name = "OTD_GASTOSALUD")
    private BigDecimal gastoSalud;
    @Basic(optional = true)
    @Column(name = "OTD_ANIOCASADO")
    private Integer anioCasado;
    @Basic(optional = true)
    @Column(name = "OTD_ANIOSEPARADO")
    private Integer anioSeparado;
    @Basic(optional = true)
    @Column(name = "OTD_PH")
    private Boolean ph;
    @Basic(optional = true)
    @Column(name = "OTD_SUPCUBIERTA")
    private Integer supCubierta;
    @Basic(optional = true)
    @Column(name = "OTD_SUPTERRENO")
    private Integer supTerreno;
    
    @Basic(optional = true)
    @Column(name = "OTD_COCINA")
    private Integer cocina;
    @Basic(optional = true)
    @Column(name = "OTD_CAMERE")
    private Integer camere;
    @Basic(optional = true)
    @Column(name = "OTD_BAGNI")
    private Integer bagni;
    @Basic(optional = true)
    @Column(name = "OTD_LIVING")
    private Integer living;
    @Basic(optional = true)
    @Column(name = "OTD_COCHERA")
    private Integer cochera;
    @Basic(optional = true)
    @Column(name = "OTD_GALPON")
    private Integer galpon;
    @Basic(optional = true)
    @Column(name = "OTD_OTRO")
    private Integer otro;
    
    @Basic(optional = true)
    @Column(name = "OTD_COCINAT", length=20)
    private String cocinaT;
    @Basic(optional = true)
    @Column(name = "OTD_CAMERET", length=20)
    private String camereT;
    @Basic(optional = true)
    @Column(name = "OTD_BAGNIT", length=20)
    private String bagniT;
    @Basic(optional = true)
    @Column(name = "OTD_LIVINGT", length=20)
    private String livingT;
    @Basic(optional = true)
    @Column(name = "OTD_COCHERAT", length=20)
    private String cocheraT;
    @Basic(optional = true)
    @Column(name = "OTD_GALPONT", length=20)
    private String galponT;
    @Basic(optional = true)
    @Column(name = "OTD_OTROT", length=20)
    private String otroT;
    @Column(name = "OTD_AFFITO")
    private BigDecimal affito;
    @Column(name = "OTD_IMPOSTE")
    private BigDecimal imposte;
    @Column(name = "OTD_MANUTENZIONE")
    private BigDecimal manutenzione;
    @Column(name = "OTD_ALTROSPESE")
    private BigDecimal altroSpese;
    @Column(name = "OTD_TRANSPORTO")
    private BigDecimal transporto;
    
    @Column(name = "OTD_LUZ")
    private BigDecimal luz;
    @Column(name = "OTD_GAS")
    private BigDecimal gas;
    @Column(name = "OTD_TELEFONO")
    private BigDecimal telefono;
    @Column(name = "OTD_AGUA")
    private BigDecimal agua;
    @Column(name = "OTD_LUZ2")
    private BigDecimal luz2;
    @Column(name = "OTD_GAS2")
    private BigDecimal gas2;
    @Column(name = "OTD_TELEFONO2")
    private BigDecimal telefono2;
    @Column(name = "OTD_AGUA2")
    private BigDecimal agua2;
    @Column(name = "OTD_LUZ3")
    private BigDecimal luz3;
    @Column(name = "OTD_GAS3")
    private BigDecimal gas3;
    @Column(name = "OTD_TELEFONO3")
    private BigDecimal telefono3;
    @Column(name = "OTD_AGUA3")
    private BigDecimal agua3;
    @Basic(optional = true)
    @Column(name = "OTD_VIAJE", length=100)
    private String viaje;
    @Basic(optional = true)
    @Column(name = "OTD_ABBIGLIAMENTO", length=100)
    private String abbigliamento;
    @Basic(optional = true)
    @Column(name = "OTD_AUTOMOBILE", length=100)
    private String automobile;
    @Basic(optional = true)
    @Column(name = "OTD_OTRAPROPIEDAD", length=100)
    private String otraPropiedad;
     @Lob
    @Basic(optional = true)
    @Column(name = "OTD_NOTEABITAZIONE", length=65000) // ,columnDefinition = "text"
    private String noteAbitazione;
    @Basic(optional = true)
    @Column(name = "OTD_DEBITI", length=100)
    private String debiti; 
    @Basic(optional = false)
    @Column(name = "OTD_DOCBIT")
    private Integer docBit;
    @Basic(optional = false)
    @Column(name = "OTD_DOCCOMPLETA")
    private Boolean docCompleta;
    @Column(name = "OTD_NOTADOC", length=500)
    private String notaDocumentacion;
    
    @JoinColumn(name = "IND_ID", referencedColumnName = "IND_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Indigencia indigencia;
    @Column(name = "OTD_FECINDIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIndigencia;
    
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
