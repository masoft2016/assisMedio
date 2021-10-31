/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.masoft.assisrest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
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
public class Usuario implements java.io.Serializable {

    @Id
    @TableGenerator(name = "usu",
            table = "numerador",
            pkColumnName = "tipo",
            valueColumnName = "numero",
            pkColumnValue = "USU",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "usu")
    @Basic(optional = false)
    @Column(name = "USU_ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "USU_NOMBRE", length = 80)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "USU_CLAVE", length = 80)
    private String clave;
    @Column(name = "USU_COMPLETO", length = 80)
    private String completo;
    @Basic(optional = false)
    @Column(name = "USU_ACTIVO")
    private boolean activo;
    @Basic(optional = false)
    @Column(name = "USU_ROLES", length = 200)
    private String roles;
    @Column(name = "USU_MAIL", length = 200)
    private String mail;
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

    @Transient
    public static String getClaveConvertida(String claveLisa) throws UnsupportedEncodingException, NoSuchAlgorithmException {
       
        byte[] bytesOfMessage = claveLisa.getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(bytesOfMessage);
        BigInteger bigInt = new BigInteger(1, thedigest);
        String hashtext = bigInt.toString(16);
        String laclave = String.format("%1$32s", hashtext).replace(' ', '0');
        return laclave;
    }
}
