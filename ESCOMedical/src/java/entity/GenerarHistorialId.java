package entity;
// Generated 31/05/2018 09:05:04 AM by Hibernate Tools 4.3.1



/**
 * GenerarHistorialId generated by hbm2java
 */
public class GenerarHistorialId  implements java.io.Serializable {


     private String curpm;
     private String curppHistorial;

    public GenerarHistorialId() {
    }

    public GenerarHistorialId(String curpm, String curppHistorial) {
       this.curpm = curpm;
       this.curppHistorial = curppHistorial;
    }
   
    public String getCurpm() {
        return this.curpm;
    }
    
    public void setCurpm(String curpm) {
        this.curpm = curpm;
    }
    public String getCurppHistorial() {
        return this.curppHistorial;
    }
    
    public void setCurppHistorial(String curppHistorial) {
        this.curppHistorial = curppHistorial;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof GenerarHistorialId) ) return false;
		 GenerarHistorialId castOther = ( GenerarHistorialId ) other; 
         
		 return ( (this.getCurpm()==castOther.getCurpm()) || ( this.getCurpm()!=null && castOther.getCurpm()!=null && this.getCurpm().equals(castOther.getCurpm()) ) )
 && ( (this.getCurppHistorial()==castOther.getCurppHistorial()) || ( this.getCurppHistorial()!=null && castOther.getCurppHistorial()!=null && this.getCurppHistorial().equals(castOther.getCurppHistorial()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCurpm() == null ? 0 : this.getCurpm().hashCode() );
         result = 37 * result + ( getCurppHistorial() == null ? 0 : this.getCurppHistorial().hashCode() );
         return result;
   }   


}


