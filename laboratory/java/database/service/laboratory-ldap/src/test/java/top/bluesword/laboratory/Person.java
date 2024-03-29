package top.bluesword.laboratory;

import lombok.Data;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

@Data
@Entry(base = "dc=bluesword,dc=top", objectClasses = "inetOrgPerson")
public class Person {

    @Id
    private Name id;

    @DnAttribute(value = "uid", index = 3)
    private String uid;

    @Attribute(name = "cn")
    private String commonName;

    @Attribute(name = "sn")
    private String suerName;

    private String userPassword;

}
