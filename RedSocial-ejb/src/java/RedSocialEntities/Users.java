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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id")
    , @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name")
    , @NamedQuery(name = "Users.findBySurname", query = "SELECT u FROM Users u WHERE u.surname = :surname")
    , @NamedQuery(name = "Users.findByBirthday", query = "SELECT u FROM Users u WHERE u.birthday = :birthday")
    , @NamedQuery(name = "Users.findByGender", query = "SELECT u FROM Users u WHERE u.gender = :gender")
    , @NamedQuery(name = "Users.findByProfilePicture", query = "SELECT u FROM Users u WHERE u.profilePicture = :profilePicture")
    , @NamedQuery(name = "Users.findByIsAdmin", query = "SELECT u FROM Users u WHERE u.isAdmin = :isAdmin")
    , @NamedQuery(name = "Users.findBySearchText", query = "SELECT u FROM Users u WHERE CONCAT(u.name,' ',u.surname) LIKE CONCAT(:searchText,'%')")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "surname")
    private String surname;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(name = "gender")
    private Character gender;
    @Size(max = 50)
    @Column(name = "profile_picture")
    private String profilePicture;
    @Column(name = "isAdmin")
    private Short isAdmin;
    @ManyToMany(mappedBy = "usersList")
    private List<Grupos> gruposList;
    @ManyToMany(mappedBy = "usersList1")
    private List<Grupos> gruposList1;
    @JoinTable(name = "friendship", joinColumns = {
        @JoinColumn(name = "user1", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "user2", referencedColumnName = "id")})
    @ManyToMany
    private List<Users> usersList;
    @ManyToMany(mappedBy = "usersList")
    private List<Users> usersList1;
    @ManyToMany(mappedBy = "usersList2")
    private List<Grupos> gruposList2;
    @ManyToMany(mappedBy = "usersList")
    private List<Post> postList;
    @JoinTable(name = "friendshippetition", joinColumns = {
        @JoinColumn(name = "applicant", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "requested", referencedColumnName = "id")})
    @ManyToMany
    private List<Users> usersList2;
    @ManyToMany(mappedBy = "usersList2")
    private List<Users> usersList3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Post> postList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receiver")
    private List<Messages> messagesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sender")
    private List<Messages> messagesList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receiver")
    private List<Profileposts> profilepostsList;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String email, String password, String name, String surname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Short getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Short isAdmin) {
        this.isAdmin = isAdmin;
    }

    @XmlTransient
    public List<Grupos> getGruposList() {
        return gruposList;
    }

    public void setGruposList(List<Grupos> gruposList) {
        this.gruposList = gruposList;
    }

    @XmlTransient
    public List<Grupos> getGruposList1() {
        return gruposList1;
    }

    public void setGruposList1(List<Grupos> gruposList1) {
        this.gruposList1 = gruposList1;
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
    public List<Grupos> getGruposList2() {
        return gruposList2;
    }

    public void setGruposList2(List<Grupos> gruposList2) {
        this.gruposList2 = gruposList2;
    }

    @XmlTransient
    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @XmlTransient
    public List<Users> getUsersList2() {
        return usersList2;
    }

    public void setUsersList2(List<Users> usersList2) {
        this.usersList2 = usersList2;
    }

    @XmlTransient
    public List<Users> getUsersList3() {
        return usersList3;
    }

    public void setUsersList3(List<Users> usersList3) {
        this.usersList3 = usersList3;
    }

    @XmlTransient
    public List<Post> getPostList1() {
        return postList1;
    }

    public void setPostList1(List<Post> postList1) {
        this.postList1 = postList1;
    }

    @XmlTransient
    public List<Messages> getMessagesList() {
        return messagesList;
    }

    public void setMessagesList(List<Messages> messagesList) {
        this.messagesList = messagesList;
    }

    @XmlTransient
    public List<Messages> getMessagesList1() {
        return messagesList1;
    }

    public void setMessagesList1(List<Messages> messagesList1) {
        this.messagesList1 = messagesList1;
    }

    @XmlTransient
    public List<Profileposts> getProfilepostsList() {
        return profilepostsList;
    }

    public void setProfilepostsList(List<Profileposts> profilepostsList) {
        this.profilepostsList = profilepostsList;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RedSocialEntities.Users[ id=" + id + " ]";
    }

}
