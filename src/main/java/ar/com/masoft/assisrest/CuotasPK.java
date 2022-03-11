/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.masoft.assisrest;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author magug
 */
@Data

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CuotasPK  implements Serializable {
    @Basic(optional = false)
    @Column(name = "ASS_ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CUO_ID")
    private Integer cuota;

}
