/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.masoft.assisrest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Cuotas implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    public static void APLICALO(Cuotas c, Cuotas co) {
        c.setEstado(co.getEstado());
        c.setFecEstado(co.getFecEstado());
        c.setFecha(co.getFecha());
        c.setImporte(co.getImporte());
        c.setNota(co.getNota());
    }

    public static enum ESTADO {
        NO_ESPECIFICADO, PARA_ENTREGAR, ENTREGADO, DILATADO
    };
    @EmbeddedId
    private CuotasPK cuotasPK;
    @Column(name = "CUO_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "CUO_FECESTADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEstado;
    @Column(name = "CUO_ESTADO")
    private Integer estado;         //1 Para entregar, 2 entregado, 3 dilatado
    @Column(name = "CUO_IMPORTE")
    private BigDecimal importe;
    @Column(name = "CUO_NOTA")
    private String nota;
    @CreatedBy
    @Column(name = "AUD_USUALTA", length = 50)
    private String user;
    @LastModifiedBy
    @Column(name = "AUD_USUMOD", length = 50)
    private String userMod;
    @CreatedDate
    @Column(name = "AUD_FECHALTA")
    private Long audFechaAlta;
    @LastModifiedDate
    @Column(name = "AUD_FECHAMOD")
    private Long audFechaMod;
    private @Version
    @JsonIgnore
    Long version;

}
