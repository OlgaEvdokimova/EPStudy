package String2;

import java.io.Serializable;

public class Letter implements Serializable {
    private static final long serialVersionUID = 1;
    String symbol;


    Letter(String symbol) {
        this.symbol = symbol;
    }

    public String toString() {
        return symbol ;
    }

    @Override
    public boolean equals(Object obj) {
        return symbol.equals(obj);
    }
    @Override
    public int hashCode() {
        return symbol.hashCode();
    }

}
