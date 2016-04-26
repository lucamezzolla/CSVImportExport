package csvimportexport;

/**
 *
 * @author Luca Mezzolla
 */
public class MyUtils {
    
    public static enum FileNames {
        
        FILTERS(0) {
            @Override
            public String toString() {
                return "filters.properties";
            }
        };

        private int value;
        
        private FileNames(int value) {
            this.value = value;
        }
        
    }

}
