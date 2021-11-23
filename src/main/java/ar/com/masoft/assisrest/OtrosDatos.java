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
    @JsonIgnore
    @JoinColumn(name = "TIT_ID", referencedColumnName = "TIT_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)    
    private Titular titular;
    @Basic(optional = false)    
    @Column(name = "TIT_ID")
    private Integer titId;
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
    @Lob
    @Basic(optional = true)
    @Column(name = "OTD_AIUTO", length=65000) // ,columnDefinition = "text"
    private String aiuto;
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

    public static void APLICA(OtrosDatos original, OtrosDatos modificada){
        if ((original == null) || (modificada == null)){
            return;
        }
        original.setAbbigliamento( modificada.getAbbigliamento());
        original.setAffito(modificada.getAffito());
        original.setAgua(modificada.getAgua());
        original.setAgua2(modificada.getAgua2());
        original.setAgua3(modificada.getAgua3());
        original.setAlojamiento(modificada.getAlojamiento());
        original.setAltroSpese(modificada.getAltroSpese());
        original.setAnioCasado(modificada.getAnioCasado());
        original.setAnioSeparado(modificada.anioSeparado);
        original.setAutomobile(modificada.getAutomobile());
        original.setBagni(modificada.getBagni());
        original.setBagniT(modificada.getBagniT());
        original.setCamere(modificada.getCamere());
        original.setCamereT(modificada.getCamereT());
        original.cochera=modificada.cochera;
        original.cocheraT=modificada.cocheraT;
        original.cocina=modificada.cocina;
        original.cocinaT=modificada.cocinaT;
        original.conclusion=modificada.conclusion;
        original.conclusionUff=modificada.conclusionUff;
        original.confort=modificada.confort;
        original.contexto=modificada.contexto;
        original.datoAdi1=modificada.datoAdi1;
        original.debiti=modificada.debiti;
        original.docBit=modificada.docBit;
        original.docCompleta=modificada.docCompleta;
        original.electrodomestico=modificada.electrodomestico;
        original.escolaridad=modificada.escolaridad;
        original.estabilidad=modificada.estabilidad;
        original.estadocivil=modificada.estadocivil;
        original.fecConclusion=modificada.fecConclusion;
        original.fecConclusionUff=modificada.fecConclusionUff;
        original.fecIndigencia=modificada.fecIndigencia;
        original.fecha=modificada.fecha;
        original.galpon=modificada.galpon;
        original.galponT=modificada.galponT;
        original.gas=modificada.gas;
        original.gas2=modificada.gas2;
        original.gas3=modificada.gas3;
        original.gastoSalud=modificada.gastoSalud;
        original.imposte=modificada.imposte;
        original.indigencia=modificada.indigencia;
        original.ingresos=modificada.ingresos;
        original.livelloIndigenza=modificada.livelloIndigenza;
        original.living=modificada.living;
        original.livingT=modificada.livingT;
        original.luz=modificada.luz;
        original.luz2=modificada.luz2;
        original.luz3=modificada.luz3;
        original.mantenimiento=modificada.mantenimiento;
        original.manutenzione=modificada.manutenzione;
        original.materiales=modificada.materiales;
        original.medicamentos=modificada.medicamentos;
        original.moneda1=modificada.moneda1;
        original.moneda2=modificada.moneda2;
        original.muebles=modificada.muebles;
        original.nota=modificada.nota;
        original.notaDocumentacion=modificada.notaDocumentacion;
        original.noteAbitazione=modificada.noteAbitazione;
        original.obrasocial=modificada.obrasocial;
        original.ocupacion=modificada.ocupacion;
        original.otraFuente=modificada.otraFuente;
        original.otraPropiedad=modificada.otraPropiedad;
        original.otro=modificada.otro;
        original.otroT=modificada.otroT;
        original.patologia=modificada.patologia;
        original.ph=modificada.ph;
        original.profesion=modificada.profesion;
        original.reditoMensual=modificada.reditoMensual;
        original.reditoMensual2=modificada.reditoMensual2;
        original.salud=modificada.salud;
        original.supCubierta=modificada.supCubierta;
        original.supTerreno=modificada.supTerreno;
        original.telefono=modificada.telefono;
        original.telefono2=modificada.telefono2;
        original.telefono3=modificada.telefono3;
        original.terminaciones=modificada.terminaciones;
        original.tipoAlojamiento=modificada.tipoAlojamiento;
        original.titId=modificada.titId;
        original.transporto=modificada.transporto;
        original.tratamiento=modificada.tratamiento;
        original.viaje=modificada.viaje;
        original.aiuto=modificada.aiuto;
        
        
        
    }
}
