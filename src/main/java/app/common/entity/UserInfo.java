package app.common.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by user on 08.08.2016.
 */

@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_info_id")
    private long id;

    @Size(min = 60)
    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    @Size(min = 60)
    @NotEmpty
    @Column(name = "last_name")
    private String lastName;

    @Size(min = 60)
    @NotEmpty
    @Column(name = "adress")
    private String adress;

//    @Size(min = 60)
    @NotEmpty
    @Column(name = "country_code")
    private int countryCode;

//    @Size(min = 60)
    @NotEmpty
    @Column(name = "area_code")
    private int areaCode;

    @Size(min = 60)
    @NotEmpty
    @Column(name = "mobile")
    private String mobile;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
