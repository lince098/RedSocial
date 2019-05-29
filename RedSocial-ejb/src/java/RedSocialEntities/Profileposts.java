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
@Table(name = "profileposts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profileposts.findAll", query = "SELECT p FROM Profileposts p")
    , @NamedQuery(name = "Profileposts.findById", query = "SELECT p FROM Profileposts p WHERE p.id = :id")
    , @NamedQuery(name = "Profileposts.findByVision", query = "SELECT p FROM Profileposts p WHERE p.vision = :vision")
    , @NamedQuery(name = "Profileposts.findByUser", query = "SELECT p FROM Profileposts p WHERE p.receiver.id = :userID")})
public class Profileposts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "vision")
    private String vision;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Post post;
    @JoinColumn(name = "receiver", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users receiver;

    public Profileposts() {
    }

    public Profileposts(Integer id) {
        this.id = id;
    }

    public Profileposts(Integer id, String vision) {
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Users getReceiver() {
        return receiver;
    }

    public void setReceiver(Users receiver) {
        this.receiver = receiver;
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
        if (!(object instanceof Profileposts)) {
            return false;
        }
        Profileposts other = (Profileposts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RedSocialEntities.Profileposts[ id=" + id + " ]";
    }

}
