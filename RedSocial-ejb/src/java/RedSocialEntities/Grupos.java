/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RedSocialEntities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PabloGL
 */
@Entity
@Table(name = "grupos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupos.findAll", query = "SELECT g FROM Grupos g")
    , @NamedQuery(name = "Grupos.findById", query = "SELECT g FROM Grupos g WHERE g.id = :id")
    , @NamedQuery(name = "Grupos.findByName", query = "SELECT g FROM Grupos g WHERE g.name = :name")
    , @NamedQuery(name = "Grupos.findByCreationDate", query = "SELECT g FROM Grupos g WHERE g.creationDate = :creationDate")
    , @NamedQuery(name = "Grupos.findByImagePath", query = "SELECT g FROM Grupos g WHERE g.imagePath = :imagePath")
    , @NamedQuery(name = "Grupos.findBySearchText", query = "SELECT g FROM Grupos g WHERE g.name Like CONCAT(:name,'%')")})
public class Grupos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Size(max = 45)
    @Column(name = "imagePath")
    private String imagePath;
    @JoinTable(name = "joinpetition", joinColumns = {
        @JoinColumn(name = "groupId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "userId", referencedColumnName = "id")})
    @ManyToMany
    private List<Users> usersList;
    @JoinTable(name = "groupadmins", joinColumns = {
        @JoinColumn(name = "grupo", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "admin", referencedColumnName = "id")})
    @ManyToMany
    private List<Users> usersList1;
    @JoinTable(name = "belongtogroup", joinColumns = {
        @JoinColumn(name = "groupId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "userId", referencedColumnName = "id")})
    @ManyToMany
    private List<Users> usersList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo")
    private List<Groupposts> grouppostsList;

    public Grupos() {
    }

    public Grupos(Integer id) {
        this.id = id;
    }

    public Grupos(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @XmlTransient
    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    @XmlTransient
    public List<Users> getUsersList1() {
        return usersList1;
    }

    public void setUsersList1(List<Users> usersList1) {
        this.usersList1 = usersList1;
    }

    @XmlTransient
    public List<Users> getUsersList2() {
        return usersList2;
    }

    public void setUsersList2(List<Users> usersList2) {
        this.usersList2 = usersList2;
    }

    @XmlTransient
    public List<Groupposts> getGrouppostsList() {
        return grouppostsList;
    }

    public void setGrouppostsList(List<Groupposts> grouppostsList) {
        this.grouppostsList = grouppostsList;
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
        if (!(object instanceof Grupos)) {
            return false;
        }
        Grupos other = (Grupos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RedSocialEntities.Grupos[ id=" + id + " ]";
    }

}
