
/**
 *
 * @author myu
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;

public class PageController implements Serializable {

    private static final long serialVersionUID = 1L;

    public String moveToPage1() {
        return "page1";
    }

    public String moveToPage2() {
        return "page2";
    }

}
