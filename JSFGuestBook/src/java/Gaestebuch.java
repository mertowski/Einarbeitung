
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author myu
 */
@ManagedBean(name = "obj")
@SessionScoped
public class Gaestebuch {

    private String name;
    private String email;
    private String eintrag;

    public Gaestebuch() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEintrag() {
        return eintrag;
    }

    public void setEintrag(String eintrag) {
        this.eintrag = eintrag;
    }

    public String add() {
        System.out.println("Eintrag hinzugefügt.");
        System.out.println(name + " (" + email + ")" + eintrag);
        return "erfolgreich";
    }
}
