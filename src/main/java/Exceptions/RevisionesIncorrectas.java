
package Exceptions;

public class RevisionesIncorrectas extends IllegalArgumentException {

    public RevisionesIncorrectas() {
    }

    public RevisionesIncorrectas(String errMsg) {
        super(errMsg);
    }
}
