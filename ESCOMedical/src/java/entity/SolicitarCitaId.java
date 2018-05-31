package entity;
// Generated 31/05/2018 09:05:04 AM by Hibernate Tools 4.3.1



/**
 * SolicitarCitaId generated by hbm2java
 */
public class SolicitarCitaId  implements java.io.Serializable {


     private String curpp;
     private String curpm;

    public SolicitarCitaId() {
    }

    public SolicitarCitaId(String curpp, String curpm) {
       this.curpp = curpp;
       this.curpm = curpm;
    }
   
    public String getCurpp() {
        return this.curpp;
    }
    
    public void setCurpp(String curpp) {
        this.curpp = curpp;
    }
    public String getCurpm() {
        return this.curpm;
    }
    
    public void setCurpm(String curpm) {
        this.curpm = curpm;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SolicitarCitaId) ) return false;
		 SolicitarCitaId castOther = ( SolicitarCitaId ) other; 
         
		 return ( (this.getCurpp()==castOther.getCurpp()) || ( this.getCurpp()!=null && castOther.getCurpp()!=null && this.getCurpp().equals(castOther.getCurpp()) ) )
 && ( (this.getCurpm()==castOther.getCurpm()) || ( this.getCurpm()!=null && castOther.getCurpm()!=null && this.getCurpm().equals(castOther.getCurpm()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCurpp() == null ? 0 : this.getCurpp().hashCode() );
         result = 37 * result + ( getCurpm() == null ? 0 : this.getCurpm().hashCode() );
         return result;
   }   


}


