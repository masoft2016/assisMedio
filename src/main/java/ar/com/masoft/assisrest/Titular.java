/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.masoft.assisrest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Titular implements java.io.Serializable {
    @Id
    @TableGenerator(name = "tit",
            table = "numerador",
            pkColumnName = "tipo",
            valueColumnName = "numero",
            pkColumnValue = "TIT",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tit")
    @Basic(optional = false)
    @Column(name = "TIT_ID")
    private Integer id;
    @Basic(optional = true)
    @Column(name = "OLD_IDPD")
    private Integer idPd;
    @Basic(optional = true)
    @Column(name = "OLD_IDVI")
    private Integer idVi;
    @JoinColumn(name = "CDD_ID", referencedColumnName = "CDD_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Ciudadania ciudadania;
    @JoinColumn(name = "REG_ID", referencedColumnName = "REG_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Region region;
    @JoinColumn(name = "RID_ID", referencedColumnName = "RID_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private RilasciatoDa rilasciatoDa;
    @JoinColumn(name = "RIP_ID", referencedColumnName = "RIP_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private RilasciatoPa rilasciatoPa;   
   
    @JoinColumn(name = "CIU_ID", referencedColumnName = "CIU_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Ciudad ciudad;
    
    @JoinColumn(name = "TID_ID", referencedColumnName = "TID_ID", insertable = true, updatable = true)
    @ManyToOne(optional = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private TipoDocumento tipoDocumento;
  
    
    @Basic(optional = false)
    @Column(name = "TIT_ANAGRAFE")
    private boolean anagrafe;
    
    @Column(name = "TIT_FECFECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecAnagrafe;
     
    @Basic(optional = false)
    @Column(name = "TIT_POSIZIONE")
    private Integer posizione;
    @Basic(optional = false)
    @Column(name = "TIT_SEXO", length=1)
    private String sexo;
    @Column(name = "TIT_AGGIORNATOII")
    @Temporal(TemporalType.TIMESTAMP)
    private Date agiornatoii;
    @Basic(optional = false)
    @Column(name = "TIT_COGNOME", length=80)
    private String cognome;
    @Basic(optional = false)
    @Column(name = "TIT_NOME", length=80)
    private String nome;
    @Basic(optional = true)
    @Column(name = "TIT_NUMERO")
    private Integer numero;
    @Column(name = "TIT_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nacimiento;
    @Basic(optional = true)
    @Column(name = "TIT_NACIDOEN", length=80)
    private String nacidoen;
    @Column(name = "TIT_NROPASAPORTE", length=20)
    private String nropasaporte;
    @Column(name = "TIT_RILAFECPA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rilaFecPa;
    @Column(name = "TIT_RILAFECDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rilaFecDa;
    @Basic(optional = true)
    @Column(name = "TIT_ANIOARRIVO")
    private Integer anioArrivo;
    @Basic(optional = true)
    @Column(name = "TIT_DIRECCION", length=80)
    private String direccion;
    @Basic(optional = true)
    @Column(name = "TIT_CODPOS", length=10)
    private String codPos;
    @Basic(optional = true)
    @Column(name = "TIT_LOCALIDAD", length=80)
    private String localidad;
    @Basic(optional = true)
    @Column(name = "TIT_PREFIJO", length=10)
    private String prefijo;
    @Basic(optional = true)
    @Column(name = "TIT_NUMTEL", length=30)
    private String numTel;
    @Basic(optional = true)
    @Column(name = "TIT_DATOADI1", length=100)
    private String datoAdi1;
    @Basic(optional = true)
    @Column(name = "TIT_DATOADI2", length=50)
    private String datoAdi2;
    
    @Basic(optional = true)
    @Column(name = "TIT_ANIOMUERTE")
    private Integer anioMuerte;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "titular")
    private List<OtrosDatos> otrosDat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "titular")
    private List<Pariente> pariente;
    
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
    
    public static void APLICA(Titular original, Titular modificada){
        original.setAgiornatoii( modificada.getAgiornatoii());
        original.setAnagrafe( modificada.isAnagrafe());
        original.setAnioArrivo( modificada.getAnioArrivo());
        original.setAnioMuerte( modificada.getAnioMuerte());
        original.setCiudad( modificada.getCiudad());
        original.setCiudadania(modificada.getCiudadania());
        original.setCodPos( modificada.getCodPos());
        original.setCognome(modificada.getCognome());
        original.setDatoAdi1(modificada.getDatoAdi1());
        original.setDatoAdi2(modificada.getDatoAdi2());
        original.setDireccion( modificada.getDireccion());
        original.setFecAnagrafe( modificada.getFecAnagrafe());
        original.setLocalidad( modificada.getLocalidad());
        original.setNacidoen( modificada.getNacidoen());
        original.setNacimiento( modificada.getNacimiento());
        original.setNome( modificada.getNome());
        original.setNropasaporte( modificada.getNropasaporte());
        original.setNumTel( modificada.getNumTel());
        original.setNumero( modificada.getNumero());
        original.setPosizione( modificada.getPosizione());
        original.setPrefijo( modificada.getPrefijo());
        original.setRegion( modificada.getRegion());
        original.setRilaFecDa( modificada.getRilaFecDa());
        original.setRilaFecPa( modificada.getRilaFecPa());
        original.setRilasciatoDa( modificada.getRilasciatoDa());
        original.setRilasciatoPa( modificada.getRilasciatoPa());
        original.setSexo( modificada.getSexo());
        original.setTipoDocumento( modificada.getTipoDocumento()); 
       
    }
}
