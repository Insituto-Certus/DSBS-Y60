/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package certus.edu.pe.modelo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import jakarta.persistence.NamedQueries;

/**
 *
 * @author man
 */
@Entity
@Table(name = "cine")
//@XmlRootElement

//Utilizando Lombock
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor

@NamedQueries({
    @NamedQuery(name = "Cine.findAll", query = "SELECT c FROM Cine c")
    , @NamedQuery(name = "Cine.findByIdCine", query = "SELECT c FROM Cine c WHERE c.idCine = :idCine")
    , @NamedQuery(name = "Cine.findByRazonSocial", query = "SELECT c FROM Cine c WHERE c.razonSocial = :razonSocial")
    , @NamedQuery(name = "Cine.findByNombre", query = "SELECT c FROM Cine c WHERE c.nombre = :nombre")})
public class Cine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCine")
    private Integer idCine;
    @Basic(optional = false)
    @Column(name = "razonSocial")
    private String razonSocial;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cine")
    @JsonBackReference(value="cine_sede")
    private List<Sede> sedeList;

    
}
