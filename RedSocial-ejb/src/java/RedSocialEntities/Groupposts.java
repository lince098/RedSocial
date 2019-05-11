/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RedSocialEntities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PabloGL
 */
@Entity
@Table(name = "groupposts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupposts.findAll", query = "SELECT g FROM Groupposts g")
    , @NamedQuery(name = "Groupposts.findById", query = "SELECT g FROM Groupposts g WHERE g.id = :id")
    , @NamedQuery(name = "Groupposts.findByVision", query = "SELECT g FROM Groupposts g WHERE g.vision = :vision")})
public class Groupposts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "vision")
    private String vision;
    @JoinColumn(name = "grupo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Grupos grupo;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Post post;

    public Groupposts() {
    }

    public Groupposts(Integer id) {
        this.id = id;
    }

    public Groupposts(Integer id, String vision) {
        this.id = id;
        this.vision = vision;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public Grupos getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupos grupo) {
        this.grupo = grupo;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupposts)) {
            return false;
        }
        Groupposts other = (Groupposts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RedSocialEntities.Groupposts[ id=" + id + " ]";
    }
    
}
